package com.ssa.battingaverage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BattingAverage {

	static Scanner scan = new Scanner(System.in);
	static Scanner sc = new Scanner(System.in);

	private int sin, doub, trip, home, hits, atbat, bases;

	private double average;
	private double slugging;
	static boolean anotherBatter = true;
	
	public static void main(String[] args) {
		
		
		while (anotherBatter){

		BattingAverage player = new BattingAverage();
		String name = null;
		System.out.println("Hello batter. What is your name?");
		name = sc.nextLine();
		player.getStats(name);
		player.calcAvg();
		player.calcSlug();
		player.printAll(name);
		System.out.println("");
		System.out.println("Would you like to enter another batter?\n" + "Y: Yes\n" + "N: No");
		String newBatter = sc.nextLine();
		playAgain(newBatter);
		}
	}
	
	public static boolean playAgain(String newBatter){
		switch (newBatter.toLowerCase()) {
		case "n":
			no();
			break;

		case "y":
			yes();
			break;
		default:
			System.out.println("That is not a valid entry!");
			main(null);
		
		}
		return anotherBatter;
	}
	

	private static boolean yes() {
			System.out.println("Great!");
			return anotherBatter;
			
		}

	private static boolean no() {
			System.out.println("Thanks for playing!");
			anotherBatter = false;
			return anotherBatter;
			
		}

	public void getStats(String name) {
	try {
		
			System.out.print("Times at bat: ");
			atbat = scan.nextInt();
		if (atbat < 0) {
			System.out.println("Please enter a valid digit.");
			main(null);
		}
			System.out.print("Single hits: ");
			sin = scan.nextInt();
			if (sin < 0) {
			System.out.println("Please enter a valid digit");
			main(null);
		}
		
			System.out.print("Double hits: ");
			doub = scan.nextInt();
		if (doub < 0) {
			System.out.println("Please enter a valid digit");
			main(null);
		}
			System.out.print("Triple hits: ");
			trip = scan.nextInt();
		if (trip < 0) {
			System.out.println("Please enter a valid digit");
			main(null);
		}
			System.out.print("Homeruns: \n");
			home = scan.nextInt();
		if (home < 0) {
			System.out.println("Please enter a valid digit");
			main(null);
		}
	}catch (InputMismatchException e) {
			System.out.println("That is not a valid entry. Please start again.");
			System.exit(0);
		}	
		System.out.println("");

	}

	public double calcSlug() {
		bases = sin + (doub * 2) + (trip * 3) + (home * 4);
		slugging = ((double) bases / (double) atbat);
		return slugging;
	}

	public double calcAvg() {

		hits = sin + doub + trip + home;

		average = ((double) hits / (double) atbat);
		if (hits > atbat) {
			System.out.println("Not possible, Stop cheating");
			System.exit(0);
		}
		return average;
	}

	public void printAll(String name) {

		System.out.println("Player statistics for " + name + ":");

		System.out.println("Single hits: " + sin);

		System.out.println("Double hits: " + doub);

		System.out.println("Triple hits: " + trip);

		System.out.println("Homerun: " + home);

		System.out.println("");

		System.out.println("Times at bat: " + atbat);

		System.out.println("Total hits: " + hits);

		System.out.println("");

		System.out.printf(name + "'s" + " Batting average: %.3f", average);

		System.out.println("");

		System.out.printf(name + "'s" + " Slugging average: %.3f \n", slugging);
		
		

	}

}
