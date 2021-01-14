package com.heyi.meike.doing.app;

import com.heyi.meike.tools.cmd.CmdTools;

public class InstallApp {
    public static void main(String[] args) throws Exception {
        CmdTools.uninstallAppByDevices("com.heyi.meike");
        Thread.sleep(10000);
        CmdTools.installAPPByDevices("D:\\heyi\\meike\\js\\app\\android\\app\\build\\outputs\\apk\\preview\\meike_preview-v_1.1.5.apk");
    }
}