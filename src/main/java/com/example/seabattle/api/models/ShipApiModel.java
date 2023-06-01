package com.example.seabattle.api.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShipApiModel {
        @JsonProperty("id")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private long id;
        @JsonProperty("name")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private String name;
        @JsonProperty("size")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private int size;
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

        public int getSize() {
                return size;
        }

        public void setSize(int size) {
                this.size = size;
        }

        public int getHits() {
                return hits;
        }

        public void setHits(int hits) {
                this.hits = hits;
        }

        public long getBoardId() {
                return boardId;
        }

        public void setBoardId(long boardId) {
                this.boardId = boardId;
        }

        public boolean isVertical() {
                return isVertical;
        }

        public void setVertical(boolean vertical) {
                isVertical = vertical;
        }

        public int getDragCount() {
                return dragCount;
        }

        public void setDragCount(int dragCount) {
                this.dragCount = dragCount;
        }
}
