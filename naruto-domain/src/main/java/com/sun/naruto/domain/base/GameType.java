package com.sun.naruto.domain.base;

import lombok.Getter;

/**
 * 游戏种类
 *
 * @author sunjian.
 */
@Getter
public enum GameType {
    WEREWOLF("狼人杀", "00lrs"),
    HONOR_OF_KINGS("王者荣耀", "01wzry"),
    ;

    private String name;
    private String code;

    GameType(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
