package nix.alvl.module.services;

import nix.alvl.module.dao.jpa.OperationDAO;
import nix.alvl.module.entity.Category;
import nix.alvl.module.entity.Operation;

import java.util.List;

public class OperationService {
    private OperationDAO operationDAO = new OperationDAO();

    public OperationService() {

    }

    public Operation findBill(int id) {
        return operationDAO.findById(id);
    }

    public void saveBill(Operation operation) {
        operationDAO.save(operation);
    }

    public void deleteBill(Operation operation) {
        operationDAO.delete(operation);
    }

    public void updateBill(Operation operation) {
        operationDAO.update(operation);
    }

    public List<Operation> findAllBills() {
        return operationDAO.findAll();
    }

    public Category findCategoryById(int id) {
        return operationDAO.findCategoryById(id);
    }
}
