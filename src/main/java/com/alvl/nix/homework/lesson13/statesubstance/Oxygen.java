package com.alvl.nix.homework.lesson13.statesubstance;

public class Oxygen implements Substance {
    private double oxygenTemp = initialTemperature;
    private State oxygenState;

    @Override
    public State heatUp(double t) {
        oxygenTemp = t + initialTemperature;
        if (oxygenTemp > getBoilingTemperature()) {
            oxygenState = State.GAS;
        } else if (oxygenTemp > getMeltingTemperature()) {
            oxygenState = State.LIQUID;
        } else {
            oxygenState = State.SOLID;
        }
        return oxygenState;
    }

    @Override
    public double getTemperature() {
        return oxygenTemp;
    }

    @Override
    public double getBoilingTemperature() {
        return -182.96;
    }

    @Override
    public double getMeltingTemperature() {
        return -218.35;
    }

    @Override
    public String toString() {
        return "Oxygen";
    }
}
