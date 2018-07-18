package com.uequations.common.random.model;

public class RandomOptions {

    private final int length;

    private RandomOptions(int length) {
        this.length = length;
    }

    public static RandomOptions getInstance(int length) {
        return new RandomOptions(length);
    }

    public int getLength() {
        return length;
    }
}
