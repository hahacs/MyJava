package com.hahacs.csv;


import java.math.BigDecimal;
import java.nio.charset.Charset;

import com.csvreader.CsvReader;
import com.hahacs.vo.TwoNumber;

public class MyJavaCsv {
	
	public TwoNumber importCsv1(String file) throws Exception{
//		file = "H:\\03�м�����\\�˻����\\csv\\20160922_zhye-yh-cqg_157268.csv";
		CsvReader r = new CsvReader(file, ',',Charset.forName("GBK"));
		
		//��ȡ��ͷ
        r.readHeaders();
      
        BigDecimal amount = new BigDecimal(0.00);
        BigDecimal freeAmount = new BigDecimal(0.00);
        
        
        
        //������ȡ��¼��ֱ������
        while (r.readRecord()) {
            //��ȡһ����¼
//            System.out.println(r.getRawRecord());

            amount = amount.add(new BigDecimal(r.get(1)));
            freeAmount = freeAmount.add(new BigDecimal(r.get(2)));
            
        }
        r.close();
//        System.out.println(amount);
//        System.out.println(freeAmount);
        TwoNumber two = new TwoNumber(amount,freeAmount);
        return two;
	}
	
}
