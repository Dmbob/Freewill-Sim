/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package me.dmbob;

/**
 *
 * @author Bobby
 */
public class ContextMenu {
    private GridTile tile;
    private Being person;
    private boolean visible = false;
    
    public ContextMenu(GridTile tile) {
        this.tile = tile;
        this.person = tile.getPerson();
    }
    
    public void setVisible(boolean b) {
        if(b == true) {
            ConsoleDisplay.clear();
            if(person != null) {
                 
            }
        }else {
            ConsoleDisplay.clear();
        }
    }
}
