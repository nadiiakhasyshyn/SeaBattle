package com.example.seabattle.api.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShipApiModel {
        @JsonProperty("id")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private int id;
        @JsonProperty("name")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String type;
        @JsonProperty("size")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String brand;
        @JsonProperty("hits")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private int hits;
        @JsonProperty("boardId")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private long boardId;
        @JsonProperty("isVertical")
        private boolean isVertical;

        @JsonProperty("dragCount")
        private int dragCount;
        public ShipApiModel(){

        }
}
