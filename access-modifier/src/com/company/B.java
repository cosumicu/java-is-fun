package com.company;

public interface B {

    void call();
    default void message() {
        System.out.println("Interface B");
    }
}