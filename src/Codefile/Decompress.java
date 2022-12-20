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
import java.util.zip.GZIPInputStream;

/**
 *
 * @author vaish
 */
public class Decompress {
    public static void decmpressFunction(File file) throws FileNotFoundException, IOException{
        String fileDirectory = file.getParent(); 
        System.out.println(fileDirectory);
        
        FileOutputStream fos;
        try (FileInputStream fis = new FileInputStream(file); 
                GZIPInputStream gzipIS = new GZIPInputStream(fis)) {
            fos = new FileOutputStream(fileDirectory+"/DecompressedFile.txt");
            byte[] buffer = new byte[1024];
            int len;
            while((len= gzipIS.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }          }
        fos.close();
        
    }
    
    public static void main(String[] args) throws IOException{
        File path = new File("C:\\Users\\vaish\\Desktop\\CompressedFile.gz");
        decmpressFunction(path);
    }
}
