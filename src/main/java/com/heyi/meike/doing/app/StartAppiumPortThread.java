package com.heyi.meike.doing.app;

import com.heyi.meike.tools.cmd.CmdTools;

import java.util.List;

public class StartAppiumPortThread extends Thread{
    private int port;
    public StartAppiumPortThread(int port){
        this.port=port;
    }
    @Override
    public  void run(){
        try {
            CmdTools.startAppiumByPort(port);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws  Exception{
        List<String> deviceList = CmdTools.getAdbDevices();
        int length=deviceList.size();
        int port=4721;
        for(int i=0;i<length;i++){
            port++;
            System.out.println(port);
            new StartAppiumPortThread(port).start();
        }
    }
}
