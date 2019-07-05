package com.sun.naruto.domain.werewolf.match;

import com.sun.naruto.domain.base.Player;
import com.sun.naruto.domain.werewolf.role.WolfRole;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author sunjian.
 */
@Getter
@Setter
@ToString
public abstract class BaseWolfGame implements WolfGame {
    protected UUID id;
    protected String gameCode;
    protected String name;
    protected Map<Player, WolfRole> playerRoleMap;
    //    private Integer playerNumber;
    //    private List<WolfRole> roles;
    //    private List<User> players;
    //    private WereWolfType type;

    //分配角色
    public void distributeRole() {
        Map<Player, WolfRole> playerRoleMap = new HashMap<>();
        final int playerNumber = this.getPlayerNumber();
        final List<Player> players = new ArrayList<>(playerNumber);
        final List<WolfRole> roles = new ArrayList<>(playerNumber);

        if (playerNumber != this.getPlayers().size()) {
            throw new RuntimeException("Please wait");
        }
        if (this.getPlayers().size() != this.getRoles().size()) {
            throw new RuntimeException("system err!!!");
        }

        CollectionUtils.addAll(players, this.getPlayers());
        CollectionUtils.addAll(roles, this.getRoles());

        Collections.shuffle(players);
        Collections.shuffle(roles);


        for (int i = 0; i < playerNumber; i++) {
            playerRoleMap.put(players.get(i), roles.get(i));
        }

        this.setPlayerRoleMap(playerRoleMap);
    }

    public WolfRole selectPlayerRole(Player player) {
        final Map<Player, WolfRole> playerRoleMap = this.getPlayerRoleMap();
        for (Map.Entry<Player,WolfRole> entry: playerRoleMap.entrySet()){
            final Player p = entry.getKey();
            if (p.getUserId().equals(player.getUserId())){
                return entry.getValue();
            }
        }
        throw new IllegalArgumentException("未报名");
    }
}
