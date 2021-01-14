package com.heyi.meike.tools.thread;

import com.heyi.meike.tools.cmd.CmdTools;

public class StartAppiumByPortThread extends Thread{
    private int port;

    public StartAppiumByPortThread(int port){
        this.port=port;
    }
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    @Override
    public void run(){
        try {
            if(!CmdTools.getPidByPort(port)){
                CmdTools.startAppiumByPort(port);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
