/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.dmbob;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

/**
 *
 * @author Bobby
 */
public class ContextMenu {
    private int x, y, width, height;
    private boolean visible;
    private Being person;
    
    public ContextMenu(int x, int y, int width, int height, Being b) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        visible = false;
        person = b;
    }
    
    public void draw(Graphics g) {
        if(visible) {
            g.setColor(Color.black);
            g.fillRect(x, y, width, height);
        }
    }
    
    public Being getPerson() {
        return person;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setVisible(boolean b) {
        visible = b;
    }
    
    public void update(GameContainer gc) {
        
    }
}
