package com.basic.solid;


class Bird {
    void makeSound() {
    	System.out.println("Parent Class-Bird");
	}
}

class Sparrow extends Bird {
    public void makeSound() {
        System.out.println("Sparrow chirping");
    }
}
public class LiskovSub {
	public static void main(String[] args) {
	
		
		Bird bird = new Sparrow(); 
		bird.makeSound();
	}

}
