/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPOS;

import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import DbConn.DbConn;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
/**
 *
 * @author IT-Laotelecom
 */
public class order_process {
    Connection C = DbConn.getConn();
    public void show_data(DefaultTableModel ModelOrder){
        try {
             /*bill table*/
               String sql="select" +
                      "\ttb_order_detail.order_ID," +
                      "tb_order.date,"+
                      "tb_order_detail.ID,"+
                      "tb_order_detail.product_ID," +
                      "tb_order_detail.quantity," +
                      "tb_order_detail.price from tb_order_detail\t" +
                       
                      "inner join tb_order on tb_order_detail.order_ID = tb_order.order_ID\t" +
                      "inner join tb_product on tb_order_detail.product_ID=tb_product.product_ID";
               ResultSet rs=C.createStatement().executeQuery(sql);
               ResultSetMetaData rsd=rs.getMetaData();
               int column= rsd.getColumnCount();
               
               ModelOrder.setRowCount(0);
               while(rs.next()){
                   Vector row = new Vector();
                   for(int i=0;i<column;i++){
                       row.add(rs.getString("order_ID"));
                       row.add(rs.getString("date"));
                       row.add(rs.getString("ID"));
                       row.add(rs.getString("product_ID"));
                       row.add(rs.getString("quantity"));
                       row.add(rs.getString("price"));
                   }
                   ModelOrder.addRow(row);
               }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete_order(TableModel TB_order,int row){
        
        try {            
            String order_id1=TB_order.getValueAt(row, 0).toString();
            String sql1="delete from tb_order_detail where order_ID=?";
            
            PreparedStatement ps =C.prepareStatement(sql1);
            ps.setString(1, order_id1);
            ps.executeUpdate();
            
            String order_id2=TB_order.getValueAt(row, 0).toString();
            String sql2="delete from tb_order where order_ID=?";
            
            ps=C.prepareStatement(sql2);
            ps.setString(1, order_id2);
            ps.executeUpdate();
          
        } catch (SQLException ex) {
            Logger.getLogger(order_process.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
