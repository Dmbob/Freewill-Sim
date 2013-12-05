/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.dmbob;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

/**
 *
 * @author Bobby
 */
public class WorldGrid {
    private int x, y, width, height;
    private ArrayList<ArrayList<GridTile>> tiles;
    private Being person;
    
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
        person = new Being(16, 16, "m", this, tiles.get(0).get(0));
    }
    
    public void draw(Graphics g) {
        for(int i = 0; i < width; i+=32) {
            for(int j = 0; j < height; j+=32) {
                tiles.get(i).get(j).draw(i, j, g);
            }
        }
        g.setColor(Color.green);
        g.drawRect(x - 1, y - 1, width + 2, height + 2);
        tiles.get(0).get(0).setPerson(person);
    }
    
    public ArrayList<ArrayList<GridTile>> getTiles() {
        return tiles;
    }
    
    public void update(GameContainer gc) {
        for(int i = 0; i < tiles.size(); i+=32) {
            for(int j = 0; j < tiles.get(i).size(); j+=32) {
                tiles.get(i).get(j).update(gc);
            }
        }if(gc.getInput().isKeyPressed(Input.KEY_SPACE)) {
            person.act(Action.DOWN);
        }
    }
}
