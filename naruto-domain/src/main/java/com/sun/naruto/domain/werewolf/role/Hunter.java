package com.sun.naruto.domain.werewolf.role;

import lombok.Data;

/**
 * 猎人
 *
 * @author sunjian.
 */
@Data
public class Hunter implements WolfRole {
    private final String name = "猎人";
    private final String desc = "死亡时可以翻牌开枪带走一名玩家.被女巫的毒死不可以发动技能.";
    public static final Hunter role = new Hunter();
}
