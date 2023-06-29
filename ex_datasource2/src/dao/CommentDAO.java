package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBcon;
import vo.CommentVO;

public class CommentDAO {
    private Connection connection;

    public CommentDAO() {
        this.connection = DBcon.getCon();
    }

    public void close() {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CommentVO> getAll() {
        List<CommentVO> comments = new ArrayList<>();
        try {
            String query = "SELECT * FROM comment";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CommentVO comment = new CommentVO();
                comment.setNum(resultSet.getInt("cnum"));
                comment.setId(resultSet.getString("id"));
                comment.setContent(resultSet.getString("content"));
                comment.setWriter(resultSet.getString("writer"));
                comment.setDate(resultSet.getDate("c_date").toLocalDate());
                comment.setMdDate(resultSet.getDate("c_modify_date").toLocalDate());
                comment.setBnum(resultSet.getInt("bnum"));

                comments.add(comment);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }

    public void delete(int cnum) {
        try {
            String query = "DELETE FROM comment WHERE cnum = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, cnum);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modify(CommentVO comment) {
        try {
            String query = "UPDATE comment SET id = ?, content = ?, writer = ?, c_date = ?, c_modify_date = ?, bnum = ? WHERE cnum = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, comment.getId());
            statement.setString(2, comment.getContent());
            statement.setString(3, comment.getWriter());
            statement.setDate(4, java.sql.Date.valueOf(comment.getDate()));
            statement.setDate(5, java.sql.Date.valueOf(comment.getMdDate()));
            statement.setInt(6, comment.getBnum());
            statement.setInt(7, comment.getNum());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reg(CommentVO comment) {
        try {
            String query = "INSERT INTO comment (id, content, writer, c_date, c_modify_date, bnum) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, comment.getId());
            statement.setString(2, comment.getContent());
            statement.setString(3, comment.getWriter());
            statement.setDate(4, java.sql.Date.valueOf(comment.getDate()));
            statement.setDate(5, java.sql.Date.valueOf(comment.getMdDate()));
            statement.setInt(6, comment.getBnum());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
