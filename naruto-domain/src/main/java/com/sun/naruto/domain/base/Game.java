package com.sun.naruto.domain.base;

import lombok.Data;

import java.util.UUID;

/**
 * @author sunjian.
 */
@Data
public abstract class Game {
    private UUID id;
    //房间号
    private String code;
    //局名称
    private String name;

    private GameType gameType;
}
