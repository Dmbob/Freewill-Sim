/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.dmbob;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

/**
 *
 * @author Bobby
 */
public class GridTile {
 //  private static int gId = 1;
    private static GridTile selected;
    private int x, y, width, height, id;
    private Being person;
    private boolean containsPerson;
    
    
    public GridTile(int width, int height) {
        this.width = width;
        this.height = height;
      //  id = gId++;
    }
    
    public GridTile(int width, int height, int x, int y) {
        this(width, height);
        this.x = x;
        this.y = y;
    }
    
    public static GridTile getSelected() {
        return selected;
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
        
        if(selected == this) {
            g.setColor(Color.black);
            g.drawRect(x+3, y+3, width-7, height-7);
        } 
    }
    
    public int getId() {
        return id;
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
        if(((gc.getInput().getMouseX() >= (x*32) && gc.getInput().getMouseX() <= (x*32) + width) &&
                (gc.getInput().getMouseY() >= (y*32) && gc.getInput().getMouseY() <= (y*32) + height)) &&
                        (gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON))) {
                 if (selected != this) {
                     System.out.println("first: " + id + " " +  selected);
                     selected = this;
                 } else {
                     System.out.println("second: " + id + " " + selected);
                     selected = null;
                 }
                 System.out.println(id + " " +selected);
       }
        
        if(selected == this && !containsPerson) {
            selected = null;
        }
    }
}
