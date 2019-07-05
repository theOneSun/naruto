package com.sun.naruto.domain.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @author sunjian.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    /**
     * 用户id
     */
    private UUID userId;
    /**
     * 参加游戏的id
     */
    private UUID gameId;
    /**
     * 昵称
     */
    private String nickname;
}
