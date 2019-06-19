package com.sun.naruto.game.werewolf.service;

import com.sun.naruto.game.werewolf.entity.TwelveStandardGame;
import com.sun.naruto.game.werewolf.entity.WolfGame;

/**
 * @author sunjian.
 */
public class WolfService {
    public void create(){
        final WolfGame wolfGame = new TwelveStandardGame();
        final Integer playerNumber = wolfGame.getPlayerNumber();
    }
}
