package nix.alvl.module.services;

import nix.alvl.module.dao.jpa.CategoryDAO;
import nix.alvl.module.entity.Category;
import nix.alvl.module.entity.CategoryType;

import java.util.List;

public class CategoryService {
    private CategoryDAO categoryDAO = new CategoryDAO();

    public CategoryService() {
    }

    public Category findBill(int id) {
        return categoryDAO.findById(id);
    }

    public void saveBill(Category category) {
        categoryDAO.save(category);
    }

    public void deleteBill(Category category) {
        categoryDAO.delete(category);
    }

    public void updateBill(Category category) {
        categoryDAO.update(category);
    }

    public List<Category> findAllBills() {
        return categoryDAO.findAll();
    }

    public CategoryType findCategoryTypeById(int id) {
        return categoryDAO.findCategoryTypeById(id);
    }
}
