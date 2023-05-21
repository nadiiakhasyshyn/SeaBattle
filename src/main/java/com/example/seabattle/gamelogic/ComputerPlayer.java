package com.example.seabattle.gamelogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
                // Якщо є влучання у вертикальному стовпці або горизонтальному рядку,
                // вибираємо наступну клітинку поруч з останнім влучанням
                int[] randomTarget = validTargets.get(random.nextInt(validTargets.size()));
                row = randomTarget[0];
                column = randomTarget[1];
            } else {
                // Якщо немає влучань у вертикальному стовпці або горизонтальному рядку,
                // вибираємо клітинку поруч з останньою влученою ціллю
                boolean verticalDirection = random.nextBoolean();
                int direction = random.nextBoolean() ? -1 : 1;

                if (verticalDirection) {
                    // Вибираємо клітинку на тому ж стовпці
                    row += direction;
                } else {column += direction;

                }
            }
            // Виконуємо постріл на вибрану клітинку
            shoot(row, column);
        }

        // Виконуємо постріл на вибрану клітинку
        shoot(row, column);
    }

    private void shoot(int row, int column) {
        // Логіка пострілу на задану клітинку

        // Додаткова логіка для визначення влучання і оновлення активних цілей

        // Додамо влучану клітинку до активних цілей
        targets.add(new int[]{row, column});
    }
}
