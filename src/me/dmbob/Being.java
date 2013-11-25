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
    private int MOVE_SPEED = 7;
    private int MAX_DISTANCE = 20;
    private int x, y, width, height;
    private String gender;
    private int curX = 0, curY = 0;
    
    public Being(int x, int y, int width, int height, String gender) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gender = gender;
    }
    
    public void move(Direction d, int delta) {
        
        if(d.equals(Direction.UP)) {
            y-=MOVE_SPEED / delta;
            curX = x;
            curY = y;
        }
        if(d.equals(Direction.DOWN)) {
            y+=MOVE_SPEED / delta;
            curX = x;
            curY = y;
        }
        if(d.equals(Direction.LEFT)) {
            x-=MOVE_SPEED / delta;
            curX = x;
            curY = y;
        }
        if(d.equals(Direction.RIGHT)) {
            x+=MOVE_SPEED / delta;
            curX = x;
            curY = y;
        }
    }
    
    public void draw(Graphics g) {
        if(gender.equalsIgnoreCase("m")) {
            g.setColor(Color.blue);
        }else if(gender.equalsIgnoreCase("f")) {
            g.setColor(Color.red);
        }
        g.fillRect(x, y, width, height);
    }
    
    public void mingle() {
        int pick = new Random().nextInt(Direction.values().length);
        //move(Direction.values()[pick], );
    }
    
    public void update(GameContainer gc) {
       
    }
}
