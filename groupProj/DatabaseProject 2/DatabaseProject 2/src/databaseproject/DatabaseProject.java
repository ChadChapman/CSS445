/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject;

import java.awt.Button;
import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Chad Chapman, Keegan Kell, hui ting cai, Hanan J Abdo 
 */
public class DatabaseProject extends Frame
{
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginPanel frame = new LoginPanel();
                    frame.setVisible(true);
                    frame.setTitle("Login");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public DatabaseProject()
    {
    }

    

}
