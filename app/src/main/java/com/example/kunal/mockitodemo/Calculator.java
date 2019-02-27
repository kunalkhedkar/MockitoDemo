package com.example.kunal.mockitodemo;

public class Calculator {

    public int add(int num1, int num2) {
        return num1 + num2;
    }

    public int div(int num1, int num2) {
        return num1 / num2;
    }

    public void clear() {
        clearMemory();
    }

    public void clearMemory() {
        // clear memory
    }

    public int multi(Object num1, Object num2) {
        return (((Integer) num1) * ((Integer) num2));
    }
}
