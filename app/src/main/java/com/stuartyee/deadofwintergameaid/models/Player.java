package com.stuartyee.deadofwintergameaid.models;

public class Player {
    private String name;
    private Integer dice;
    private Boolean isTurn;
    private Boolean isExiled;
    private Integer[] dieResults;

    public Player(){}

    public Player(String name) {
        this.name = name;
        this.dice = 4;
        this.isTurn = false;
        this.isExiled = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDice() {
        return dice;
    }

    public void setDice(Integer dice) {
        this.dice = dice;
    }

    public Boolean getTurn() {
        return isTurn;
    }

    public void setTurn(Boolean turn) {
        isTurn = turn;
    }

    public Boolean getExiled() {
        return isExiled;
    }

    public void setExiled(Boolean exiled) {
        isExiled = exiled;
    }

    public Integer[] getDieResults() {
        return dieResults;
    }

    public void setDieResults(Integer[] dieResults) {
        this.dieResults = dieResults;
    }
}
