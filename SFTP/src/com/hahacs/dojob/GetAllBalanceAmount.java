package com.hahacs.dojob;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import com.hahacs.MyFile;
import com.hahacs.csv.MyJavaCsv;
import com.hahacs.vo.TwoNumber;


//��ȡĳ���ļ������������ڵ��˻����Ͷ����������
public class GetAllBalanceAmount {
	public static void main(String [] args) throws Exception, IOException{
		
		String filepath = "H:\\03�м�����\\�˻����\\csv";
		
		TwoNumber twoValue = null;
		MyJavaCsv javaCsv = new MyJavaCsv();
		
		List<String> fileList = MyFile.readfile(filepath);
		
		for(String newFileName:fileList){
//			System.out.println(newFileName);
			String newFileNamePath = "";
			newFileNamePath = filepath+"\\"+newFileName;
			try {
				twoValue = javaCsv.importCsv1(newFileNamePath);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			BigDecimal amount = (BigDecimal)twoValue.a;
			BigDecimal freezAmount = (BigDecimal)twoValue.b;
			
//			System.out.println(amount);
//			System.out.println(freezAmount);
			
			System.out.println(amount+"    "+newFileName.substring(4, 8));
			System.out.println(freezAmount+"    "+newFileName.substring(4, 8));
			
//			System.out.println(newFileName.substring(4, 8)+"ƽ̨�˻����"+amount.divide(new BigDecimal(10000.00)).setScale(0, BigDecimal.ROUND_HALF_UP)+"��,�������"+
//					freezAmount.divide(new BigDecimal(10000.00)).setScale(0, BigDecimal.ROUND_HALF_UP)+"��");
			
//			System.out.println(newFileName.substring(4, 8)+freezAmount);
		}
		
	}
}
