package com.hahacs.dotest;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.nio.charset.Charset;

import com.csvreader.CsvReader;
import com.hahacs.csv.MyJavaCsv;
import com.hahacs.util.MathUtils;
import com.hahacs.vo.TwoNumber;

public class Test2 {
	public static void main(String[] args) throws Exception{

		MyJavaCsv javaCsv = new MyJavaCsv();
		String file = "H:\\03中间数据\\账户余额\\csv\\20160922_zhye-yh-cqg_157268.csv";
		
		TwoNumber kk = javaCsv.importCsv1(file);
		
		
//		BigDecimal amount = MathUtils.getBigDecimal(kk.a);
//		BigDecimal freezAmount = MathUtils.getBigDecimal(kk.b);
		BigDecimal amount = (BigDecimal)kk.a;
		BigDecimal freezAmount = (BigDecimal)kk.b;
		
//		System.out.println(kk.a);
		
		System.out.println(amount);
		System.out.println(freezAmount);
	}
}
