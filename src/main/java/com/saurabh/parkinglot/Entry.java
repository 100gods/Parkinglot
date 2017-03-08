package com.saurabh.parkinglot;

import java.util.Scanner;

import com.saurabh.invoker.Invoker;

public class Entry {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Invoker invoker=new Invoker();
		ParkingLot parkingLot=new ParkingLot();
		switch (args.length) {
		case 0:
//			run interactive command line 
			System.out.println("Enter \"bye\" to exit ");
			while(true){
				Scanner  scanner= new Scanner(System.in);
				String query=scanner.nextLine().trim();
				if (query.equalsIgnoreCase("bye") ||query.equalsIgnoreCase("\"bye\"")  ) {
					break;
				}
				invoker.execute(parkingLot,query);
				
			}
			
			break;

		default:
			break;
		}
		

	}

}
