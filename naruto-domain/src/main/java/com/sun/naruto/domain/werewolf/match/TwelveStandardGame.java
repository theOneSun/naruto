package com.sun.naruto.domain.werewolf.match;

import com.sun.naruto.domain.base.Player;
import com.sun.naruto.domain.base.entity.User;
import com.sun.naruto.domain.werewolf.role.Civilian;
import com.sun.naruto.domain.werewolf.role.Guard;
import com.sun.naruto.domain.werewolf.role.Hunter;
import com.sun.naruto.domain.werewolf.role.Prophet;
import com.sun.naruto.domain.werewolf.role.Werewolf;
import com.sun.naruto.domain.werewolf.role.Witch;
import com.sun.naruto.domain.werewolf.role.WolfRole;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * 12人标准局
 * 4平民4狼人1女巫1预言家1猎人1守卫
 *
 * @author sunjian.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class TwelveStandardGame extends BaseWolfGame {

    /**
     * 玩家总数
     */
    private final Integer playerNumber = 12;

    /**
     * 角色集合
     */
    private final List<WolfRole> roles = Arrays.asList(Civilian.role,
                                                       Civilian.role,
                                                       Civilian.role,
                                                       Civilian.role,
                                                       Werewolf.role,
                                                       Werewolf.role,
                                                       Werewolf.role,
                                                       Werewolf.role,
                                                       Witch.role,
                                                       Prophet.role,
                                                       Guard.role,
                                                       Hunter.role);

    /**
     * 玩家
     */
    private final List<Player> players = new ArrayList<>(playerNumber);

    /**
     * 类型
     */
    private final WereWolfType type = WereWolfType.TWELVE_STANDARD;

    public TwelveStandardGame(UUID id,String gameCode,String name) {
        this.id = id;
        this.gameCode = gameCode;
        this.name = name;
    }

}
