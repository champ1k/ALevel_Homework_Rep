package com.alvl.nix.homework.lesson13.statesubstance;

import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;

public class Chemistry {
    public static void main(String[] args) {
        String chooseSubstance = "Choose yout substance: 1 - Oxygen, 2 - Water, 3 - Iron!";
        var scannerSubstance = new Scanner(System.in);
        Substance substance = null;
        System.out.println(chooseSubstance);
        switch (scannerSubstance.nextInt()) {
            case 1:
                substance = new Oxygen();
                break;
            case 2:
                substance = new Water();
                break;
            case 3:
                substance = new Iron();
                break;
        }
        System.out.println("Your substance is - " + substance.toString() + ". It's temperature is - " + substance.getTemperature() + ". It's state - " + substance.heatUp(0.0) + ".");

        while(true)
        {
            double enteredTemperature;
            System.out.println("Enter temperature on what you want to change:");
            enteredTemperature = scannerSubstance.nextDouble();
            if (enteredTemperature == 0.0) {
                break;
            }
            double beforeChange = substance.getTemperature();
            State afterChageState = substance.heatUp(enteredTemperature);
            double afterChange = substance.getTemperature();
            System.out.println("Temperature was - " + beforeChange + ".Now it's " + afterChange + ".State change to " + afterChageState + "");
        }
    }
}
