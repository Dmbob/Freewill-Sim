/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.dmbob;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 *
 * @author Bobby
 */
public class GridTile {
    private int x, y, width, height;
    
    public GridTile(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public void draw(int x, int y, Graphics g) {
        this.x = x;
        this.y = y;
        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
        g.setColor(Color.black);
        g.drawRect(x - 1, y - 1, 32 + 2, 32 + 2);
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    /*public String toString() {
        return "[Being Location: " + person + ", Tile Location: " + x +", " + y + "]";
    }*/
    
    public void update(GameContainer gc) {
    }
}
