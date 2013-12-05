package me.dmbob;


import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public Being(int width, int height, String gender, WorldGrid world, GridTile tile) {
        this.width = width;
        this.height = height;
        this.gender = gender;
        this.world = world;
        this.curTile = tile;
    }
 
    public void draw(int x, int y, Graphics g) {
        if(gender.equalsIgnoreCase("m")) {
            g.setColor(Color.blue);
        }else if(gender.equalsIgnoreCase("f")) {
            g.setColor(Color.red);
        }
        g.fillRect(x + width/2, y + height/2, width, height);
    }

    public void move(String d) {
        GridTile newTile = null;
        if(d.equalsIgnoreCase("up")) {
           newTile = world.getTiles().get(getTile().getX()).get(getTile().getY() - 32);
           y-=32;
        }
        if(d.equalsIgnoreCase("down")) {
           newTile = world.getTiles().get(getTile().getX()).get(getTile().getY() + 32);
           y+=32;
        }
        if(d.equalsIgnoreCase("left")) {
           newTile = world.getTiles().get(getTile().getX() - 32).get(getTile().getY());
           x-=32;
        }
        if(d.equalsIgnoreCase("right")) {
           newTile = world.getTiles().get(getTile().getX() + 32).get(getTile().getY());
           x+=32;
        }
        if(curTile == null || newTile == null) { return; }
        curTile.removePerson();
        newTile.setPerson(this);
        System.out.println(newTile);
        curTile = newTile; 
    }
    
    public void act(Action a) {
        world.getTiles().get(0).get(0).removePerson();
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

    }
    
    public String toString() {
        return x + ", " + y;
    }
}
