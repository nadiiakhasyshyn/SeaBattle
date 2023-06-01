package com.example.seabattle.api.models;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameApiModel {
        @JsonProperty("id")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private long id;
        @JsonProperty("name")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String name;
        @JsonProperty("playerName")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String playerName;
        @JsonProperty("gameState")
        private String gameState;

        public GameApiModel(){

        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }


        public String getGameState() {
                return gameState;
        }

        public void setGameState(String gameState) {
                this.gameState = gameState;
        }

        public String getPlayerName() {
                return playerName;
        }

        public void setPlayerName(String playerName) {
                this.playerName = playerName;
        }
}
