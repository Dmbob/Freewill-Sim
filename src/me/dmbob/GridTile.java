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
    private Being person;
    private boolean containsPerson;
    
    public GridTile(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public GridTile(int width, int height, int x, int y) {
        this(width, height);
        this.x = x;
        this.y = y;
    }
    
    public void draw(int x, int y, Graphics g) {
     //   this.x = x;
      //  this.y = y;
        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
        g.setColor(Color.black);
        g.drawRect(x - 1, y - 1, 32 + 2, 32 + 2);
        if(person != null) {
            g.pushTransform();
            g.translate(this.getX()*32, this.getY()*32);
            person.draw(g);
            g.popTransform();
        }
        if(containsPerson) {
            g.setColor(Color.green);
            g.drawString("T", x, y);
        }else if(!containsPerson) {
            g.setColor(Color.red);
            g.drawString("F", x, y);
        }
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public GridTile setPerson(Being b) {
        person = b;
        containsPerson = (b != null);
        return this;
    }
    
    public Being getPerson() {
        if(person != null) {
            return person;
        }
        return null;
    }
    
    public boolean containsPerson() {
        return containsPerson;
    }
    
    public String toString() {
        return "[Being Location: " + person + ", Tile Location: " + x +", " + y + "]";
    }
    
    public void update(GameContainer gc) {
    }
}
