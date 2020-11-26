package xyz.fcidd.bancommandplus.handler;

import xyz.fcidd.bancommandplus.config.LoadConfig;

import java.io.*;

public class ConfigHandler {
    public static void creat() throws IOException {
        //读取resource目录下的config.properties
        InputStream src = LoadConfig.class.getClassLoader().getResourceAsStream("config.properties");
        //目标文件夹
        File file = new File("./plugins/BanCommandPlus/");
        File file2=new File("./plugins/BanCommandPlus/config.properties");
        //如果该文件夹没有创建
        if(!file2.exists()){
            //创建文件夹
            file.mkdirs();
            //将文件输出到/plugins/BanCommandPlus/config.properties
            RandomAccessFile raf = new RandomAccessFile("./plugins/BanCommandPlus/config.properties", "rw");
            byte[] data = new byte[1024 * 10];//10kb
            int len = 0;
            while ((len = src.read(data)) != -1) {
                raf.write(data, 0, len);
            }
            src.close();
            raf.close();
        }

    }
}