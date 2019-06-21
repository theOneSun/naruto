package com.sun.naruto.domain.werewolf.role;

import lombok.Data;

/**
 * 女巫
 *
 * @author sunjian.
 */
@Data
public class Witch implements WolfRole {
    private final String name = "女巫";
    private final String desc = "女巫有一瓶解药和一瓶毒药:1.每夜只能使用一瓶药;2.不能给自己使用解药;3.解药使用后不会知道后续黑夜的死亡情况";
    public static final Witch role = new Witch();
}
