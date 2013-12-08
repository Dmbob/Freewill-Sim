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
        for(int i = 0; i < width; i++) {
            tiles.add(new ArrayList<GridTile>());
            for(int j = 0; j < height; j++) {
                tiles.get(i).add(new GridTile(32, 32));
            }
        }
  
        person = new Being(16, 16, "m", "poop", this, tiles.get(0).get(0));
        ladyPerson = new Being(16, 16, "f", "poop 2", this, tiles.get(32).get(32));
        heldPeople.add(person);
        heldPeople.add(ladyPerson);
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
        tiles.get(32).get(32).setPerson(ladyPerson);
    }
    
    public ArrayList<ArrayList<GridTile>> getTiles() {
        return tiles;
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
    
    public ArrayList<Being> getPeople() {
        return heldPeople;
    }
    
    public void update(GameContainer gc) {
        for(int i = 0; i < tiles.size(); i+=32) {
            for(int j = 0; j < tiles.get(i).size(); j+=32) {
                tiles.get(i).get(j).update(gc);
            }
        }
        
        if(gc.getInput().isKeyPressed(Input.KEY_SPACE)) {
            person.update(gc);
            ladyPerson.update(gc);
        }
        
        
    }
}
