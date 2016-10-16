package com.hahacs;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.hahacs.csv.MyJavaCsv;
import com.hahacs.sftp.MySFTP;
import com.hahacs.vo.TwoNumber;
import com.hahacs.zip.CopyOfMyzipDecompressing;
import com.jcraft.jsch.ChannelSftp;

public class JustDoIt {
	public static void main(String[] args){
		MySFTP sf = new MySFTP();
		MyJavaCsv javaCsv = new MyJavaCsv();
		TwoNumber twoValue = null;
		
		
		Calendar   cal   =   Calendar.getInstance();
		  cal.add(Calendar.DATE,   -1);
		  String yesterday = new SimpleDateFormat( "yyyyMMdd").format(cal.getTime());
		  System.out.println(yesterday);
		  
		  String downloadFile = yesterday +"_zhye-yh-cqg.zip";
		  
		  String oldDownPath = "H:\\03�м�����\\�˻����\\zip\\";
		  oldDownPath = oldDownPath +downloadFile;
		  String newDownPath = "H:\\03�м�����\\�˻����\\csv";
		  
		  //��ѹ��õ����ļ���
		  String newFileNamePath = "H:\\03�м�����\\�˻����\\csv\\";
		  String fileName = "";
		  
		if(sf.downLoadFile1(downloadFile)){
			System.out.println("�����ļ��ɹ���");
			CopyOfMyzipDecompressing cmzip = new CopyOfMyzipDecompressing();
			fileName = cmzip.jieyafile(oldDownPath, newDownPath);
			newFileNamePath =newFileNamePath + fileName;
			System.out.println("��ѹ�ɹ�");
			
			try {
				twoValue = javaCsv.importCsv1(newFileNamePath);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			BigDecimal amount = (BigDecimal)twoValue.a;
			BigDecimal freezAmount = (BigDecimal)twoValue.b;
			
			System.out.println(amount);
			System.out.println(freezAmount);
			
			
			
			System.out.println(fileName.substring(4, 8)+"ƽ̨�˻����"+amount.divide(new BigDecimal(10000.00)).setScale(0, BigDecimal.ROUND_HALF_UP)+"��,�������"+
					freezAmount.divide(new BigDecimal(10000.00)).setScale(0, BigDecimal.ROUND_HALF_UP)+"��");
			
		}
		  
		  
	}
}