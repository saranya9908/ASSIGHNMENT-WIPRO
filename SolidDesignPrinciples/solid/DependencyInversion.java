package com.basic.solid;


interface Keyboard {
    void type();
}

class LaptopKeyboard implements Keyboard {
    public void type() {
        System.out.println("Typing with laptop keyboard");
    }
}

class Computer {
    private final Keyboard keyboard;

    public Computer(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    void use() {
        keyboard.type();
    }
}
public class DependencyInversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Keyboard myKeyboard = new LaptopKeyboard();
        Computer computer = new Computer(myKeyboard);
        computer.use();

	}

}
