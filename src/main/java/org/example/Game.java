package org.example;

import com.google.common.collect.Maps;

import java.util.*;

public class Game {
    private boolean[] doors;
    private boolean prize = false;
    private List<Gamer> gamers;
    private int openDoorIndex;
    public Game (){
        this.doors = new boolean[3];
        initGame();
        gamers = new ArrayList<>();
    }

    private void initGame(){
        for (int i = 0; i < doors.length; i++) {
            if (i == (doors.length - 1) && !prize){
                doors[i] = true;
            } else if (prize) {
                doors[i] = false;
            } else {
                doors[i] = new Random().nextBoolean();
                if(doors[i]) prize = true;
            }
        }
    }

    public void addGamer(Gamer gamer){
        gamers.add(gamer);
    }
    public void startNewGame(){
        for (Gamer gamer: gamers){
            gamer.choice();
            openDoorIndex = openDoor(gamer.getChoice());
            if(openDoorIndex == -1){
                System.out.println("Except");
                return;
            }
            gamer.changeChoice(openDoorIndex);
            result(gamer.getChoice());
        }
    }
    public int openDoor(int choice){
        for (int i = 0; i < doors.length; i++) {
            if(i != choice && !doors[i]){
                return i;
            }
        }
        return -1;
    }
    public void result(int choice){
        if(doors[choice]){
            Main.resultStat.put("win",Main.resultStat.get("win") + 1);
        } else{
            Main.resultStat.put("lose",Main.resultStat.get("lose") + 1);
        }
    }


}
