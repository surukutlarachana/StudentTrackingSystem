package com.ats.dto.impl;

import java.sql.Connection;
import java.sql.DriverManager;



import com.ats.dto.DbProvider;

public class DbProviderImpl implements DbProvider {
	static Connection con=null;
	public static Connection getConn(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(connUrl,username,pwd);
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
}
