package com.example.seabattle.services.impl;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class PlayerService {
    private Map<Long, String> playerGameLinks;
    private Map<Long, Long> playerGameIds;
    private Set<Long> playersCreatingBoard;

    public PlayerService() {
        playerGameLinks = new HashMap<>();
        playerGameIds = new HashMap<>();
        playersCreatingBoard = new HashSet<>();
    }

    public void saveGameLink(long playerId, String gameLink) {
        playerGameLinks.put(playerId, gameLink);
    }

    public String getGameLink(long playerId) {
        return playerGameLinks.get(playerId);
    }

    public void saveGameIdForPlayer(long playerId, long gameId) {
        playerGameIds.put(playerId, gameId);
    }

    public long getGameIdForPlayer(long playerId) {
        return playerGameIds.get(playerId);
    }

    public void setPlayerCreatingBoard(long playerId) {
        playersCreatingBoard.add(playerId);
    }

    public void setPlayerNotCreatingBoard(long playerId) {
        playersCreatingBoard.remove(playerId);
    }

    public boolean isPlayerCreatingBoard(long playerId) {
        return playersCreatingBoard.contains(playerId);
    }
}
