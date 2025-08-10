package com.basic.solid;

interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

class SimplePrinter implements Printer {
    public void print() {
        System.out.println("Printing document...");
    }
}

public class InterfaceSegrigation {
	
	public static void main(String[] args) {
	
		Printer myPrinter = new SimplePrinter();
		myPrinter.print();
	}
}
