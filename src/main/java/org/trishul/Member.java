package org.trishul;

public class Member {
    private String name;
    private int coins;

    public Member(String name, int coins){
        this.name = name;
        this.coins = coins;
    }

    public String getName(){
        return this.name;
    }

    public int getCoins(){
        return this.coins;
    }

    public void setCoins(int coins){
        this.coins = coins;
    }
}
