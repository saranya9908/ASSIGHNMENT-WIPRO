package com.sk.assignment;

import java.util.Scanner;

public class AverageConfusion {

	public static void main(String[] args) {
		
		
		        Scanner sc = new Scanner(System.in);
		        int[] numbers = new int[5];
		        int sum = 0;

		        System.out.println("Enter 5 numbers:");

		        for (int i = 0; i < 5; i++) {
		            numbers[i] = sc.nextInt();

		            if (numbers[i] < 10) {
		                numbers[i] *= 2; 
		            }

		            sum += numbers[i];
		        }

		        double average = sum / 5.0;

		        System.out.println("Average is : " + average);
		    }
		


	}


