package com.java_8_training.problems.defaultmethods;

public interface SimpleNumberOp {

    public int getValue();

    static int add(SimpleNumberOp a, SimpleNumberOp b) {
        return a.getValue() + b.getValue();
    }

    default void getValueAsDouble() {
        throw new UnsupportedOperationException();
    }
}
