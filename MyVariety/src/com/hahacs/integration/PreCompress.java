package com.hahacs.integration;

import java.io.File;

import com.hahacs.util.zip.MyZip4j;
import com.hahacs.util.zip.MyZipCompressing;

public class PreCompress {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String fileName = "80155";
		
		String password = "liyys";
		
		String file_root_directory = "G:\\";
		String file_current_directory = "variety001\\";	
		String file_zip_directory = "zip_variety_temp_upload\\";
		
		// D:\\variety001\\
		String file_original_path = file_root_directory+file_current_directory;
		
		// D:\\temp_upload_variety\\
		String file_zip_pathString = file_root_directory+file_zip_directory;
		
		
		String oldFilePath = file_original_path + fileName;// D:\\variety001\\80155	
		String newFilePath =file_zip_pathString+fileName+".zip";// D:\\temp_upload_variety\\80155.zip
		
//		doCompress(fileName, password, file_original_path, file_zip_pathString);//ѹ�������ļ�
//		doCompressSimple(newPath,oldPath);//��������ѹ��
		
		doCompressFive(fileName, password, file_original_path, file_zip_pathString);//����ѹ��5���ļ�
		

		
	}


	/**
	 * @Title: doCompress
	 * @Description: ������ĵ����ļ�ѹ��
	 * @param fileName
	 * @param password
	 * @param oldFilePath
	 * @param newFilePath    
	 * @return void 
	 * @author wuhaopeng
	 * @date 2016-10-9 ����11:05:22
	 */
	private static void doCompress(String fileName, String password,
			String oldFilePath, String newFilePath) {
		MyZip4j myZip = new MyZip4j();
		
//		oldFilePath = "D:\\variety001\\80155";
//		newFilePath = "D:\\temp_upload\\80155.zip";
		
		myZip.doZip(oldFilePath, newFilePath, fileName, password);
	}
	
	/**
	 * @Title: doCompressBatch
	 * @Description: ����ִ��ѹ�������ļ�
	 * @param fileName
	 * @param password
	 * @param oldFilePath
	 * @param newFilePath
	 * @param number    
	 * @return void 
	 * @author wuhaopeng
	 * @date 2016-10-10 ����12:31:35
	 */
	private static void doCompressBatch(String fileName, String password,
			String oldFilePath, String newFilePath,int number) {
		MyZip4j myZip = new MyZip4j();
		
		myZip.doZipNumber(oldFilePath, newFilePath, fileName, password, number);
	}
	
	/**
	 * @Title: doCompressFive
	 * @Description: ���ļ�������ִ��5��ѹ�������ļ�
	 * @param fileName
	 * @param password
	 * @param oldFilePath
	 * @param newFilePath    
	 * @return void 
	 * @author wuhaopeng
	 * @date 2016-10-10 ����1:23:23
	 */
	private static void doCompressFive(String fileName, String password,
			String oldFilePath, String newFilePath) {
		MyZip4j myZip = new MyZip4j();
		
		myZip.doZipNumber(oldFilePath, newFilePath, fileName, password, 5);
	}
	
	
	/**
	 * 
	 * @Title: doCompress
	 * @Description: ���������ѹ���ļ�
	 * @param newPath
	 * @param oldPath    
	 * @return void 
	 * @author wuhaopeng
	 * @date 2016-10-9 ����10:49:25
	 */
	public static void doCompressSimple (String newPath,String oldPath){
		MyZipCompressing book = new MyZipCompressing();  
	      try {  
	          book.zip(newPath,  
	                  new File(oldPath));  
	      } catch (Exception e) {    
	          e.printStackTrace();  
	      }  
	}
	


}
