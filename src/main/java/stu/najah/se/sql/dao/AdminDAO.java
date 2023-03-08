package stu.najah.se.sql.dao;

import stu.najah.se.Navigator;
import stu.najah.se.sql.entity.AdminEntity;

public class AdminDAO
        implements DAO<AdminEntity> {

    /**
     * @param username of the admin
     * @return the AdminEntity with the given username
     * or null if it's not found
     */
    public AdminEntity get(String username) {
        var session = Navigator.createSession();
        var admin = session.find(AdminEntity.class, username);
        session.close();
        return admin;
    }
}
