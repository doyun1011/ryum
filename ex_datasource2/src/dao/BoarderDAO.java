package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBcon;
import vo.BorderVO;

public class BoarderDAO {
    private Connection connection;
    DBcon db = new DBcon();

    public BoarderDAO() {
        this.connection = db.getCon();
    }

    public void close() {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<BorderVO> getAll() {
        List<BorderVO> borders = new ArrayList<>();
        try {
            String query = "SELECT * FROM reply;";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                BorderVO border = new BorderVO();
                border.setNum(resultSet.getInt("bnum"));
                border.setId(resultSet.getString("id"));
                border.setTitle(resultSet.getString("title"));
                border.setWriter(resultSet.getString("writer"));
                border.setDate(resultSet.getDate("date").toLocalDate());
                border.setMdDate(resultSet.getDate("modify_date").toLocalDate());
                border.setContent(resultSet.getString("content"));
                border.setRp(resultSet.getString("rp_cnt"));

                borders.add(border);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.close(); // 커넥션 반환
        }

        return borders;
    }
    public BorderVO get(int bnum) {
        BorderVO border = null;
        try {
            String query = "SELECT * FROM border WHERE bnum = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, bnum);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                border = new BorderVO();
                border.setNum(resultSet.getInt("bnum"));
                border.setId(resultSet.getString("id"));
                border.setTitle(resultSet.getString("title"));
                border.setWriter(resultSet.getString("writer"));
                border.setDate(resultSet.getDate("date").toLocalDate());
                border.setMdDate(resultSet.getDate("modify_date").toLocalDate());
                border.setContent(resultSet.getString("content"));
                border.setRp(resultSet.getString("rp"));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.close(); // 커넥션 반환
        }

        return border;
    }

    public int insert(BorderVO border) {
    	int result = 0;
        try {
            String query = "INSERT INTO border(bnum, id, title, writer, date, modify_date, content) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, border.getNum());
            statement.setString(2, border.getId());
            statement.setString(3, border.getTitle());
            statement.setString(4, border.getWriter());
            statement.setDate(5, java.sql.Date.valueOf(border.getDate()));
            statement.setDate(6, java.sql.Date.valueOf(border.getMdDate()));
            statement.setString(7, border.getContent());

            result = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.close(); // 커넥션 반환
        }
        return result;
    }

    public int modify(BorderVO border, int bnum) {
    	int result = 0;
        try {
            String query = "UPDATE border SET bnum = ?, id = ?, title = ?, writer = ?, date = ?, modify_date = ?, content = ? WHERE bnum = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, border.getNum());
            statement.setString(2, border.getId());
            statement.setString(3, border.getTitle());
            statement.setString(4, border.getWriter());
            statement.setDate(5, java.sql.Date.valueOf(border.getDate()));
            statement.setDate(6, java.sql.Date.valueOf(border.getMdDate()));
            statement.setString(7, border.getContent());
            statement.setInt(8, bnum);

            result = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.close(); // 커넥션 반환
        }
        return result;
    }

    public int delete(int bnum) {
    	int result = 0;
        try {
            String query = "DELETE FROM border WHERE bnum = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, bnum);

            result = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.close(); // 커넥션 반환
        }
        return result;
    }
}