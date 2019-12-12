/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConn;

import com.mysql.jdbc.Connection;

/**
 *
 * @author IT-Laotelecom
 */
public class Testconnect {
    public static void main(String[] args){
       try {
            DbConn c=new DbConn();
            Connection con =(Connection) c.getConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
