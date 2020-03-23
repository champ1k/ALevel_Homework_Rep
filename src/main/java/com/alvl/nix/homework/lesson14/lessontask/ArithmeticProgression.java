package com.alvl.nix.homework.lesson14.lessontask;


public class ArithmeticProgression {
    private final int initial;
    private final int step;

    ArithmeticProgression(int initial, int step) throws ProgressionConfigurationException {
        this.initial = initial;
        if (step == 0)
            throw new ProgressionConfigurationException("Can't calculate progression!Enter step except 0!");
        else this.step = step;
    }

    int calculate(int n) throws ProgressionConfigurationException {
        int result = initial, count = 0;
        if (n <= 0)
            throw new ProgressionConfigurationException("You entered too small number, try n > 0!");
        else {
            while (count != n) {
                result = result + step;
                count++;
            }
        }
        return result;
    }

    public static void main(String[] args) throws ProgressionConfigurationException {
        try {
            ArithmeticProgression arithmeticProgression = new ArithmeticProgression(0, 7);
            arithmeticProgression.calculate(5);
        } catch (ProgressionConfigurationException prgexc) {
            prgexc.printStackTrace();
        }
    }

}
