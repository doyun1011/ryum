package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DBcon;
import vo.CommentVO;

public class CommentDAO {

	public ArrayList<CommentVO> getAll() {
		ArrayList<CommentVO> clist = new ArrayList<>();
		String query = "SELECT * FROM comment;";
		Connection con = DBcon.getCon();
		try {
			PreparedStatement pstt = con.prepareStatement(query);
			ResultSet rs = pstt.executeQuery();
			
			while(rs.next()) {
				CommentVO c = new CommentVO();
				c.setBnum(rs.getInt("cnum"));
				c.setId(rs.getString("id"));
				c.setContent(rs.getString("content"));
				c.setWriter(rs.getString("writer"));
				c.setDate(rs.getDate("c_date").toLocalDate());
				c.setMdDate(rs.getDate("c_modify_date").toLocalDate());
				c.setBnum(rs.getInt("bnum"));
				clist.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clist;
	}
}
