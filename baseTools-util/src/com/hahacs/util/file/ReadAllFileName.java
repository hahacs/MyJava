package com.hahacs.util.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ReadAllFileName {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("ke");
		try {
            readfile("F:\\001可乐云项目\\缓存区文本");
            // deletefile("D:/file");
    } catch (FileNotFoundException ex) {
    } catch (IOException ex) {
    }
    System.out.println("ok");


	}

	 public static String[] readfile(String filepath) throws Exception {
//		 ArrayList<String>  strArray = new ArrayList<String> (); 
		 String[] filelist = new String[]{};
         try {

                 File file = new File(filepath);
                 if (!file.isDirectory()) {
                         System.out.println("文件");
                         System.out.println("path=" + file.getPath());
                         System.out.println("absolutepath=" + file.getAbsolutePath());
                         System.out.println("name=" + file.getName());

                 } else if (file.isDirectory()) {
                         System.out.println("文件夹");
                         filelist = file.list();
                         
                         for (int i = 0; i < filelist.length; i++) {
                                 File readfile = new File(filepath + "\\" + filelist[i]);
                                 if (!readfile.isDirectory()) {
                                         System.out.println("path=" + readfile.getPath());
                                         System.out.println("absolutepath="
                                                         + readfile.getAbsolutePath());
                                         System.out.println("name=" + readfile.getName());

                                 } else if (readfile.isDirectory()) {
                                         readfile(filepath + "\\" + filelist[i]);
                                 }
                         }
                         
                         return filelist;

                 }

         } catch (FileNotFoundException e) {
                 System.out.println("readfile()   Exception:" + e.getMessage());
         }
         return filelist ;
 }

 /**
  * 删除某个文件夹下的所有文件夹和文件
  */
 
 
 /*public static boolean deletefile(String delpath)
                 throws FileNotFoundException, IOException {
         try {

                 File file = new File(delpath);
                 if (!file.isDirectory()) {
                         System.out.println("1");
                         file.delete();
                 } else if (file.isDirectory()) {
                         System.out.println("2");
                         String[] filelist = file.list();
                         for (int i = 0; i < filelist.length; i++) {
                                 File delfile = new File(delpath + "\\" + filelist[i]);
                                 if (!delfile.isDirectory()) {
                                         System.out.println("path=" + delfile.getPath());
                                         System.out.println("absolutepath="
                                                         + delfile.getAbsolutePath());
                                         System.out.println("name=" + delfile.getName());
                                         delfile.delete();
                                         System.out.println("删除文件成功");
                                 } else if (delfile.isDirectory()) {
                                         deletefile(delpath + "\\" + filelist[i]);
                                 }
                         }
                         file.delete();

                 }

         } catch (FileNotFoundException e) {
                 System.out.println("deletefile()   Exception:" + e.getMessage());
         }
         return true;
 }*/
}
