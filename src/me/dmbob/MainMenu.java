package me.dmbob;


import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bobby
 */
public class MainMenu extends BasicGameState {
    private String TITLE = "Plese choose a simulation option...";
    private int rectWidth = 5, rectHeight = 10;
    private boolean rectOn = true;
    private GameButton startButton;
    
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        startButton = new GameButton(100, 30, "Start", Color.blue);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.white);
        g.drawString(TITLE, gc.getWidth()/2 - g.getFont().getWidth(TITLE)/2, gc.getHeight()/3);
        g.fillRect(gc.getWidth()/2 + g.getFont().getWidth(TITLE)/2 + 5, gc.getHeight()/3, rectWidth, rectHeight);
        startButton.draw(gc.getWidth()/2 - startButton.getWidth()/2, gc.getHeight()/2 - 
                startButton.getHeight()/2, g);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
        Thread timing = new Thread(new Runnable() {
         @Override
            public void run() {
                if(rectOn) {
                   try {
                       Thread.sleep(200);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   rectWidth = 3;
                   rectHeight = 15;
                   rectOn = false;
               }else if(!rectOn) {
                   try {
                       Thread.sleep(200);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   rectWidth = 0;
                   rectHeight = 0;
                   rectOn = true;
               }
            }   
        });
        timing.start();
        startButton.update(gc);
        
        if(startButton.isClicked()) {
            s.enterState(2);
        }
    }
    
    @Override
    public int getID() {
        return 1;
    }
    
}
