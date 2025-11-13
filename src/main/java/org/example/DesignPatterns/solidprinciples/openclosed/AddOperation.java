package org.example.DesignPatterns.solidprinciples.openclosed;

public class AddOperation implements Operation {

    public int perform(int number1, int number2) {
        return number1 + number2;
    }
}
