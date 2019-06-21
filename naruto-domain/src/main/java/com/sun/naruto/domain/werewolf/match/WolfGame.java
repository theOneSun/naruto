package com.sun.naruto.domain.werewolf.match;

import com.sun.naruto.domain.base.Player;
import com.sun.naruto.domain.werewolf.role.WolfRole;

import java.util.List;
import java.util.UUID;

/**
 * @author sunjian.
 */
public interface WolfGame {

    UUID getId();

    /**
     * 游戏房间码
     *
     * @return 游戏房间码
     */
    String getGameCode();

    /**
     * 游戏房间名称
     *
     * @return 游戏房间名称
     */
    String getName();

    Integer getPlayerNumber();

    WereWolfType getType();

    List<WolfRole> getRoles();

    List<Player> getPlayers();

}
