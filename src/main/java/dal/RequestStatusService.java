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
import model.RequestStatus;

/**
 *
 * @author pc
 */
public class RequestStatusService extends DBContext{
     public RequestStatus getRequestStatusById(int id){
        String sql = "select * from RequestStatus where id= ?";
        RequestStatus p = new RequestStatus();
        try{
            PreparedStatement a = connection.prepareStatement(sql);
            a.setInt(1, id);
            ResultSet rs = a.executeQuery();
            while(rs.next()){
                p.setId(rs.getInt("id"));
                p.setDescription(rs.getNString("description"));
                p.setName(rs.getString("name"));
            }
        }
        catch(SQLException e){
            
        }
        return p; 
    }
     
     public List<RequestStatus> GetAllRequestStatus(){
        String sql ="select * from RequestStatus";
        List<RequestStatus> list = new ArrayList<>();
        try{
            PreparedStatement a = connection.prepareStatement(sql);
            ResultSet rs = a.executeQuery();
            while(rs.next()){
                RequestStatus p = new RequestStatus();
                p.setId(rs.getInt("id"));
                p.setDescription(rs.getNString("description"));
                p.setName(rs.getString("name"));
                list.add(p);
            }
            return list;
        }
        catch(SQLException e){
            
        }
        return list;
    }
}
