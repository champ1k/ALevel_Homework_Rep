package com.alvl.nix.homework.lesson33;


import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicInteger;

final class RaceTrack {

    private int distance;

    private Set<Horse> horseRacing;

    private AtomicInteger hoursePlace;

    private Phaser phaser;

    private Map<Horse, Integer> finished;

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Map<Horse, Integer> getFinished() {
        return finished;
    }

    public void setFinished(Map<Horse, Integer> finished) {
        this.finished = finished;
    }

    public Set<Horse> getHorseRacing() {
        return horseRacing;
    }

    public void setHorseRacing(Set<Horse> horseRacing) {
        this.horseRacing = horseRacing;
    }

    public Phaser getPhaser() {
        return phaser;
    }

    public void setPhaser(Phaser phaser) {
        this.phaser = phaser;
    }

    public AtomicInteger getPlaceCounter() {
        return hoursePlace;
    }

    public void setPlaceCounter(AtomicInteger placeCounter) {
        this.hoursePlace = placeCounter;
    }

    RaceTrack(int distance) {
        this.distance = distance;
        finished = new ConcurrentHashMap<>();
        horseRacing = ConcurrentHashMap.newKeySet();
        hoursePlace = new AtomicInteger();
        phaser = new Phaser();
    }

    int getDistance() {
        return distance;
    }

    int getPlace(Horse horse) {
        return finished.get(horse);
    }

    void addHorce(Horse horse) {
        horseRacing.add(horse);
    }

    synchronized void startRace() {
        hoursePlace.set(1);
        finished.clear();
        int numberOfHorses = horseRacing.size();
        phaser.bulkRegister(numberOfHorses);
        int start = phaser.getPhase();
        System.out.println("Run starts!");
        for (Horse horse : horseRacing) {
            new Thread(horse, horse.getName() + " Thread").start();
        }
        int finish = phaser.awaitAdvance(start);
        phaser.awaitAdvance(finish);
        System.out.println("Run ends!");
    }
}