/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.dmbob;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 *
 * @author Bobby
 */
public class WorldGrid {
    private int x, y, width, height;
    //private GridTile[][] tiles;
    private GridTile tile;
    
    public WorldGrid(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        //tiles = new GridTile[width][height];
        tile = new GridTile(x, y, width, height);
    }
    
    public void draw(Graphics g) {
        /*for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                tiles[i][j].draw(g);
            }
        }*/
        tile.draw(g);
        g.setColor(Color.green);
        g.drawRect(x - 1, y - 1, width + 2, height + 2);
    }
}
