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
		  
		  String oldDownPath = "H:\\03中间数据\\账户余额\\zip\\";
		  oldDownPath = oldDownPath +downloadFile;
		  String newDownPath = "H:\\03中间数据\\账户余额\\csv";
		  
		  //解压后得到的文件名
		  String newFileNamePath = "H:\\03中间数据\\账户余额\\csv\\";
		  String fileName = "";
		  
		if(sf.downLoadFile1(downloadFile)){
			System.out.println("下载文件成功！");
			CopyOfMyzipDecompressing cmzip = new CopyOfMyzipDecompressing();
			fileName = cmzip.jieyafile(oldDownPath, newDownPath);
			newFileNamePath =newFileNamePath + fileName;
			System.out.println("解压成功");
			
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
			
			
			
			System.out.println(fileName.substring(4, 8)+"平台账户余额"+amount.divide(new BigDecimal(10000.00)).setScale(0, BigDecimal.ROUND_HALF_UP)+"万,冻结余额"+
					freezAmount.divide(new BigDecimal(10000.00)).setScale(0, BigDecimal.ROUND_HALF_UP)+"万");
			
		}
		  
		  
	}
}
