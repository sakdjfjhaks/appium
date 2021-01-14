package com.heyi.meike.tools.preinstall;

public class PreInstall {
    public static void main(String[] args) throws Exception{
        new Thread(new VivoPreviewInstallThread(4723,"c727860c7cf5"));
    }
}
