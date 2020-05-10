package nix.alvl.module.runners;

import nix.alvl.module.entity.Bill;
import nix.alvl.module.entity.Category;
import nix.alvl.module.entity.Operation;
import nix.alvl.module.entity.User;
import nix.alvl.module.io.CsvExport;
import nix.alvl.module.services.BillService;
import nix.alvl.module.services.OperationService;
import nix.alvl.module.services.UserService;

import java.util.ArrayList;
import java.util.List;

public class PrivateFinancesJPARunner {

    public static void main(String[] args) {

        UserService userService = new UserService();
        User user = new User("Masha", (long) 26.2, "masha@email.com");
        userService.saveUser(user);

        Category category = new Category();
        category.setId_category(1);

        List<Operation> operations = new ArrayList<>();

        Operation operation = new Operation();
        operation.setId_operation(1);

        operations.add(operation);
        BillService billService = new BillService();
        Bill bill = new Bill(user, operations);
        billService.saveBill(bill);

        CsvExport.export();
    }
}
