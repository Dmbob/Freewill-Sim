/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.dmbob;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 *
 * @author Bobby
 */
public class ContextMenu {
    private int x, y, width, height;
    private GridTile tile;
    private Being person;
    private GameButton leftButton, rightButton, upButton, downButton, killButton, mateButton;
    private WorldGrid world;
    
    public ContextMenu(int x, int y, int width, int height, WorldGrid world) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.world = world;
        leftButton = new GameButton(width, 30, "Left", Color.gray);
        rightButton = new GameButton(width, 30, "Right", Color.gray);
        upButton = new GameButton(width, 30, "Up", Color.gray);
        downButton = new GameButton(width, 30, "Down", Color.gray);
        killButton = new GameButton(width, 30, "Kill", Color.gray);
        mateButton = new GameButton(width, 30, "Mate", Color.gray);
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(x, y, width, height);
        leftButton.draw(x, y, g);
        rightButton.draw(x, y+30, g);
        upButton.draw(x, y+70, g);
        downButton.draw(x, y+100, g);
        killButton.draw(x, y+130, g);
        mateButton.draw(x, y+160, g);
    }
    
    public void update(GameContainer gc) {
        leftButton.update(gc);
        rightButton.update(gc);
        upButton.update(gc);
        downButton.update(gc);
        killButton.update(gc);
        mateButton.update(gc);
        
        this.tile = GridTile.getSelected();
        if(tile != null) {
            this.person = tile.getPerson();
        } else {
            person = null;
        }
        
        if(leftButton.isClicked() && GridTile.getSelected() != null) {
            person.act(Action.LEFT);
            ConsoleDisplay.append("Moving Left...");
        }else if(rightButton.isClicked() && GridTile.getSelected() != null) {
            person.act(Action.RIGHT);
            ConsoleDisplay.append("Moving Right...");
        }else if(upButton.isClicked() && GridTile.getSelected() != null) {
            person.act(Action.UP);
            ConsoleDisplay.append("Moving Up...");
        }else if(downButton.isClicked() && GridTile.getSelected() != null) {
            person.act(Action.DOWN);
            ConsoleDisplay.append("Moving Down...");
        }else if(killButton.isClicked() && GridTile.getSelected() != null) {
            person.act(Action.KILL);
            ConsoleDisplay.append("Killing...");
        }else if(mateButton.isClicked() && GridTile.getSelected() != null) {
            person.act(Action.MATE);
            world.getPeople().add(new Being(8, 8, "b", world, person.getAdjacentTile(Action.DOWN)));
            ConsoleDisplay.append("Mating...");
        }
        gc.getInput().clearMousePressedRecord();
    }
}
