package com.java8Features.assignment;

//Define a functional interface with a single abstract method
@FunctionalInterface
interface MessagePrinter {
 void print(String message);
}

public class GreetingsPrinter {

 // Method that takes a MessagePrinter and a message
 public static void sendMessage(String msg, MessagePrinter printer) {
     printer.print(msg);
 }

 public static void main(String[] args) {
     // Pass a lambda expression that prints the message
     sendMessage("Hello from functional interface!", message -> System.out.println(message));
 }
}
