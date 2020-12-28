package com.heyi.meike.appium.tool;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CmdTools {
    public static void main(String[] args) throws  Exception {
//        startAppiumByPort(4247);
//        taskkillProcess(4247);
        killByPid("7472");

    }
    /**
     * 获取设备信息
     * */
    public  static List<String> getAdbDevices() throws Exception{
        List<String> deviceList = new ArrayList<>();

        Process process = Runtime.getRuntime().exec("adb devices");

        InputStream inputStream = process.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"gbk");
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        String line;
//        System.out.println("11"+bufferedReader.readLine().toString());
        int cmdLine = 1;
        while((line=bufferedReader.readLine())!=null)
        {
            if (line==""){
                continue;
            }
            if(cmdLine>1){
                if(!line.isEmpty()){
                    line = line.substring(0,line.lastIndexOf("\t"));
                    deviceList.add(line);
                }
            }
            cmdLine++;
        }
        System.out.println(deviceList.toString());
        return deviceList;
    }
    /**
     * 启动特定端口的appium服务
     * */
    public static void startAppiumByPort(int port) throws  Exception{
//        String startAppiumByPort = "appium -a 127.0.0.1 -p 4723 --session-override";
//        String startAppium = "appium";
        StringBuffer startAppiumBuffer = new StringBuffer();
        startAppiumBuffer.append("cmd.exe /c start cmd.exe /k\t");
        startAppiumBuffer.append("\"");
        startAppiumBuffer.append("appium\t");
        startAppiumBuffer.append("-a\t");
        startAppiumBuffer.append("127.0.0.1\t");
        startAppiumBuffer.append("-p\t");
        startAppiumBuffer.append(port+"\t");
        startAppiumBuffer.append("--session-override");
        startAppiumBuffer.append("\"");
        String startAppium = startAppiumBuffer.toString();
        Process process = Runtime.getRuntime().exec(startAppium);

        InputStream inputStream = process.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"gbk");
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        String line;
        while((line=bufferedReader.readLine())!=null)
        {
            System.out.println(line);
        }
    }
    /**
     * 关闭特定端口的进程
     * */
    public static void taskkillProcess(int port) throws Exception{

        StringBuffer startAppiumBuffer = new StringBuffer();
        startAppiumBuffer.append("cmd.exe /c \t");
        startAppiumBuffer.append("\"");
        startAppiumBuffer.append("netstat -aon|findstr\t");
        startAppiumBuffer.append(port);
        startAppiumBuffer.append("\"");
        String portCmd = startAppiumBuffer.toString();
        Process portProcess = Runtime.getRuntime().exec(portCmd);

        InputStream portInputStream = portProcess.getInputStream();
        InputStreamReader portInputStreamReader = new InputStreamReader(portInputStream,"gbk");
        BufferedReader portBufferedReader=new BufferedReader(portInputStreamReader);
        String line;
        while((line=portBufferedReader.readLine())!=null)
        {
            String pid = line.substring(line.lastIndexOf("       ")+7);
            System.out.println(pid);
        }
    }
    /**
     * 关闭副端口
     * */
    public static void killByPid(String pid) throws  Exception{
        String  pidCmd = "taskkill /F /pid 9896";
        Process portProcess = Runtime.getRuntime().exec(pidCmd);
        InputStream portInputStream = portProcess.getInputStream();
        InputStreamReader portInputStreamReader = new InputStreamReader(portInputStream,"gbk");
        BufferedReader portBufferedReader=new BufferedReader(portInputStreamReader);
        String line;
        while((line=portBufferedReader.readLine())!=null)
        {
            System.out.println(line);
        }
    }
}
