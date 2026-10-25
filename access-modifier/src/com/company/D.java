package com.company;

interface D {
    default void message() {
        System.out.println("Interface D");
    }
}
