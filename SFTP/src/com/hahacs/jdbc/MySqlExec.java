package com.hahacs.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlExec {
	
	public ResultSet doSql(MySqlCreate mySqlDb,String sql){
		
		PreparedStatement pst = null;
		ResultSet ret = null; 
		
		try {  
        	pst = mySqlDb.conn.prepareStatement(sql);
            ret = pst.executeQuery();//执行语句，得到结果集  
 
            pst.close(); 
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
		return ret;
	}
	
	public void getAll(ResultSet ret){
		try {
			while (ret.next()) {  
			    String uid = ret.getString(1);  
			    String ufname = ret.getString(2);  
			    String ulname = ret.getString(3);  
			    String udate = ret.getString(4);  
			    System.out.println(uid + "\t" + ufname + "\t" + ulname + "\t" + udate );  
			}
		} catch (SQLException e) {
			System.err.println("读取ret失败");
			e.printStackTrace();
		}//显示数据  
        try {
			ret.close();
		} catch (SQLException e) {
		
			System.err.println("关闭ret失败");
			e.printStackTrace();
		}
	}
	
}
