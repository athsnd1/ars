/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ars.ui;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author USER
 */
public class Main {
    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel(new FlatLightLaf());
        }catch(Exception ex){
            ex.printStackTrace();
        }
        SwingUtilities.invokeLater(()->{
            new LoginForm().setVisible(true);
        });
    }
    
}
