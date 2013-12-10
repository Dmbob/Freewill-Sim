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
    private int x, y, width, height;
    private Being person;
    private boolean containsPerson, clicked;
    private ContextMenu menu;
    
    public GridTile(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public GridTile(int width, int height, int x, int y) {
        this(width, height);
        this.x = x;
        this.y = y;
        menu = new ContextMenu(this);
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
        //ConsoleDisplay.append("X: " + x*32 + ", Y: " + y*32);
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
    
    public boolean isClicked() {
        return clicked;
    }
    
    public String toString() {
        return "[Being Location: " + person + ", Tile Location: " + x +", " + y + "]";
    }
    
    public void update(GameContainer gc) {
        if(person != null) {
            if(person.playerKilled()) {
                containsPerson = false;
            }
        }
        /*if(gc.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            if(containsPerson()) {
               ConsoleDisplay.append("Current Action: " + person.getLastAction());
            }else {
                ConsoleDisplay.clear();
                ConsoleDisplay.append("No Person Here");
            }
        }*/
        
        if(((gc.getInput().getMouseX() >= (x*32) && gc.getInput().getMouseX() <= (x*32) + width) &&
                (gc.getInput().getMouseY() >= (y*32) && gc.getInput().getMouseY() <= (y*32) + height)) && containsPerson) {
             
        }
        
    }
}
