package com.alvl.nix.homework.lesson33;

import java.util.Scanner;

public class Hippodrome {
    private static final int RACE_LENGTH = 1000;

    public static void main(String[] args) {

        RaceTrack race = new RaceTrack(RACE_LENGTH);

        Horse[] horses = {
                new Horse("First", race),
                new Horse("Second", race),
                new Horse("Third", race),
                new Horse("Fourth", race),
                new Horse("Fifth", race),
                new Horse("Sixth", race),
                new Horse("Seventh", race),
                new Horse("Eighth", race)
        };

        for (Horse horse : horses) {
            race.addHorce(horse);
        }

        Scanner scanner = new Scanner(System.in);

        int horsesCount = horses.length;

        int horseNumber;

        System.out.println("Choose your horse:");
        for (int i = 0; i < horsesCount; i++) {
            System.out.println(horses[i]);
        }

        while ((horseNumber = scanner.nextInt()) > horsesCount || horseNumber <= 0) {
            System.out.println("WRONG CHOSE! Try again!");
        }

        Horse chosenHorse = horses[horseNumber - 1];
        System.out.println("Your horse - " + chosenHorse);

        race.startRace();

        int yourHorsePlace = race.getPlace(chosenHorse);
        System.out.println("Your horse get " + yourHorsePlace);

    }
}