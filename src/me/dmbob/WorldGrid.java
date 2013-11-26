/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.dmbob;

import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 *
 * @author Bobby
 */
public class WorldGrid {
    private int x, y, width, height;
    private ArrayList<ArrayList<GridTile>> tiles;
    
    public WorldGrid(int x, int y, int width, int height) {
        tiles = new ArrayList<ArrayList<GridTile>>();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        for(int i = 0; i < width; i++) {
            tiles.add(new ArrayList<GridTile>());
            for(int j = 0; j < height; j++) {
                tiles.get(i).add(new GridTile(32, 32));
            }
        }
    }
    
    public void draw(Graphics g) {
        for(int i = 0; i < width; i+=32) {
            for(int j = 0; j < height; j+=32) {
                tiles.get(i).get(j).draw(i, j, g);
            }
        }
        g.setColor(Color.green);
        g.drawRect(x - 1, y - 1, width + 2, height + 2);
    }
    
    public ArrayList<ArrayList<GridTile>> getTiles() {
        return tiles;
    }
}
