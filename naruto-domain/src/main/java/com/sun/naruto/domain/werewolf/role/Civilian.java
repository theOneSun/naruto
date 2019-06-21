package com.sun.naruto.domain.werewolf.role;

import lombok.Getter;

/**
 * 平民
 *
 * @author sunjian.
 */
@Getter
public class Civilian implements WolfRole {
    private final String name = "平民";
    private final String desc = "只在白天拥有投票权";
    public static final Civilian role = new Civilian();
}
