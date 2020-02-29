package com.alvl.nix.homework.lesson12.controller;

import com.alvl.nix.homework.lesson12.model.Players;
import com.alvl.nix.homework.lesson12.model.TicTacToe;

public class GameLoop {

    private final TicTacToe model;

    private final Players players;

    public GameLoop(TicTacToe model, Players players) {
        this.model = model;
        this.players = players;
    }

    public void gameLoop() {
        model.startGame(players);
    }

}
