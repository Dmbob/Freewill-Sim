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
    
    public Being(int width, int height, String gender) {
        this.width = width;
        this.height = height;
        this.gender = gender;
    }
    
    public void move(Direction d, WorldGrid tile) {
        if(d.equals(Direction.UP)) {
            
        }
    }
    
    public void draw(GridTile tile, Graphics g) {
        this.x = x;
        this.y = y;
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
       
    }
}
