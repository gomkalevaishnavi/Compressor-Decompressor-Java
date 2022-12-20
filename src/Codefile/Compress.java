/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codefile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import javax.imageio.stream.FileImageInputStream;

/**
 *
 * @author vaish
 */
public class Compress {
    public static void compressFunction(File file) throws FileNotFoundException, IOException{
        String fileDirectory = file.getParent(); 
        System.out.println(fileDirectory);
        FileInputStream fis = new FileInputStream(file);//read the output content
        FileOutputStream fos = new FileOutputStream(fileDirectory +"/CompressedFile.gz"); //copmress file stored output
        GZIPOutputStream gzipOs = new GZIPOutputStream(fos); 
        
        byte[] buffer = new byte[1024];
        int len;
        while((len=fis.read(buffer))!=-1){
            gzipOs.write(buffer, 0, len);
        }
        gzipOs.close();
        fos.close();
        fis.close();
    }
    public static void main(String[] args) throws IOException{
        File path = new File("C:\\Users\\vaish\\Desktop\\abcd.txt");
        
        compressFunction(path);
    }
}
