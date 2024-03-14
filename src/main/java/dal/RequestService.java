/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Request;

/**
 *
 * @author pc
 */
public class RequestService extends DBContext {

    public Request getRequestByID(int id) {
        String sql = "select * from Request where id= ?";
        Request p = new Request();
        try {
            PreparedStatement a = connection.prepareStatement(sql);
            a.setInt(1, id);
            ResultSet rs = a.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setServiceId(rs.getInt("serviceId"));
                p.setDescription(rs.getNString("description"));
                p.setFileUrl(rs.getString("fileUrl"));
                p.setAccountId(rs.getInt("accountId"));
                p.setRequestStatusId(rs.getInt("requestStatusId"));
                p.setTimestamp(rs.getString("timestamp"));
            }
        } catch (SQLException e) {

        }
        return p;
    }

    public List<Request> getAllRequest() {
        String sql = "select * from Request";
        List<Request> list = new ArrayList<>();
        try {
            PreparedStatement a = connection.prepareStatement(sql);
            ResultSet rs = a.executeQuery();
            while (rs.next()) {
                Request p = new Request();
                p.setId(rs.getInt("id"));
                p.setServiceId(rs.getInt("serviceId"));
                p.setDescription(rs.getNString("description"));
                p.setAccountId(rs.getInt("accountId"));
                p.setFileUrl(rs.getString("fileUrl"));
                p.setRequestStatusId(rs.getInt("requestStatusId"));
                p.setTimestamp(rs.getString("timestamp"));
                list.add(p);
            }
            return list;
        } catch (SQLException e) {

        }
        return list;
    }

    public void updateRequestStatus(int requestId, int newRequestStatusId) {
        String sql = "UPDATE Request SET requestStatusId = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, newRequestStatusId);
            preparedStatement.setInt(2, requestId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // Handle any exceptions here
            e.printStackTrace();
        }
    }
}
