package nix.alvl.module.services;

import nix.alvl.module.dao.jpa.BillDAO;
import nix.alvl.module.entity.Bill;
import nix.alvl.module.entity.Operation;

import java.util.List;

public class BillService {
    private BillDAO billDAO = new BillDAO();

    public BillService() {
    }

    public Bill findBill(int id) {
        return billDAO.findById(id);
    }

    public void saveBill(Bill bill) {
        billDAO.save(bill);
    }

    public void deleteBill(Bill bill) {
        billDAO.delete(bill);
    }

    public void updateBill(Bill bill) {
        billDAO.update(bill);
    }

    public List<Bill> findAllBills() {
        return billDAO.findAll();
    }

    public Operation findOperationById(int id) {
        return billDAO.findOperationById(id);
    }
}
