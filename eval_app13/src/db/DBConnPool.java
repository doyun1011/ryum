package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import lombok.Data;

@Data
public class DBConnPool {

	public Connection con;
	
	public DBConnPool() {
		
		try {
			InitialContext initCtx  = new InitialContext(); 
			Context ctx = (Context)initCtx.lookup("java:comp/env");
			DataSource source = (DataSource)ctx.lookup("dbcp.mydb");
			
			con = source.getConnection();
			
			System.out.println("DB 커넥션 연결 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
