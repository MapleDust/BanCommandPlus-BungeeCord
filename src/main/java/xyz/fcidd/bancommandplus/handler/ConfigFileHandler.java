package xyz.fcidd.bancommandplus.handler;

import net.md_5.bungee.config.Configuration;
import xyz.fcidd.bancommandplus.config.LoadConfig;

import java.io.*;
import java.util.Collection;

public class ConfigFileHandler {
    public static void create() throws IOException {
        // 目标文件夹
        File file = new File("./plugins/BanCommandPlus/");
        File file2 = new File("./plugins/BanCommandPlus/config.yml");
        // 读取resource目录下的config.properties
        InputStream src = ConfigFileHandler.class.getClassLoader().getResourceAsStream("config.yml");
        RandomAccessFile raf;
        // 以10kb读取文件
        byte[] data = new byte[1024 * 10];
        // 文件长度
        int len = 0;
        // 如果文件不存在
        if (!file2.exists()) {
            // 创建文件夹
            file.mkdirs();
            // 将文件输出到/plugins/BanCommandPlus/config.yml
            raf = new RandomAccessFile("./plugins/BanCommandPlus/config.yml", "rw");
            // 将config.properties写入数据
            while ((len = src.read(data)) != -1) {
                raf.write(data, 0, len);
            }
        } else {
            Configuration configuration = LoadConfig.loadConfig();
            Collection<String> keys = configuration.getKeys();
            if (!keys.contains("banned-command")) {
                raf = new RandomAccessFile("./plugins/BanCommandPlus/config.yml", "rw");
                // 向config.yml写入数据
                // loadConfig.set("banned-command", "");
                src.read(data);
                byte[] arr1 = new byte[137];
                // src：byte源数组
                // srcPos：截取源byte数组起始位置（0位置有效）
                // dest,：byte目的数组（截取后存放的数组）
                // destPos：截取后存放的数组起始位置（0位置有效）
                // length：截取的数据长度
                System.arraycopy(data, 0, arr1, 0, 137);
                raf.write(arr1);
                raf.close();
            }
            if (!keys.contains("main-command")) {
                raf = new RandomAccessFile("./plugins/BanCommandPlus/config.yml", "rw");
                // 向config.yml写入数据
                // loadConfig.set("banned-command", "");
                raf.seek(raf.length());
                src.read(data);
                byte[] arr2 = new byte[67];
                // src：byte源数组
                // srcPos：截取源byte数组起始位置（0位置有效）
                // dest,：byte目的数组（截取后存放的数组）
                // destPos：截取后存放的数组起始位置（0位置有效）
                // length：截取的数据长度
                System.arraycopy(data, 137, arr2, 0, 67);
                raf.write(arr2);
                raf.close();
            }
        }
        src.close();
        LoadConfig.loadConfig();
    }
}