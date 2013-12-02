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
    private GridTile newTile;
    
    public Being(int width, int height, String gender, WorldGrid world, GridTile tile) {
        this.width = width;
        this.height = height;
        this.gender = gender;
        this.world = world;
        this.curTile = tile;
        newTile = curTile;
    }
 
    public void draw(Graphics g) {
        if(gender.equalsIgnoreCase("m")) {
            g.setColor(Color.blue);
        }else if(gender.equalsIgnoreCase("f")) {
            g.setColor(Color.red);
        }
        g.fillRect(curTile.getX() + width/2, curTile.getY() + height/2, width, height);
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void update(GameContainer gc) {

    }
    
    public String toString() {
        return x + ", " + y;
    }
}
