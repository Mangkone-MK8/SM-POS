/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPOS;

import java.sql.PreparedStatement;
import java.sql.Connection;
import DbConn.DbConn;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author IT-Laotelecom
 */
public class product_IDU_process extends mainpos1{
    Connection C = DbConn.getConn();
    int idCata;
    /*insert data into tb_table*/
     public void insert_product(String barcode,String product,String price,String balance,int idCata){
            try {
             
             String sql="insert into tb_product (barcode,product_Name,price,quantity,catagory_ID) values(?,?,?,?,?)";     
             PreparedStatement ps=C.prepareStatement(sql);
             ps.setString(1,barcode);
             ps.setString(2, product);
             ps.setString(3, price);
             ps.setString(4, balance);
             ps.setInt(5, idCata);
             ps.executeUpdate();
                
          }
        catch (Exception e) {
            e.printStackTrace();
        }
    } 
     
     /*updata data in tb_product*/
     public void edit(String barcode,String product,int idCata,String price,String balance,TableModel TB_model,int index){
        try {
            String id=TB_model.getValueAt(index,0).toString();
            String sql = "Update tb_product set barcode=?,product_Name=?,price=?,quantity=?,catagory_ID=? "
                    + "where product_ID=?";
            PreparedStatement pre = C.prepareStatement(sql);
            pre.setString(1,barcode);
            pre.setString(2,product);
            pre.setString(3,price);
            pre.setString(4,balance);
            pre.setInt(5,idCata);
            pre.setString(6,id);
            pre.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
    
    /*delete data in tb_product*/
     public void delete(TableModel TB_model,int index){
        try {
            
            String id = TB_model.getValueAt(index, 0).toString();
            System.out.println(id);
            String sql = "delete from tb_product where product_ID=?";
            PreparedStatement pre = C.prepareStatement(sql);
            pre.setString(1, id);
            pre.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   public void show_data(DefaultTableModel Modelproduct){
       try {
           /*product table*/
           
                String sql="select * from tb_product";
                ResultSet rs =C.createStatement().executeQuery(sql);
                ResultSetMetaData rsd= rs.getMetaData();
                int column=rsd.getColumnCount();
        
                Modelproduct.setRowCount(0);
                while(rs.next()){
                    Vector row =new Vector();
                    for(int i=0;i<column;i++){ 
                        row.add(rs.getString("product_ID"));
                        row.add(rs.getString("barcode"));
                        row.add(rs.getString("product_Name"));
                        row.add(rs.getString("price"));
                        row.add(rs.getString("quantity"));
                        row.add(rs.getString("catagory_ID"));
                      
                    }
                    Modelproduct.addRow(row);
              }
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
   public int combox_select(String catagory){
        
       try {
           int idCata;
           Vector row = new Vector();
           row.clear();
           String sql="select * from tb_catagory";
           PreparedStatement ps= C.prepareStatement(sql);
           ResultSet rs= ps.executeQuery();
           while(rs.next()){              
               if(rs.getString("catagory_Name").equals(catagory)){
                   idCata=rs.getInt("catagory_ID");
                   System.out.println("idcata="+idCata);
                   return idCata;
               }
           }
       
               
       } catch (Exception e) {
           e.printStackTrace();
       }
       return idCata;
   }
   public void show_combo(DefaultComboBoxModel Modelcombox){
       try {
           Vector row = new Vector();
           row.clear();
           Modelcombox.removeAllElements();
           String sql="select * from tb_catagory";
           PreparedStatement ps= C.prepareStatement(sql);
           ResultSet rs= ps.executeQuery();
           while(rs.next()){              
               Modelcombox.addElement(rs.getString("catagory_Name"));
             } 
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
}
