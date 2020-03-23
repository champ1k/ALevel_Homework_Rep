package com.alvl.nix.homework.lesson15.homework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public abstract class Retry<T> implements Block<T> {

    private static final Logger log = LoggerFactory.getLogger(Retry.class);

    private final int times;

    private final Block<T> block;

    public static <T> RetryBuilder<T> builder(Block<T> block) {
        return new RetryBuilder<>(block);
    }

    Retry(int times, Block<T> block) {
        this.times = times;
        this.block = block;
    }

    @Override
    public T run() throws Exception {
        int attempt = 1;
        Exception failure;

        do {
            try {
                return block.run();
            } catch (Exception e) {
                log.warn("Attempt {} failed", attempt, e);
                failure = e;
            }

            try {
                backoff(attempt);
            } catch (InterruptedException e) {
                log.warn("Backoff interrupted, proceeding to retry", e);
            }
        } while (++attempt <= times);

        log.error("Failed to execute the block after {} attempts", attempt, failure);
        throw failure;
    }

    abstract void backoff(int attempt) throws InterruptedException;

    public static final class RetryBuilder<T> {

        private final Block<T> block;

        private int times = 1;

        private long initialDelay = 0;

        private RetryBuilder(Block<T> block) {
            this.block = Objects.requireNonNull(block);
        }

        public RetryBuilder<T> times(int times) {
            if (times < 1) {
                throw new IllegalArgumentException("Should retry at least 1 time, got " + times);
            }
            this.times = times;
            return this;
        }

        public RetryBuilder<T> initialDelay(long initialDelay) {
            if (initialDelay < 0) {
                throw new IllegalArgumentException("Can't pause for negative amount of time, got " + initialDelay);
            }
            this.initialDelay = initialDelay;
            return this;
        }



    }
}
