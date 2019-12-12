/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConn;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author IT-Laotelecom
 */
public class DbConn {
    public static Connection getConn(){
        try {
            String url,user,pass,driver;
            url="jdbc:mysql://localhost/sm-pos?characterEncoding=UTF-8";
            user="root";
            pass="";
            driver="com.mysql.jdbc.Driver";
            Class.forName(driver);
            
            return DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
