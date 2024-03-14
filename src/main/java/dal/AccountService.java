/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Account;

/**
 *
 * @author pc
 */
public class AccountService extends DBContext{
    
        public Account getAccountByID(int id) {
        String sql = "select * from Account where id= ?";
        Account p = new Account();
        try {
            PreparedStatement a = connection.prepareStatement(sql);
            a.setInt(1, id);
            ResultSet rs = a.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setUsername(rs.getNString("username"));
                p.setPhone(rs.getInt("phone"));
            }
        } catch (SQLException e) {

        }
        return p;
    }
}
