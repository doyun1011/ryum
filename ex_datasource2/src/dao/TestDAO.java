package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnPool;
import common.TestVO;
import vo.BorderVO;

public class TestDAO {

	ArrayList<BorderVO> blist = new ArrayList<>();
	public ArrayList<BorderVO> get() {
		DBConnPool db = new DBConnPool();
		Connection con = db.getCon();
		String query = "SELECT * FROM border;";
		try {
			PreparedStatement pstt = con.prepareStatement(query);
			ResultSet rs = pstt.executeQuery();
			
			while(rs.next()) {
				BorderVO b = new BorderVO();
				b.setNum(rs.getInt("bnum"));
				b.setTitle(rs.getString("title"));
				b.setWriter(rs.getString("writer"));
				b.setContent(rs.getString("content"));
				blist.add(b);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return blist;
		
	}
}
