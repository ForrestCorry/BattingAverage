package com.ssa.battingaverage;

import java.util.Scanner;

public class BattingAverage {
	
    Scanner scan = new Scanner(System.in);

    private int sin, doub, trip, home, hits, atbat, bases;

	private double average;
	private double slugging;
	
	public static void main(String[] args) {
		BattingAverage player = new BattingAverage();
		String name = null;
		player.getStats(name);
		player.calcAvg();
		player.calcSlug();
		player.printAll(name);
	}



	public void getStats(String name){

    System.out.print("Times at bat: ");

    atbat = scan.nextInt();

    System.out.print("Single hits: ");

	sin= scan.nextInt();

    System.out.print("Double hits: ");

    doub = scan.nextInt();

    System.out.print("Triple hits: ");

    trip = scan.nextInt();

    System.out.print("Homeruns: ");

    home = scan.nextInt();

	}
	
	public double calcSlug(){
		bases = sin + (doub*2) + (trip*3) + (home*4);
		slugging = ((double)bases/(double)atbat);
		return slugging;
	}

	public double calcAvg(){

    hits = sin + doub + trip + home;

    average = ((double)hits/(double)atbat);
    if (hits>atbat) {
		System.out.println("Not possible, Stop cheating");
		System.exit(0);
	}
    return average;
	}
	
	

	public void printAll(String name){

    System.out.println("Player statistics for " + name + ":");

    System.out.println("Single hits: " + sin);

    System.out.println("Double hits: " + doub);

    System.out.println("Triple hits: " + trip);

    System.out.println("Homerun: " + home);
    
    System.out.println("");

    System.out.println("Times at bat: " + atbat);

    System.out.println("Total hits: " + hits);
    
    System.out.println("");

    System.out.printf("\tBaseball average: %.3f" , average);
    
    System.out.println("");
    
   System.out.printf("\tBaseball slugging: %.3f" , slugging);

	}

}

