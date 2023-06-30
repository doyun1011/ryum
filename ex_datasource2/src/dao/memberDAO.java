package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DBcon;
import vo.MemberVO;

public class memberDAO {

	
	public int reg(MemberVO m) {
		int result = 0;
		String query = "INSERT INTO MEMBER VALUES('관리자', 'admin','123','01011112222','부산 부전동');";
		DBcon db = new DBcon();
        Connection con = db.getCon();
		try {
			PreparedStatement pstt = con.prepareStatement(query);
			result = pstt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
            db.close(); // 커넥션 반환
        }
		return result;
	}
}
