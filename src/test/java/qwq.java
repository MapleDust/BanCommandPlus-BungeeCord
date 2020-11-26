import xyz.fcidd.bancommandplus.config.LoadConfig;

import java.io.*;

public class qwq<T> {
    public static void main(String[] args) throws IOException {
        InputStream src = LoadConfig.class.getClassLoader().getResourceAsStream("config.properties");
        File file=new File("./BanCommandPlus");
        System.out.println(file.getAbsolutePath());
        boolean b=file.mkdir();
        RandomAccessFile raf=new RandomAccessFile("./BanCommandPlus/config.properties","rw");
        byte[] data=new byte[1024*10];//10kb
        int len=0;
        while ((len=src.read(data))!=-1){
            raf.write(data,0,len);
        }
        src.close();
        raf.close();
    }
}
