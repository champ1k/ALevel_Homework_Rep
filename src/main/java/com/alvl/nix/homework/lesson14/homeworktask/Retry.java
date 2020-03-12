package com.alvl.nix.homework.lesson14.homeworktask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class Retry implements Block {

    private static final Logger log = LoggerFactory.getLogger(Retry.class);

    private int countTimes;

    private int couter;

    private Block block;

    private long waitingTime = 100;


    Retry(int countTimes, Block block) {
        this.countTimes = countTimes;
        this.block = block;
    }

    @Override
    public void run() throws Exception {
        while (countTimes != couter) {
            try {
                block.run();
                couter++;
                return;
            } catch (InterruptedException e) {
                log.error("Trying to retry!", e);
            }
            Thread.sleep(waitingTime * couter);
        }
        log.error("No more tries!", new Exception());
    }

    public static void main(String[] args) throws Exception {
        Block block = () -> {
        };

        Retry r = new Retry(10, block);
        r.run();
    }
}
