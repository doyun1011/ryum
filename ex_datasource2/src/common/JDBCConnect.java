package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;

public class JDBCConnect {

	public Connection con;
	public Statement stmt;
	public PreparedStatement pstt;
	public ResultSet rs;
	
	
	public JDBCConnect() {
		try {
			// JDBC 드라이버 로드
			Class.forName("org.mariadb.jdbc.Driver");
			
			
			//DB 연결
			String url = "jdbc:mariadb://localhost:3306/green01";
			String id = "root";
			String pw = "1234";
			con = DriverManager.getConnection(url, id, pw);
			
			System.out.println("DB 연결 성공1");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		//연결 해제(자원반납)
		public void close() {
			try {
				if(rs != null) 
					rs.close();
				if(stmt != null) 
					stmt.close();
				if(pstt != null)
					pstt.close();
				if (con !=null)
					con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		public JDBCConnect(String driver, String url, String id, String pw) {
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, id, pw);
				System.out.println("DB 연결 성공2");
			}catch(Exception e) {
				
			}
		}
		
		
		public JDBCConnect(ServletContext application) {
			String driver = application.getInitParameter("MariaDriver");
			String url = application.getInitParameter("MariaUrl");
			String id = application.getInitParameter("MariaId");
			String pw = application.getInitParameter("MariaPw");
			
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, id, pw);
				System.out.println("DB 연결 성공3");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}


