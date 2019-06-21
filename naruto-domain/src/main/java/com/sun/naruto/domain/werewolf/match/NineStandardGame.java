package com.sun.naruto.domain.werewolf.match;

import com.sun.naruto.domain.base.Player;
import com.sun.naruto.domain.base.entity.User;
import com.sun.naruto.domain.werewolf.role.Civilian;
import com.sun.naruto.domain.werewolf.role.Hunter;
import com.sun.naruto.domain.werewolf.role.Prophet;
import com.sun.naruto.domain.werewolf.role.Werewolf;
import com.sun.naruto.domain.werewolf.role.Witch;
import com.sun.naruto.domain.werewolf.role.WolfRole;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * 9人标准局
 * 3平民3狼人1女巫1预言家1猎人
 *
 * @author sunjian.
 */
@Getter
public class NineStandardGame extends BaseWolfGame {

    public NineStandardGame(UUID id, String gameCode, String name) {
        this.id = id;
        this.gameCode = gameCode;
        this.name = name;
    }

    /**
     * 玩家总数
     */
    private final Integer playerNumber = 9;

    /**
     * 角色集合
     */
    private final List<WolfRole> roles = Arrays.asList(Civilian.role,
                                                       Civilian.role,
                                                       Civilian.role,
                                                       Werewolf.role,
                                                       Werewolf.role,
                                                       Werewolf.role,
                                                       Witch.role,
                                                       Prophet.role,
                                                       Hunter.role);

    /**
     * 玩家
     */
    private final List<Player> players = new ArrayList<>(playerNumber);

    private final WereWolfType type = WereWolfType.NINE_STANDARD;
}
