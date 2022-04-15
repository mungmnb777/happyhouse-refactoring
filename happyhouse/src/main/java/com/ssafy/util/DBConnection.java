package com.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
   static final String URL = "jdbc:mysql://127.0.0.1:3306/happyhouse?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
   static final String ID = "ssafy";
   static final String PASSWORD = "ssafy";

   public static Connection getConnection() throws SQLException {
      return DriverManager.getConnection(URL, ID, PASSWORD);
   }

   public void close(AutoCloseable... closeables) {
      for (AutoCloseable c : closeables) {
         if (c != null) {
            try {
               c.close();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      }
   }
}



/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/ssafydb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	private static final String DB_ID = "ssafy";
	private static final String DB_PASS = "lord!%(@6535";
	
	static {
		try {
			Class.forName(DRIVER);
//			System.out.println("드라이버 로딩 성공!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
//			System.out.println("드라이버 로딩 실패!!");
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL, DB_ID, DB_PASS);
	}
}*/
