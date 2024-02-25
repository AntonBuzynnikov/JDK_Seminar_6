package org.example;

import com.google.common.collect.Maps;

import java.util.HashMap;

public class Main {
    public static HashMap<String,Integer> resultStat = Maps.newHashMap();
    private static final int COUNT_GAME = 1000000;
    public static void main(String[] args) {
        resultStat.put("win", 0);
        resultStat.put("lose", 0);

        for (int i = 0; i < COUNT_GAME; i++) {
            Game game = new Game();
            game.addGamer(new Gamer());
            game.startNewGame();
        }
        double statWin = (double) resultStat.get("win")/COUNT_GAME * 100;
        double statLose = (double) resultStat.get("lose") /COUNT_GAME * 100;
        System.out.println("Процент побед при изменении выбора = " + statWin);
        System.out.println("Процент поражений при изменении выбора = " + statLose);
    }
}