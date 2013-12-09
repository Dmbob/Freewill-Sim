/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.dmbob;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
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
    private GameButton actButton;
    public final static ArrayList<Action> MOVE_ACTIONS = new ArrayList<Action>();

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        MOVE_ACTIONS.add(Action.UP);
        MOVE_ACTIONS.add(Action.DOWN);
        MOVE_ACTIONS.add(Action.LEFT);
        MOVE_ACTIONS.add(Action.RIGHT);
        
        world = new WorldGrid(0, 0, 512, 512);
        camera = new Camera(-50, -50);
        actButton = new GameButton(100, 30, "Act", Color.black);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       /*g.setClip(world.getX(), world.getY(), 1024, 1024);
       g.setColor(Color.black);
       g.fillRect(0, gc.getHeight() - 50, gc.getWidth(), 50);
       g.setColor(Color.white);
       g.drawRect(0, gc.getHeight() - 51, gc.getWidth(), 49);
       actButton.draw(30, gc.getHeight() - 45, g);
        */
       camera.place(g);
       world.draw(g);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame s, int i) throws SlickException {
        if(gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
            s.enterState(1);
        }
        
        camera.update(gc);
        world.update(gc); 
        actButton.update(gc);
        gc.getInput().clearKeyPressedRecord();
    }
   
    
    @Override
    public int getID() {
        return 2;
    }
}
