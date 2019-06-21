package com.sun.naruto.domain.werewolf.match;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * @author sunjian.
 */
@Getter
@Setter
@ToString
public abstract class BaseWolfGame implements WolfGame{
    protected UUID id;
    protected String gameCode;
    protected String name;
//    private Integer playerNumber;
//    private List<WolfRole> roles;
//    private List<User> players;
//    private WereWolfType type;
}
