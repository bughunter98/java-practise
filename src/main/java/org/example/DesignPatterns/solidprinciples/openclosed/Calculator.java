package org.example.DesignPatterns.solidprinciples.openclosed;

// No modifications in our calculator functionality
// We can keep adding extension by create new operations


/*
* What it means: Software entities (like classes, modules, and functions) should be open for extension but closed for modification.
Beginner overview: You should be able to add new functionality without changing the existing, working code.
* Think of it like a software that’s designed with plugins.
* You can add a new plugin to extend its features without having to rewrite the core program itself. */
public class Calculator {
    public int calculateNumber(int number1 , int number2 , Operation operation){
        return  operation.perform(number1 , number2);
    }
}
