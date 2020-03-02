package com.alvl.nix.homework.lesson13.statesubstance;

public interface Substance {
        double initialTemperature = 20.0;
        State heatUp(double t);
        double getTemperature();
        double getBoilingTemperature();
        double getMeltingTemperature();
}
