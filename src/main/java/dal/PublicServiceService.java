/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.PublicService;

/**
 *
 * @author pc
 */
public class PublicServiceService extends DBContext{
    
        public PublicService getPublicServiceByID(int id) {
        String sql = "select * from PublicService where id= ?";
        PublicService p = new PublicService();
        try {
            PreparedStatement a = connection.prepareStatement(sql);
            a.setInt(1, id);
            ResultSet rs = a.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setName(rs.getNString("name"));
                p.setType(rs.getString("type"));
                p.setDescription(rs.getNString("description"));
            }
        } catch (SQLException e) {

        }
        return p;
    }
    
}
