package nix.alvl.module.dao.jdbc;

import nix.alvl.module.dao.DaoI;
import nix.alvl.module.model.Bill;
import nix.alvl.module.model.User;
import nix.alvl.module.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import nix.alvl.module.util.SessionFactoryUtil;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {
    private DataSource dataSource;
    public User findById(int id) {
        User user = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT *FROM privatefinance.user WHERE id_user =?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setIndex(rs.getInt("id_operation"));
                user.setName(rs.getString("name"));
                user.setPhonenumber(rs.getString("phonenumber"));
                user.setBills(rs.getInt("id_bill"));
                user.setAge(rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public void save(User user) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into privatefinance.user values (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, user.getIndex());
            statement.setString(2, user.getName());
            statement.setInt(3, user.getAge());
            statement.setString(4, user.getPhonenumber());
            statement.setString(5, user.getEmail());
            statement.setString(6, user.getBills());
            statement.execute();

            ResultSet generatedkeys = statement.getGeneratedKeys();
            if (generatedkeys.next()) {
                user.setIndex(generatedkeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(User user) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("update privatefinance.user set id_bill where id_user =?");
            statement.setInt(1, user.getBills());
            statement.setInt(2, user.getIndex());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(User user) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from privatefinance.user where id_user=?");
            statement.setInt(1, user.getIndex());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    public List<User> findAll() {
        List<User> result = new ArrayList<User>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM privatefinance.category");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
               User user = new User();
                user.setIndex(rs.getInt("id_operation"));
                user.setName(rs.getString("name"));
                user.setPhonenumber(rs.getString("phonenumber"));
                user.setBills(rs.getInt("id_bill"));
                user.setAge(rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
