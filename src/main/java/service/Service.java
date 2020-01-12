package service;


import model.User;
import dao.UserDaoFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Service {

    private static volatile Service instance;

    public Service() {
    }

    public static Service getInstance() {
        Service result = instance;
        if (result != null) {
            return result;
        }
        synchronized (Service.class){
            if(instance == null){
                instance = new Service();
            }
            return instance;
        }
    }
    public List<User> getAllUsers() throws SQLException, IOException {
        return new UserDaoFactory().createDAO().getAllUser();
    }

    public void editeUser(User user) throws SQLException, IOException {
        new UserDaoFactory().createDAO().editeUser(user);
    }

    public void deleteUserById(long id) throws SQLException, IOException {
        new UserDaoFactory().createDAO().deleteUserById(id);
    }

    public boolean addUser(User user) throws SQLException, IOException {
        return new UserDaoFactory().createDAO().addUser(user);
    }

    public  String getRoleByName(String name) throws IOException, SQLException {
        return new UserDaoFactory().createDAO().getRoleByName(name);
    }

    public boolean nameIsExist(String name) throws SQLException, IOException {return new UserDaoFactory().createDAO().nameIsExist(name);}

    public boolean userIsExist(String name, String password) throws IOException {return new UserDaoFactory().createDAO().userIsExist(name, password);}
}