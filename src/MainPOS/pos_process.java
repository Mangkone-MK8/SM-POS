/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPOS;

import DbConn.DbConn;
import com.mysql.jdbc.Statement;
import java.awt.print.PrinterException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;

/**
 *
 * @author IT-Laotelecom
 */
public class pos_process {
    Object result;
    Connection C = DbConn.getConn();
    mainpos1 mainpos1=new mainpos1();
    int pricefield,total,quantityfield;
            int current,id;
      
      /*show data in pos jtable this will return object back to mainpos1 class*/
    public Object pos_showdata(String barcode,String product,String price,String quantity){           
            try {
                String sql="select * from tb_product where barcode=?";
                PreparedStatement ps=C.prepareStatement(sql);
                ps.setString(1,barcode);
                ResultSet rs=ps.executeQuery();
                
                    while(rs.next()){
                    current=rs.getInt("quantity");
                    id=rs.getInt("product_ID");
                    
                    pricefield=Integer.parseInt(price);
                    quantityfield=Integer.parseInt(quantity);
                    
                    total=pricefield*quantityfield;
                    
                    if(quantityfield>current){
                        JOptionPane.showMessageDialog(mainpos1, "Currently quantity = "+current);
                    }
                    else{
                        Object[] name = new Object[]{
                            id,
                            barcode,
                            product,
                            price,
                            quantity,
                            total,
                        };
                      result=name;
                     }
                   }
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
     return result;   }
    
    /*method pos sales that saves into tb_order and tb_order_detail*/
    public void sales(TableModel TB_pos){
           int lastid=0;
       try {
       
           String sql1="insert into tb_order (date) values(now())";         
           PreparedStatement ps = C.prepareStatement(sql1,Statement.RETURN_GENERATED_KEYS);
           ps.executeUpdate();
           ResultSet rs=ps.getGeneratedKeys();
           
           /*lastid gonna be saved into order_detail*/
           if(rs.next()){
               lastid=rs.getInt(1);
           }
           int product_id;
           int price;
           int quantity;
           int row=TB_pos.getRowCount();
           
          
           String sql2="insert into tb_order_detail (order_ID,product_ID,price,quantity) values(?,?,?,?)";
           ps=C.prepareStatement(sql2);
           for(int i=0;i<row;i++){
              product_id =Integer.parseInt(TB_pos.getValueAt(i, 0).toString());
              price=Integer.parseInt(TB_pos.getValueAt(i, 3).toString());
              quantity=Integer.parseInt(TB_pos.getValueAt(i, 4).toString());
              
               ps.setInt(1, lastid);
               ps.setInt(2, product_id);
               ps.setInt(3, price);
               ps.setInt(4, quantity);
               ps.executeUpdate();
           }
           ps.addBatch();
           ps.close();
            
           /*reduce quantity in product*/
           String sql3="update tb_product set quantity=quantity-? where product_ID=?";
           ps=C.prepareStatement(sql3);
           for(int j=0;j<row;j++){
                product_id =Integer.parseInt(TB_pos.getValueAt(j, 0).toString());
                quantity=Integer.parseInt(TB_pos.getValueAt(j, 4).toString());
                
                ps.setInt(1, quantity);
                ps.setInt(2, product_id);
                ps.executeUpdate();
           }
          ps.addBatch();
          ps.close();
          
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
    
    /*this method print bill. it will send paramister to print class*/
     public void print(String total,String receive,String change,TableModel TB_pos){
      
         try {
             new print(total,receive,change,TB_pos).setVisible(true);
         } catch (PrinterException ex) {
             Logger.getLogger(mainpos1.class.getName()).log(Level.SEVERE, null, ex);
         }
  }   
  }
