package me.dmbob;


import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bobby
 */
public class Being {
    private int x, y, width, height;
    private String gender;
    private int curX = 0, curY = 0;
    private WorldGrid world;
    private GridTile curTile;
    private ContextMenu menu;
    private boolean mouseOver = false;
    private ArrayList<Action> actions;
    private int pick = 0;
    private String name;
    
    public Being(int width, int height, String gender, String name, WorldGrid world, GridTile tile) {
        this.width = width;
        this.height = height;
        this.gender = gender;
        this.world = world;
        this.curTile = tile;
        this.name = name;
        menu = new ContextMenu(x + 128, y, 128, 256, this);
        actions = new ArrayList<Action>();
        for(int a = 0; a < Action.values().length; a++) {
           actions.add(Action.values()[a]);
       }
    }
 
    public void draw(Graphics g) {
        if(gender.equalsIgnoreCase("m")) {
            g.setColor(Color.blue);
        }else if(gender.equalsIgnoreCase("f")) {
            g.setColor(Color.red);
        }
        g.fillRect(curTile.getX() + width/2, curTile.getY() + height/2, width, height);
        menu.draw(g);
    }
    
    public int getPick() {
        return pick;
    }
    
    public ArrayList<Action> getActions() {
        return actions;
    }

    public void move(final String dir) {
        GridTile newTile = null;
        try {
            if(dir.equalsIgnoreCase("up")) {
                newTile = world.getTiles().get(getTile().getX()).get(getTile().getY() - 32);
            }
            if(dir.equalsIgnoreCase("down")) {
                newTile = world.getTiles().get(getTile().getX()).get(getTile().getY() + 32); 
            }
            if(dir.equalsIgnoreCase("left")) {
                newTile = world.getTiles().get(getTile().getX() - 32).get(getTile().getY());
            }
            if(dir.equalsIgnoreCase("right")) {
                newTile = world.getTiles().get(getTile().getX() + 32).get(getTile().getY());
            }
        }catch(Exception ex) {
             newTile = null;
        }
        
        if(curTile == null || newTile == null) { return; }
        if(curTile.getPerson().equals(Being.class) || newTile.equals(Being.class)) {
            ConsoleDisplay.append("OH FUCK");
            return;
        }
        curTile.removePerson();
        newTile.setPerson(this);
        curTile = newTile; 
    }
    
    public void act(Action a) {
        
        if(a.equals(Action.UP)) {
            move("up");
        }
        if(a.equals(Action.DOWN)) {
            move("down");
        }
        if(a.equals(Action.LEFT)) {
            move("left");
        }
        if(a.equals(Action.RIGHT)) {
            move("right");
        }
        //if(a.equals(Action.KILL)) {
            //world.getPeople().get((int)(Math.random()*world.getPeople().size())).getTile().removePerson();
        //}
        
        
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public GridTile getTile() {
        return curTile;
    }
    
    public void update(GameContainer gc) {
        int pick = (int) (Math.random()*actions.size());
        Action prev;
        act(actions.get(pick));
        prev = actions.get(pick);
        actions.add(prev);
        ConsoleDisplay.append("Player " + name + " Action: " + prev.toString());
    }
    
    public String toString() {
        return x + ", " + y;
    }
}
