package nix.alvl.module.dao.jdbc;

import nix.alvl.module.dao.DaoI;
import nix.alvl.module.model.Operation;
import nix.alvl.module.model.Operation;
import nix.alvl.module.util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperationDAO implements DaoI<Operation> {

    private DataSource dataSource;

    public Operation findById(int id) {
        Operation operation = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT *FROM privatefinance.operation WHERE id_operation =?");
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                operation = new Operation();
                operation.setIndex(rs.getInt("id_operation"));
                operation.setCategories(rs.getInt("price"));
                operation.setDate(rs.getTimestamp("date"));
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
        return operation;
    }

    public void save(Operation operation) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into privatefinance.operation values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, operation.getIndex());
            statement.setInt(2, operation.getCategories());
            statement.setTimestamp(3, operation.getDate());
            statement.execute();

            ResultSet generatedkeys = statement.getGeneratedKeys();
            if (generatedkeys.next()) {
                operation.setIndex(generatedkeys.getInt(1));
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

    public void update(Operation operation) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("update privatefinance.operation set id_category where id_operation =?");
            statement.setInt(1, operation.getCategories());
            statement.setInt(2, operation.getIndex());
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

    public void delete(Operation operation) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from privatefinance.operation where id_operation=?");
            statement.setInt(1, operation.getIndex());
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


    public List<Operation> findAll() {
        List<Operation> result = new ArrayList<Operation>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM privatefinance.operation");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Operation item = new Operation();
                item.setIndex(rs.getInt("id_operation"));
                item.setCategories(rs.getInt("id_category"));
                item.setDate(rs.getTimestamp("date"));
                result.add(item);
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
