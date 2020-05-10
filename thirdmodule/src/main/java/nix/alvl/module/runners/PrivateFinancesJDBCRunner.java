package nix.alvl.module.runners;

import nix.alvl.module.dao.jdbc.BillDAO;
import nix.alvl.module.dao.jdbc.CategoryDAO;
import nix.alvl.module.dao.jdbc.OperationDAO;
import nix.alvl.module.dao.jdbc.UserDAO;
import nix.alvl.module.io.CsvExport;
import nix.alvl.module.model.*;

import java.util.ArrayList;
import java.util.List;

public class PrivateFinancesJDBCRunner {

    public static void main(String[] args) {
        CategoryDAO categoryDAO = new CategoryDAO();
        OperationDAO operationDAO = new OperationDAO();
        BillDAO billDAO = new BillDAO();
        UserDAO userDAO = new UserDAO();

        List<CategoryType> categoryTypes = new ArrayList<>();
        CategoryType categoryType = new CategoryType();
        categoryType.setIndex(1);
        categoryType.setName("revenue");
        categoryTypes.add(categoryType);

        List<Category> categories = new ArrayList<>();
        Category category = new Category();
        category.setIndex(5);
        category.setPrice(1000);
        category.setTypes(categoryTypes);
        categories.add(category);
        categoryDAO.save(category);

        List<Operation> operations = new ArrayList<>();
        Operation operation = new Operation();
        operation.setIndex(2);
        operation.setCategories(categories);
        operation.setDate(18882188);
        operation.setDescription("");
        operations.add(operation);
        operationDAO.save(operation);


        List<Bill> bills = new ArrayList<>();
        Bill bill = new Bill();
        bill.setIndex(2);
        bill.setOperations(operations);
        bills.add(bill);
        billDAO.save(bill);

        List<User> users = new ArrayList<>();
        User user = new User();
        user.setIndex(3);
        user.setName("Alex");
        user.setAge(23);
        user.setPhonenumber("3807897899");
        user.setEmail("alex@email.com");
        user.setBills(bills);
        users.add(user);
        userDAO.save(user);

        CsvExport.export();
    }
}
