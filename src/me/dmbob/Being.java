package me.dmbob;


import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

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
    private GridTile tile;
    
    public Being(int width, int height, String gender, WorldGrid world, GridTile tile) {
        this.width = width;
        this.height = height;
        this.gender = gender;
        this.world = world;
    }
    
    public void move(Direction d) {
        tile = getAdjacentTile(d);
    }
    
    public GridTile getAdjacentTile(Direction d) {
        if(d.equals(Direction.UP)) {
            return world.getTiles().get(x * 32).get((y - 1)*32);
        }
        if(d.equals(Direction.DOWN)) {
            return world.getTiles().get(x * 32).get((y + 1)*32);
        }
        if(d.equals(Direction.LEFT)) {
            return world.getTiles().get((x - 1) * 32).get(y * 32);
        }
        if(d.equals(Direction.RIGHT)) {
            return world.getTiles().get((x + 1) * 32).get(y * 32);
        }
        return null;
    }
    
    public GridTile getCurTile() {
        return world.getTiles().get(x * 32).get(y * 32);
    }
 
    public void draw(Graphics g) {
        this.x = x;
        this.y = y;
        this.tile = tile;
        if(gender.equalsIgnoreCase("m")) {
            g.setColor(Color.blue);
        }else if(gender.equalsIgnoreCase("f")) {
            g.setColor(Color.red);
        }
        g.fillRect(tile.getX() + width/2, tile.getY() + height/2, width, height);
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void update(GameContainer gc) {
        for(int i = 0; i < 100; i++) {
            move(Direction.DOWN);
        }
    }
}
