/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPOS;

import DbConn.DbConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author IT-Laotelecom
 */
public class catagory_IDU_process {
    Connection C = DbConn.getConn();
    public void insert_catagory(String name, String status_catagory){
        try {
            int status;
            String sql="insert into tb_catagory (catagory_Name,catagory_status) values(?,?)";
                if(status_catagory== "ຍັງເຫລືອ"){
                     status = 1;
                }else{
                     status = 0;
                }
            PreparedStatement ps = C.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, status);
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
                    
        }
  }
    public void update_catagory(String name, String status_catagory,TableModel TB_catagory,int index){
        try {
            int status;
            int id=Integer.parseInt(TB_catagory.getValueAt(index, 0).toString());
            String sql="update tb_catagory set catagory_Name=?, catagory_status=? where catagory_ID=?";
              if(status_catagory== "ຍັງເຫລືອ"){
                     status = 1;
                }else{
                     status = 0;
                }
              PreparedStatement ps=C.prepareStatement(sql);
              ps.setString(1, name);
              ps.setInt(2, status);
              ps.setInt(3, id);
              ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete_catagory(TableModel TB_catagory,int index){
         try {
            String id=TB_catagory.getValueAt(index, 0).toString();
            String sql="Delete from tb_catagory where catagory_ID=?";
            PreparedStatement ps=C.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void show_data(DefaultTableModel Modelcatagory){
        try {
             /*catagory table*/
                String sql="select * from tb_catagory";
                ResultSet rs=C.createStatement().executeQuery(sql);
                ResultSetMetaData rsd=rs.getMetaData();
                int column=rsd.getColumnCount();
                
                Modelcatagory.setRowCount(0);
                while(rs.next()){
                    Vector row = new Vector();
                    for (int i = 0; i < column; i++) {
                        row.add(rs.getString("catagory_ID"));
                        row.add(rs.getString("catagory_Name"));
                        row.add(rs.getString("catagory_status"));
                    }
                    Modelcatagory.addRow(row);
                } 
        }catch (Exception e) {
           e.printStackTrace();
         } 
    }
}
