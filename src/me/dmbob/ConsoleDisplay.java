/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.dmbob;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.newdawn.slick.Graphics;

/**
 *
 * @author Bobby
 */
public class ConsoleDisplay extends JPanel {
    private static JTextArea text;
    private ArrayList<String> textArray;
    
    public ConsoleDisplay() {
        this.setLayout(new BorderLayout());
        text = new JTextArea(1, 1);
        text.setBounds(0, 0, 400, Integer.MAX_VALUE);
        text.setLineWrap(true);
        text.setAutoscrolls(true);
        text.setEditable(false);
        text.setBackground(Color.BLACK);
        text.setFont(new Font("Lucida Console", Font.PLAIN, 14));
        text.setForeground(Color.WHITE);
        
        this.add(text, BorderLayout.CENTER);
    }
    
    public static void append(String s) {
        text.append(s + "\n");
        text.setCaretPosition(text.getDocument().getLength());
        if(text.getLineCount() > Integer.MAX_VALUE) {
            text.setText("");
        }
    }
    
    public static void clear() {
        text.removeAll();
    }
    
    public JTextArea getText() {
        return text;
    }
}
