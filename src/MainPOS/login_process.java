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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author IT-Laotelecom
 */
public class login_process {
    public static int result;
    Connection C = DbConn.getConn();
    loginpos1 login = new loginpos1();
    public int acessProgram(String user,String password){
        PreparedStatement ps;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
               
                ps = C.prepareStatement("select * from tb_user where user_Name=? and password=?");
                ps.setString(1,user);
                ps.setString(2,password);
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                    int role=Integer.parseInt(rs.getString("user_role"));
                    result=1;
                    
                    if(role==1){
                        mainpos1 mp1 = new mainpos1();
                        mp1.setVisible(true);
                        System.out.println("pass"+result);
                        return 1;
                    }
                    else{
                        mainpos2 mp2 =new mainpos2();
                        mp2.setVisible(true);
                        return 1;
                    }
                }else{
                    result=0;
                    JOptionPane.showMessageDialog(login, "Incorect Username and Password");
                    login.requestFocus(); 
                    return 0;
                }
            } catch (SQLException ex) {
                Logger.getLogger(loginpos1.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(loginpos1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
  
}
