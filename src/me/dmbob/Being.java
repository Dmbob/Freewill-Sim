package me.dmbob;


import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bobby
 */
public class Being {
    private int width, height;
    private String gender;
    private int curX = 0, curY = 0;
    private WorldGrid world;
    private GridTile curTile, adjacentTile;
    private ContextMenu menu;
    private boolean mouseOver = false, personFound = false, playerKilled = false, spawnBaby = false, isBaby = false;
    private ArrayList<Action> actions;
    private int pick = 0;
    private String name;
    
    public Being(int width, int height, String gender, WorldGrid world, GridTile tile) {
        this.width = width;
        this.height = height;
        this.gender = gender;
        this.world = world;
        this.curTile = tile;
        this.curTile.setPerson(this);
        //menu = new ContextMenu(x + 128, y, 128, 256, this);
        actions = new ArrayList<Action>();
        for(int a = 0; a < Action.values().length; a++) {
           actions.add(Action.values()[a]);
       }
    }
 
    public void draw(Graphics g) {
        if(gender.equalsIgnoreCase("m")) {
            g.setColor(Color.blue);
        }else if(gender.equalsIgnoreCase("f")) {
            g.setColor(Color.red);
        }else if(gender.equalsIgnoreCase("b")) {
            isBaby = true;
        }
        g.fillRect(curTile.getWidth()/2 - this.width/2, curTile.getHeight()/2 - this.height/2, width, height);
       // menu.draw(g);
    }
    
    public int getPick() {
        return pick;
    }
    
    public ArrayList<Action> getActions() {
        return actions;
    }

    public void move(Action a) {
        adjacentTile = getAdjacentTile(a);
        System.out.println(adjacentTile);
        if(curTile == null || adjacentTile == null) { return; }
        //if(curTile.containsPerson() || newTile.containsPerson()) {return; }
        //curTile.removePerson();
        curTile.setPerson(null);
        curTile = adjacentTile.setPerson(this);
    }
    
    public void actRandomly() {
        Action current = actions.get((int) (Math.random()*actions.size()));
        this.act(current);
        actions.add(current);
        System.out.println(current);
        System.out.println(actions.size());
    }
    
    public GridTile getAdjacentTile(Action a) {
        GridTile newTile = null;
        try {
            if(a.equals(Action.UP)) {
                newTile = world.getTiles().get(getX()).get(getY()-1);
               // newTile = world.getTiles().get(getTile().getX()).get(getTile().getY() - 32);
            }
            if(a.equals(Action.DOWN)) {
                newTile = world.getTiles().get(getX()).get(getY()+1);
                //newTile = world.getTiles().get(getTile().getX()).get(getTile().getY() + 32); 
            }
            if(a.equals(Action.LEFT)) {
                newTile = world.getTiles().get(getX()-1).get(getY());
                //newTile = world.getTiles().get(getTile().getX() - 32).get(getTile().getY());
            }
            if(a.equals(Action.RIGHT)) {
                newTile = world.getTiles().get(getX()+1).get(getY());
                //newTile = world.getTiles().get(getTile().getX() + 32).get(getTile().getY());
            }
        }catch(Exception ex) {
            //ex.printStackTrace();
            newTile = curTile;
             //newTile = null;
        }
        return newTile;
    }
    
    public boolean playerKilled() {
        return playerKilled;
    }
    
    public boolean makeBaby() {
        return spawnBaby;
    }

    public void act(Action a) {
        //curTile.setPerson(null);
        //curTile.removePerson();
        
        if(a.equals(Action.UP) || a.equals(Action.DOWN) || a.equals(Action.LEFT) || a.equals(Action.RIGHT)) {
            move(a);
        }
        
        for (Action dir : MainGame.MOVE_ACTIONS) {
            if(getAdjacentTile(dir) != null) {
                Being person = getAdjacentTile(dir).getPerson();
                if(person != null && person != this) {
                    System.out.println("Hello Person " + name + ", How are you?"); 
                    personFound = true;
                }
                if(personFound && a.equals(Action.KILL)) {
                    try {
                    person.getTile().setPerson(null);
                    }catch (NullPointerException ex) {
                        System.out.println("Player Killed");
                    }
                    playerKilled = true;
                }
                if(personFound && a.equals(Action.MATE) && !isBaby) {
                    spawnBaby = true;
                }else {
                    spawnBaby = false;
                }
            }
        }
        
        
        //if(a.equals(Action.KILL)) {
            //world.getPeople().get((int)(Math.random()*world.getPeople().size())).getTile().removePerson();
        //}
        
        
    }
    
    public int getRealX() {
        return curTile.getX()*32;
    }
    
    public int getRealY() {
        return curTile.getY()*32;
    }
    
    public int getX() {
        return curTile.getX();
    }
    
    public int getY() {
        return curTile.getY();
    }
    
    public GridTile getTile() {
        return curTile;
    }
    
    public void update(GameContainer gc) {
        int pick = (int) (Math.random()*actions.size());
        Action prev;
        //act(actions.get(pick));
        prev = actions.get(pick);
        actions.add(prev);
       // ConsoleDisplay.append("Player " + name + " Action: " + prev.toString());
    }
    
    public String toString() {
        return "name: " + this.name + ", " + getRealX() + ", " + getRealY();
    }
}
