package com.basic.solid;


interface Discount {
    void apply();
}

class NoDiscount implements Discount {
    public void apply() {
        System.out.println("Discount Applied");
    }
}

class NewYearDiscount implements Discount {
    public void apply() {
        System.out.println("NewYear Discount");
    }
}
public class OpenClosed {
	
	public static void main(String[] args) {
		
		Discount discount = new NewYearDiscount(); 
		Discount d = new NoDiscount();
		
		discount.apply();
		d.apply();
}
}
