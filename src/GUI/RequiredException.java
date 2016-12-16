/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Bobby
 */
public class RequiredException extends Exception {

    public JTextComponent component;

    public RequiredException(JTextComponent component) {
        component.setBackground(new Color(255, 232, 232));
    }
    
}
