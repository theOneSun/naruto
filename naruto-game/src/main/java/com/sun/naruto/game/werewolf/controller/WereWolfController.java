package com.sun.naruto.game.werewolf.controller;

import com.sun.naruto.domain.GameCodePool;
import com.sun.naruto.domain.base.Player;
import com.sun.naruto.domain.werewolf.match.NineStandardGame;
import com.sun.naruto.domain.werewolf.match.SelfDefineGame;
import com.sun.naruto.domain.werewolf.match.TwelveStandardGame;
import com.sun.naruto.domain.werewolf.match.WereWolfType;
import com.sun.naruto.domain.werewolf.match.WolfGame;
import com.sun.naruto.domain.werewolf.role.WolfRole;
import com.sun.naruto.game.werewolf.model.CreateParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;
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
    public String teas() {
        return "123";
    }

    @PostMapping("/game/wolf")
    public WolfGame create(@RequestBody CreateParam param, HttpServletRequest request) {
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

        final ServletContext servletContext = request.getSession().getServletContext();
        servletContext.setAttribute(game.getGameCode(), game);
        return game;
    }

    /**
     * 加入房间
     *
     * @param gameCode 游戏房间号
     * @param nickname 昵称
     */
    @PostMapping("/game/wolf/apply/{gameCode}")
    public void apply(@PathVariable String gameCode, HttpServletRequest request, String nickname) {
        //todo 根据code查询,添加参与者
        final WolfGame game = (WolfGame) request.getSession().getServletContext().getAttribute(gameCode);
        if (Objects.isNull(game)) {
            throw new IllegalArgumentException("该房间不存在");
        }
        final List<Player> players = game.getPlayers();
        if (players.size() >= game.getPlayerNumber()) {
            throw new IllegalArgumentException("人满了");
        }
        players.add(new Player(UUID.randomUUID(), game.getId(), nickname));
    }

    @GetMapping("/game/wolf/{gameCode}")
    public WolfGame findGameInfo(@PathVariable String gameCode, HttpServletRequest request) {
        return (WolfGame) request.getServletContext().getAttribute(gameCode);
    }

    @PostMapping("/game/wolf/distribute/{gameCode}")
    public void distributeRole(@PathVariable String gameCode, HttpServletRequest request) {
        final WolfGame game = (WolfGame) request.getServletContext().getAttribute(gameCode);
        game.distributeRole();
    }


    @GetMapping("/game/wolf/role/{gameCode}")
    public WolfRole myRole(@PathVariable String gameCode, String userId, HttpServletRequest request) {
        final WolfGame game = (WolfGame) request.getServletContext().getAttribute(gameCode);
        //根据userId查询玩家

        return game.selectPlayerRole(new Player(UUID.fromString(userId), UUID.randomUUID(), "hehe"));
    }

}
