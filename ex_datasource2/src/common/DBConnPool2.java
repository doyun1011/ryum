package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import lombok.Data;

@Data
public class DBConnPool2 {

	public Connection con;
	public Statement stmt;
	public PreparedStatement pstt;
	public ResultSet rs;

	public DBConnPool2() {

		try {
			// 커넥션 풀(DataSource) 얻기 javax.naming.Context;
			InitialContext initCtx = new InitialContext();
			Context ctx = (Context) initCtx.lookup("java:comp/env");
			DataSource source = (DataSource) ctx.lookup("dbcp.mydb");

			// 커넥션 풀읉 통해 커넥션 객체 얻기
			for (int i = 1; i <=21; i++) {
				con = source.getConnection();
				System.out.println("DB 커넥션 풀 연결 성공" + " " +i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstt != null)
				pstt.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
