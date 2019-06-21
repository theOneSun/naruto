package com.sun.naruto.game.werewolf.controller;

import com.sun.naruto.domain.GameCodePool;
import com.sun.naruto.domain.werewolf.match.NineStandardGame;
import com.sun.naruto.domain.werewolf.match.SelfDefineGame;
import com.sun.naruto.domain.werewolf.match.TwelveStandardGame;
import com.sun.naruto.domain.werewolf.match.WereWolfType;
import com.sun.naruto.domain.werewolf.match.WolfGame;
import com.sun.naruto.game.werewolf.model.CreateParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author sunjian.
 */
@RestController
//@RequestMapping("/game/wolf")
public class WereWolfController {
    /*public static BaseWolfGame createGame(WereWolfType type){
        if (WereWolfType.TWELVE_STANDARD.equals(type)){
            final TwelveStandardGame twelveStandardGame = new TwelveStandardGame(UUID.randomUUID(),"20190620","狼人杀测试1");
            twelveStandardGame.setGameCode("123");
            twelveStandardGame.getPlayers().add(new Player(UUID.randomUUID(),UUID.randomUUID()));
            System.out.println(twelveStandardGame.getPlayers());
            return twelveStandardGame;
        }else {
            final SelfDefineGame game = new SelfDefineGame();
            game.setRoles(new ArrayList<>());
            game.setPlayerNumber(0);
            return game;
        }

    }

    public static void main(String[] args) {
        final WolfGame game = createGame(WereWolfType.TWELVE_STANDARD);
        System.out.println(game);
        final WolfGame game2 = createGame(WereWolfType.SELF_DEFINE);
        System.out.println(game2);
    }*/

    @GetMapping("/game/wolf")
    public String teas()
    {return "123";}

    @PutMapping("/game/wolf")
    public WolfGame create(@RequestBody CreateParam param) {
        final WereWolfType type = param.getType();
        final String name = param.getName();

        WolfGame game;
        switch (type) {
            case TWELVE_STANDARD:
                game = new TwelveStandardGame(UUID.randomUUID(), GameCodePool.generateCode(), name);
                break;
            case NINE_STANDARD:
                game = new NineStandardGame(UUID.randomUUID(), GameCodePool.generateCode(), name);
                break;
            case SELF_DEFINE:
                game = new SelfDefineGame();
                break;
            default:
                throw new IllegalArgumentException("未知类型");
        }
        return game;
    }
}
