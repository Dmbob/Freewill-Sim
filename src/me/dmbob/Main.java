/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.dmbob;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Bobby
 */
public class Main extends StateBasedGame {
    public static JFrame frame;
    private static JScrollPane scroll;
    
    public Main(String name) {
        super(name);
    }
    
    public static void main(String[] args) throws SlickException{    
        ConsoleDisplay display = new ConsoleDisplay();
        display.setBounds(0, 0, 500, 800);
        
        JFrame frame = new JFrame("Display");
        frame.setBounds(0, 0, 500, 800);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.add(display);
        frame.setVisible(true);
        
        scroll = new JScrollPane(display.getText());
        scroll.setPreferredSize(new Dimension(400, 800));
        frame.add(scroll, BorderLayout.CENTER);
        
        scroll.add(display);
        
        AppGameContainer game = new AppGameContainer(new Main("Freewill-Sim"));
        game.setDisplayMode(600, 512, false);
        game.setTargetFrameRate(60);
        game.setSmoothDeltas(true);
        game.start();
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.addState(new MainMenu());
        this.addState(new MainGame());
    }
}