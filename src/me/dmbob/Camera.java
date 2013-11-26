/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.dmbob;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

/**
 *
 * @author Bobby
 */
public class Camera {
    private int CAM_SPEED = 10;
    private float scale = 1;
    private int x, y;
    
    public Camera(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void place(Graphics g) {
        g.translate(-x, -y);
        g.scale(scale, scale);
    }
    
    public void update(GameContainer gc) {
        int scrollWheel = Mouse.getDWheel();
        if(gc.getInput().isKeyDown(Input.KEY_LEFT)) {
            x-=CAM_SPEED;
        }
        if(gc.getInput().isKeyDown(Input.KEY_RIGHT)) {
            x+=CAM_SPEED;
        }
        if(gc.getInput().isKeyDown(Input.KEY_UP)) {
            y-=CAM_SPEED;
        }
        if(gc.getInput().isKeyDown(Input.KEY_DOWN)) {
            y+=CAM_SPEED;
        }
        
        if (scrollWheel < 0) {
            scale *= 0.5;
        }else if (scrollWheel > 0) {
            scale /= 0.5;
        }
    }
}
