package com.hahacs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.hahacs.csv.SimpleCSVUtils;

public class test {
	public static void main(String[] args){
		System.out.println("123");
//		H:\\03�м�����\\�˻����\\zip\\20160921_zhye-yh-cqg.zip
		SimpleCSVUtils simpleCSVUtils = new SimpleCSVUtils();
		
		File file = new File("H:\\03�м�����\\�˻����\\csv\\20160922_zhye-yh-cqg_157268.csv");

		List<String> dataList= simpleCSVUtils.importCsv(file);
		if(dataList!=null && !dataList.isEmpty()){
            for(String data : dataList){
                System.out.println(data);
            }
        }
		System.out.println("234");
	}
}
