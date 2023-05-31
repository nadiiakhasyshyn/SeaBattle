package com.example.seabattle.gamelogic;

import com.example.seabattle.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ComputerPlayer {
    private static final int GRID_SIZE = 10;

    private Random random;
    private List<int[]> targets;

    public ComputerPlayer() {
        random = new Random();
        targets = new ArrayList<>();
    }

    public void makeMove() {
        int row;
        int column;

        if (targets.isEmpty()) {
            // Якщо немає активних цілей, вибираємо випадкову невідкриту клітинку
            row = random.nextInt(GRID_SIZE);
            column = random.nextInt(GRID_SIZE);
        } else {
            // Якщо є активні цілі
            int[] lastTarget = targets.get(targets.size() - 1);
            row = lastTarget[0];
            column = lastTarget[1];

            // Перевірка наявності влучань в одному рядку або стовпці
            boolean verticalShot = random.nextBoolean();
            List<int[]> validTargets = new ArrayList<>();

            if (verticalShot) {
                // Перевірка наявності влучань у вертикальному стовпці
                for (int[] target : targets) {
                    if (target[1] == column) {
                        validTargets.add(target);
                    }
                }
            } else {
                // Перевірка наявності влучань у горизонтальному рядку
                for (int[] target : targets) {
                    if (target[0] == row) {
                        validTargets.add(target);
                    }
                }
            }

            if (!validTargets.isEmpty()) {

                int[] randomTarget = validTargets.get(random.nextInt(validTargets.size()));
                row = randomTarget[0];
                column = randomTarget[1];
            } else {

                boolean verticalDirection = random.nextBoolean();
                int direction = random.nextBoolean() ? -1 : 1;

                if (verticalDirection) {
                    // Вибираємо клітинку на тому ж стовпці
                    row += direction;
                } else {
                    column += direction;
                }
            }
        }

        // Виконуємо постріл на вибрану клітинку
        shoot(row, column);
    }

    private void shoot(int row, int column) {
        int[] target = {row, column};
        targets.add(target);
    }

    public void placeShips(Set<ShipModel> ships) {
        for (ShipModel ship : ships) {
            boolean shipPlaced = false;

            while (!shipPlaced) {
                int row = random.nextInt(GRID_SIZE);
                int column = random.nextInt(GRID_SIZE);
                boolean vertical = random.nextBoolean();

                if (canPlaceShip(ship, row, column, vertical)) {
                    placeShip(ship, row, column, vertical);
                    shipPlaced = true;
                }
            }
        }
    }

    private boolean canPlaceShip(ShipModel ship, int row, int column, boolean vertical) {
        int size = ship.getSize();

        if (vertical) {
            if (row + size > GRID_SIZE) {
                return false;
            }

            for (int i = row; i < row + size; i++) {
                if (!isCellFree(i, column)) {
                    return false;
                }
            }
        } else {
            if (column + size > GRID_SIZE) {
                return false;
            }

            for (int j = column; j < column + size; j++) {

                if (!isCellFree(row, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private void placeShip(ShipModel ship, int row, int column, boolean vertical) {
        int size = ship.getSize();
        Set<CellModel> cells = ship.getCells();

        if (vertical) {
            for (int i = row; i < row + size; i++) {
                // Позначаємо клітинку (i, column) як частину корабля
                CellModel cell = new CellModel(i, column);
                cell.setShip(ship);
                cells.add(cell);
            }
        } else {
            for (int j = column; j < column + size; j++) {

                CellModel cell = new CellModel(row, j);
                cell.setShip(ship);
                cells.add(cell);
            }
        }
    }

    private boolean isCellFree(int row, int column) {

        return true;
    }
}
