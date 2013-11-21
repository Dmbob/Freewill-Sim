/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.dmbob;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Bobby
 */
public class MainGame extends BasicGameState{

    

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawString("Main Game Goes Here", gc.getWidth()/2, gc.getWidth()/2);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame s, int i) throws SlickException {
        if(gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
            s.enterState(1);
        }
    }
    
    @Override
    public int getID() {
        return 2;
    }
}
