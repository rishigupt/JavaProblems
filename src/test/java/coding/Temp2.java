package coding;

import java.io.*;
import java.util.Scanner;

public class Temp2 {
    public static void main(String[] args) {
        String dirPath = "folder" + File.separator + "anotherFolder"+ File.separator;
        File dir = new File(dirPath);
        if (!dir.exists()){
            dir.mkdirs();
        }


        File file = new File(dirPath + File.separator +"MyFile.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write("my new file".getBytes());
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.canWrite());

        try {
            FileInputStream fis = new FileInputStream(file);
            int i;
            while((i = fis.read()) != -1){
                System.out.print((char) i);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //file.delete();
























        /*try {
            FileWriter fileWriter = new FileWriter(file);
             fileWriter.write("first attempt");
             fileWriter.append('s');
             fileWriter.flush();
             fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileReader fileReader = new FileReader(file);
            int i;
            while((i = fileReader.read()) != -1){
                System.out.print((char)i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/


    }
}
