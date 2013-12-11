/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.dmbob;

import java.util.ArrayList;
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
    public final static ArrayList<Action> MOVE_ACTIONS = new ArrayList<Action>();
    private ContextMenu menu;

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        MOVE_ACTIONS.add(Action.UP);
        MOVE_ACTIONS.add(Action.DOWN);
        MOVE_ACTIONS.add(Action.LEFT);
        MOVE_ACTIONS.add(Action.RIGHT);
        
        world = new WorldGrid(0, 0, 512, 512);
        menu = new ContextMenu(512, 0, 100, gc.getHeight());
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
       world.draw(g);
       menu.draw(g);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame s, int i) throws SlickException {
        if(gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
            s.enterState(1);
        }
        
        world.update(gc); 
        menu.update(gc);
        gc.getInput().clearKeyPressedRecord();
        gc.getInput().clearMousePressedRecord();
    }
   
    
    @Override
    public int getID() {
        return 2;
    }
}
