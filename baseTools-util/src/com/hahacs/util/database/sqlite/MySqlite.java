package com.hahacs.util.database.sqlite;

import SQLite.*;  

public class MySqlite {
	Database db=new Database();  
    public static void main(String[] args) {  
    	MySqlite s=new MySqlite();  
        System.out.println(s.db.version());  
}
}
