package com.example.seabattle.api.models;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameApiModel {
        @JsonProperty("id")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private int id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("isGameWithFriend")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private boolean isGameWithFriend;
        @JsonProperty("gameState")
        private String gameState;

        public GameApiModel(){

        }
}
