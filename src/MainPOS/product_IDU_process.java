/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPOS;

import java.sql.PreparedStatement;
import java.sql.Connection;
import DbConn.DbConn;

/**
 *
 * @author IT-Laotelecom
 */
public class product_IDU_process extends mainpos1{
    Connection C = DbConn.getConn();
     public void insert_product(String barcode,String product,String price,String balance,String catagory){
            try {
             String sql="insert into tb_product (barcode,product_Name,price,amount,catagory_ID) values(?,?,?,?,?)";
             
            PreparedStatement ps = C.prepareStatement(sql);
            ps.setString(1,barcode);
            ps.setString(2, product);
            ps.setString(3, price);
            ps.setString(4, balance);
            ps.setString(5, catagory);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
   
}
