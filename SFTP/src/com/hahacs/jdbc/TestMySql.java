package com.hahacs.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement; 

public class TestMySql {
	
    static String sql = null;  
    static MySqlCreate db1 = null;  
    static ResultSet ret = null; 
    static MySqlExec mySqlExec= null;
	
	public static void main(String[] args){
		sql = "select *from tab_user_info t limit 100";//SQL���  
        db1 = new MySqlCreate();//����MySqlCreate����  
        
        ret= mySqlExec.doSql(db1, sql);
        mySqlExec.getAll(ret);
  
        try {
			ret.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        db1.close();
    }  
}

