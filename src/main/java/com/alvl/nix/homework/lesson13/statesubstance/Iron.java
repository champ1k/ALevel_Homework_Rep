package com.alvl.nix.homework.lesson13.statesubstance;

public class Iron implements Substance {
    private double ironTemp = initialTemperature;
    private State ironState;

    @Override
    public State heatUp(double t) {
        ironTemp = t + initialTemperature;
        if (ironTemp > getBoilingTemperature()) {
            ironState = State.GAS;
        } else if (ironTemp > getMeltingTemperature()) {
            ironState = State.LIQUID;
        } else {
            ironState = State.SOLID;
        }
        return ironState;
    }

    @Override
    public double getTemperature() {
        return ironTemp;
    }

    @Override
    public double getBoilingTemperature() {
        return 2862.0;
    }

    @Override
    public double getMeltingTemperature() {
        return 1538.0;
    }

    @Override
    public String toString() {
        return "Iron";
    }
}
