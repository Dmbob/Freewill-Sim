/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.dmbob;

import java.util.ArrayList;
import java.util.Random;
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
    private Being person, ladyPerson;
    private ArrayList<Being> heldPeople;
    
    public WorldGrid(int x, int y, int width, int height) {
        tiles = new ArrayList<ArrayList<GridTile>>();
        heldPeople = new ArrayList<Being>();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        for(int i = 0; i < width/32; i++) {
            tiles.add(new ArrayList<GridTile>());
            for(int j = 0; j < height/32; j++) {
                tiles.get(i).add(new GridTile(32, 32, i, j));
            }
        }
        for(int p = 0; p < 10; p++) {
            heldPeople.add(new Being(16, 16, "m", this, tiles.get((int) (Math.random()*tiles.get(p).size())).get((int) (Math.random()*tiles.size()))));
        }
    }
    
    public void draw(Graphics g) {
       
       /* for(int i = 0; i < width/32; i+=32) {
            for(int j = 0; j < height/32; j+=32) {
                tiles.get(i).get(j).draw(i, j, g);
            }
        }*/
        for (ArrayList<GridTile> list : tiles) {
            for (GridTile tile : list) {
                tile.draw(tile.getX()*32, tile.getY()*32, g);
            }
        }
        g.setColor(Color.green);
        g.drawRect(x - 1, y - 1, width + 2, height + 2);
       // tiles.get(0).get(0).setPerson(person);
       // tiles.get(32).get(32).setPerson(ladyPerson);
    }
    
    public ArrayList<ArrayList<GridTile>> getTiles() {
        return tiles;
    }
     
    public ArrayList<Being> getPeople() {
         return heldPeople;   
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getY() {
        return y;
    }
    
    public int getX() {
        return x;
    }
    
    public void update(GameContainer gc) {
        if(gc.getInput().isKeyPressed(Input.KEY_SPACE)) {
            for(int i = 0; i < heldPeople.size(); i++) {
                heldPeople.get(i).actRandomly();
                if(heldPeople.get(i).makeBaby()) {
                    heldPeople.add(new Being(8, 8, "b", this, heldPeople.get(i).getAdjacentTile(Action.DOWN)));
                }
                if(heldPeople.get(i).playerKilled()) {
                    heldPeople.remove(i);
                }
            }
        }
    }
}
