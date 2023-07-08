package org.example.myFirstProject;

public class Player {
   private  int id;
   private final String Name;
   private  int currentPosition;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Player(String name) {
        Name = name;
        currentPosition =0;
    }

}
