/*
 * To change this template, choose Tools | Templates
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
public class GameButton {
    private float x, y, width, height;
    private String name;
    private Color color;
    private boolean mouseOver = false;
    private boolean clicked = false;
    
    public GameButton(float width, float height, String name, Color color) {
        this.width = width;
        this.height = height;
        this.name = name;
        this.color = color;
    }
    
    public void draw(float x, float y, Graphics g) {
        this.x = x;
        this.y = y;
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(Color.white);
        g.drawString(name, (x), y + g.getFont().getHeight(name)/2);
        if(mouseOver) {
            g.setColor(Color.white);
            g.drawRect(x - 1, y - 1, width + 2, height + 2);
        }
    }
    
    public void update(GameContainer gc) {
        if(((gc.getInput().getMouseX() > x) && (gc.getInput().getMouseX() < x + width))
                && ((gc.getInput().getMouseY() > y) && (gc.getInput().getMouseY() < y + height))) {
            mouseOver = true;
        }else {
            mouseOver = false;
        }
     
        if(mouseOver && gc.getInput().isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            clicked = true;
        }else{
            clicked = false;
        }
        gc.getInput().clearMousePressedRecord();
        gc.getInput().clearKeyPressedRecord();
    }
    
    public float getX(){
        return x;
    }
    
    public float getY() {
        return y;
    }
    
    public float getWidth() {
        return width;
    }
    
    public float getHeight() {
        return height;
    }
    
    public boolean isClicked() {
        return clicked;
    }
}
