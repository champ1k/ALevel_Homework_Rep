package nix.alvl.module.services;

import nix.alvl.module.dao.jpa.UserDAO;
import nix.alvl.module.entity.Bill;
import nix.alvl.module.entity.User;

import java.util.List;

public class UserService {
    private UserDAO userDao = new UserDAO();

    public UserService() {
    }

    public User findUser(int id) {
        return userDao.findById(id);
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

    public void deleteUser(User user) {
        userDao.delete(user);
    }

    public void updateUser(User user) {
        userDao.update(user);
    }

    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    public Bill findBillById(int id) {
        return userDao.findBillById(id);
    }
}
