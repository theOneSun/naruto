package com.sun.naruto.domain.werewolf.role;

import lombok.Data;

/**
 * 守卫
 *
 * @author sunjian.
 */
@Data
public class Guard implements WolfRole {
    private final String name = "守卫";
    private final String desc = "每晚可守护一名玩家.连续的两夜不可守护同一玩家.";
    public static final Guard role = new Guard();
}
