package com.sun.naruto.domain.werewolf.role;

import lombok.Data;

/**
 * @author sunjian.
 */
@Data
public class Werewolf implements WolfRole{
    private final String name = "狼人";
    private final String desc = "晚上讨论可以杀一人,白天可以自爆直接进入黑夜";
    public static final Werewolf role = new Werewolf();
}
