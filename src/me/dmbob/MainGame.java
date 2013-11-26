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
    private WorldGrid world;
    private Camera camera;
    private Being person;
    private int playerX = 10, playerY = 1;

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        world = new WorldGrid(0, 0, 2048, 2048);
        camera = new Camera(-50, -50);
        person = new Being(16, 16, "m", world, world.getTiles().get(playerX*32).get(playerY*32));
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       camera.place(g);
       world.draw(g);
       person.draw(g);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame s, int i) throws SlickException {
        if(gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
            s.enterState(1);
        }
        camera.update(gc);
        gc.getInput().clearKeyPressedRecord();
    }
   
    
    @Override
    public int getID() {
        return 2;
    }
}
