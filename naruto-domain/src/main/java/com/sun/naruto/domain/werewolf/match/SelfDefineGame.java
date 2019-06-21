package com.sun.naruto.domain.werewolf.match;

import com.sun.naruto.domain.base.Player;
import com.sun.naruto.domain.werewolf.role.WolfRole;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author sunjian.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SelfDefineGame extends BaseWolfGame {

    /**
     * 玩家总数
     */
    private Integer playerNumber;

    /**
     * 角色集合
     */
//    private final List<WolfRole> roles = new ArrayList<>(playerNumber);
    private List<WolfRole> roles;

    /**
     * 玩家
     */
//    private final List<User> players = new ArrayList<>(playerNumber);
    private List<Player> players;

    /**
     * 类型
     */
    private final WereWolfType type = WereWolfType.SELF_DEFINE;
}
