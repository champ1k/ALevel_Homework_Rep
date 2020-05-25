package com.alvl.nix.homework.lesson33;

import java.util.Random;

public class Horse implements Runnable {
    private String name;

    private RaceTrack raceTrack;

    private int position;

    private Random random;

    private int minMove = 100;

    private int maxMove = 200;

    private int minSleep = 400;

    private int maxSleep = 500;

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    Horse(String name, RaceTrack raceTrack) {
        this.name = name;
        this.raceTrack = raceTrack;
        random = new Random();
        position = 0;
    }

    private void pitStop() {
        int sleepTime = random.nextInt((maxSleep - minSleep + 1) + minSleep);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void horseRun() {
        int move = random.nextInt((maxMove - minMove + 1) + minMove);
        position += move;
    }

    @Override
    public void run() {
        raceTrack.getPhaser().arriveAndAwaitAdvance();
        int distance = raceTrack.getDistance();
        while (position < distance) {
            horseRun();
            pitStop();
        }
        int place = raceTrack.getPlaceCounter().getAndIncrement();
        raceTrack.getFinished().put(this, place);
        raceTrack.getPhaser().arriveAndDeregister();
    }


    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name +
                '}';
    }
}

