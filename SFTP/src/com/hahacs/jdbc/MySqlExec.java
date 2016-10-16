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
            ret = pst.executeQuery();//ִ����䣬�õ������  
 
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
			System.err.println("��ȡretʧ��");
			e.printStackTrace();
		}//��ʾ����  
        try {
			ret.close();
		} catch (SQLException e) {
		
			System.err.println("�ر�retʧ��");
			e.printStackTrace();
		}
	}
	
}
