package com.sun.naruto.domain.werewolf.role;

import lombok.Getter;

/**
 * 守卫
 *
 * @author sunjian.
 */
@Getter
public class Guard implements WolfRole {
    private final String name = "守卫";
    private final String desc = "每晚可守护一名玩家.连续的两夜不可守护同一玩家.";
    public static final Guard role = new Guard();
}
