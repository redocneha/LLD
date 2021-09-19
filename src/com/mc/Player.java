package com.mc;

public class Player {
    String name;
    int pos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public Player(String name, int pos){
        this.name = name;
        this.pos = pos;
    }
}
