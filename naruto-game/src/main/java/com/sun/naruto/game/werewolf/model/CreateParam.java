package com.sun.naruto.game.werewolf.model;

import com.sun.naruto.domain.werewolf.match.WereWolfType;
import lombok.Data;

/**
 * @author sunjian.
 */
@Data
public class CreateParam {
    private String name;
    private WereWolfType type;
}
