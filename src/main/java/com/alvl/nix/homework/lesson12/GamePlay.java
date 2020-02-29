package com.alvl.nix.homework.lesson12;

import com.alvl.nix.homework.lesson12.controller.GameLoop;
import com.alvl.nix.homework.lesson12.model.Players;
import com.alvl.nix.homework.lesson12.model.TicTacToe3x3;

public class GamePlay {
    public static void main(String[] args) {
        var gameplay = new GameLoop(new TicTacToe3x3(), new Players());
        gameplay.gameLoop();
    }
}
