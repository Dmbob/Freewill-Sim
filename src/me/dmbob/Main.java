/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.dmbob;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Bobby
 */
public class Main extends StateBasedGame {

    public Main(String name) {
        super(name);
    }
    
    public static void main(String[] args) throws SlickException{
        AppGameContainer game = new AppGameContainer(new Main("Freewill Sim"));
        game.setDisplayMode(800, 600, false);
        game.setTargetFrameRate(60);
        game.start();
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.addState(new MainMenu());
        this.addState(new MainGame());
    }
}
