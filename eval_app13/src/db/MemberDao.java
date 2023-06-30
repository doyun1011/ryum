package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.MemberVO;

public class MemberDao {
	DBConnPool db = new DBConnPool();
	private Connection conn = db.con;

	public void register(MemberVO member) {
		String sql = "INSERT INTO tbl_member13 (name, id, pw, tel, addr) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstt = conn.prepareStatement(sql);
			pstt.setString(1, member.getName());
			pstt.setString(2, member.getId());
			pstt.setString(3, member.getPw());
			pstt.setString(4, member.getTel());
			pstt.setString(5, member.getAddr());

			pstt.executeUpdate();
			

			System.out.println("Member registered successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getId(String id) {
		String sql = "SELECT COUNT(*) FROM tbl_member13 WHERE id = ?";
		try {
			PreparedStatement pstt = conn.prepareStatement(sql);
			pstt.setString(1, id);
			ResultSet rs = pstt.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getTel(String tel) {
		String sql = "SELECT COUNT(*) FROM tbl_member13 WHERE tel = ?";
		try (PreparedStatement pstt = conn.prepareStatement(sql)) {
			pstt.setString(1, tel);
			ResultSet rs = pstt.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
