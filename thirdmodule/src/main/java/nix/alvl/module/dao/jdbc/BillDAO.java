package nix.alvl.module.dao.jdbc;

import nix.alvl.module.dao.DaoI;

import nix.alvl.module.model.Operation;
import nix.alvl.module.model.Bill;
import nix.alvl.module.util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDAO implements DaoI<Bill> {
    private DataSource dataSource;

    public Bill findById(int id) {
        Bill bill = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT *FROM privatefinance.bill WHERE id_bill =?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                bill = new Bill();
                bill.setIndex(rs.getInt("id_bill"));
                bill.setOperations(rs.getInt("id_operations"));
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
        return bill;
    }

    public void save(Bill bill) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into privatefinance.bill values (?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, bill.getIndex());
            statement.setInt(2, bill.getOperations())
            ResultSet generatedkeys = statement.getGeneratedKeys();
            if (generatedkeys.next()) {
                bill.setIndex(generatedkeys.getInt(1));
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

    public void update(Bill bill) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("update privatefinance.bill set id_operation where id_bill =?");
            statement.setInt(1, bill.getOperations());
            statement.setInt(2, bill.getIndex());
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

    public void delete(Bill bill) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from privatefinance.bill where id_bill=?");
            statement.setInt(1, bill.getIndex());
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


    public List<Bill> findAll() {
        List<Bill> result = new ArrayList<Bill>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM privatefinance.bill");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Bill user = new Bill();
                user.setIndex(rs.getInt("id_bill"));
                user.setOperations(rs.getInt("id_operation"));

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
