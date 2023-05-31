package com.example.seabattle.models;

import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name="ship")
public class ShipModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "size")
    private int size;

    @Column(name = "hits")
    private int hits;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable=false)
    private BoardModel board;
    @OneToMany(mappedBy="ship", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CellModel> cells;

    @Column(name = "isVertical")
    boolean isVertical;

    @Column(name = "dragCount")
    int dragCount;

    public ShipModel(String name, int size, Set<CellModel> cells, int dragCount) {
        this.name = name;
        this.size = size;
        this.hits = 0;
        this.cells = cells;
        this.dragCount = dragCount;
    }

    public ShipModel() {

    }

    public Long getId() {
        return id;
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

    public Set<CellModel> getCells() {
        return cells;
    }

    public void setCells(Set<CellModel> cells) {
        this.cells = cells;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public BoardModel getBoard() {
        return board;
    }

    public void setBoard(BoardModel board) {
        this.board = board;
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

    // Метод, який перевіряє, чи затоплений корабель
    public boolean isSunk() {
        return hits >= size;
    }
}
