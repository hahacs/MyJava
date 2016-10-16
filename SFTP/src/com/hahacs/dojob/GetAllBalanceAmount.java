package com.hahacs.dojob;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import com.hahacs.MyFile;
import com.hahacs.csv.MyJavaCsv;
import com.hahacs.vo.TwoNumber;


//获取某个文件夹下所有日期的账户余额和冻结余额数据
public class GetAllBalanceAmount {
	public static void main(String [] args) throws Exception, IOException{
		
		String filepath = "H:\\03中间数据\\账户余额\\csv";
		
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
			
//			System.out.println(newFileName.substring(4, 8)+"平台账户余额"+amount.divide(new BigDecimal(10000.00)).setScale(0, BigDecimal.ROUND_HALF_UP)+"万,冻结余额"+
//					freezAmount.divide(new BigDecimal(10000.00)).setScale(0, BigDecimal.ROUND_HALF_UP)+"万");
			
//			System.out.println(newFileName.substring(4, 8)+freezAmount);
		}
		
	}
}
