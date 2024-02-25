package org.example;

import java.util.Random;

public class Gamer{
    private static int idNext = 0;
    private int id;
    private int choiceDoor;

    private boolean change = false;
    private int firstChoice;
    public Gamer(){
        this.id = idNext;
        idNext++;
    }
    public void choice(){
        this.choiceDoor = new Random().nextInt(3);
    }
    public int getChoiceDoor(){
        return choiceDoor;
    }
    public void changeChoice(int openDoor){
        firstChoice = choiceDoor;
        int[] doors = new int[3];
        doors[0] = 0;
        doors[1] = 1;
        doors[2] = 2;

        for (int door : doors) {
            if (door != choiceDoor && door != openDoor){
                choiceDoor = door;
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Gamer{" + id + '}';
    }

    public boolean isChange(){
        return change;
    }
    public int getChoice(){
        return choiceDoor;
    }
    public int getFirstChoice(){
        return firstChoice;
    }
}
