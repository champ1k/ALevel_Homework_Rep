package com.alvl.nix.homework.lesson13.statesubstance;

public class Water implements Substance {
    private double waterTemp = initialTemperature;
    private State waterState;

    @Override
    public State heatUp(double t) {

        waterTemp = t + waterTemp;
        if (waterTemp > getBoilingTemperature()) {
            waterState = State.GAS;
        } else if (waterTemp > getMeltingTemperature()) {
            waterState = State.LIQUID;
        } else {
            waterState = State.SOLID;
        }
        return waterState;
    }

    @Override
    public double getTemperature() {
        return waterTemp;
    }

    @Override
    public double getBoilingTemperature() {
        return 100.0;
    }

    @Override
    public double getMeltingTemperature() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "Water";
    }
}
