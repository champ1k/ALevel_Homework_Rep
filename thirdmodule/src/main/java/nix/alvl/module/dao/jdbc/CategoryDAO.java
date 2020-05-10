package nix.alvl.module.dao.jdbc;

import nix.alvl.module.dao.DaoI;
import nix.alvl.module.model.Category;
import nix.alvl.module.model.CategoryType;
import nix.alvl.module.util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements DaoI<Category> {


    private DataSource dataSource;

    public Category findById(int id) {
        Category category = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT *FROM privatefinance.category WHERE id_category =?");
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                category = new Category();
                category.setIndex(rs.getInt("id_category"));
                category.setPrice(rs.getInt("price"));
                category.setTypes(rs.getInt("id_type"));
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
        return category;
    }

    public void save(Category category) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into privatefinance.category values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, category.getIndex());
            statement.setInt(2, category.getPrice());
            statement.execute();

            ResultSet generatedkeys = statement.getGeneratedKeys();
            if (generatedkeys.next()) {
                category.setIndex(generatedkeys.getInt(1));
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

    public void update(Category category) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("update privatefinance.category set price where id_category =?");
            statement.setInt(1, category.getPrice());
            statement.setInt(2, category.getIndex());
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

    public void delete(Category category) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from privatefinance.category where id_category =?");
            statement.setInt(1, category.getIndex());
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


    public List<Category> findAll() {
        List<Category> result = new ArrayList<Category>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM privatefinance.category");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Category item = new Category();
                item.setIndex(rs.getInt("id_category"));
                item.setPrice(rs.getInt("price"));
                item.setTypes(rs.getInt("id_type"));
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
