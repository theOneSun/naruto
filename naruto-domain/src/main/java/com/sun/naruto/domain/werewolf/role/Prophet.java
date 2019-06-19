package com.sun.naruto.domain.werewolf.role;

import lombok.Data;

/**
 * @author sunjian.
 */
@Data
public class Prophet implements WolfRole{
    private final String name = "预言家";
    private final String desc = "可以在晚上指定查看一名玩家的身份,只可知道是狼人还是好人";
}
