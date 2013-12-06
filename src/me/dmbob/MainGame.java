/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.dmbob;

import java.util.logging.Level;
import java.util.logging.Logger;
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
    private WorldGrid world;
    private Camera camera;
    private int playerX = 0, playerY = 0;

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        world = new WorldGrid(0, 0, 1024, 1024);
        camera = new Camera(-50, -50);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       camera.place(g);
       world.draw(g);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame s, int i) throws SlickException {
        if(gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
            s.enterState(1);
        }
        world.update(gc);
        camera.update(gc);
        gc.getInput().clearKeyPressedRecord();
    }
   
    
    @Override
    public int getID() {
        return 2;
    }
}
