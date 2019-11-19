package com.saurabh.parkinglot;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.saurabh.facade.IStrategy;
import com.saurabh.facade.StrategyImpl;
import com.saurabh.invoker.Invoker;
import com.saurabh.query.Strategy;

public class Entry {
	
	public static List<ParkingLot> parkingLots=new ArrayList<ParkingLot>();
	static Strategy currentStard=Strategy.one;
	public static Strategy getCurrentStard() {
		return currentStard;
	}
	public static void setCurrentStard(Strategy currentStard) {
		Entry.currentStard = currentStard;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		IStrategy strategy=new StrategyImpl();
		Invoker invoker=new Invoker();
		ParkingLot parkingLot;
		switch (args.length) {
		case 0:
//			run interactive command line 
			System.out.println("Enter \"bye\" to exit ");
			while(true){
				Scanner  scanner= new Scanner(System.in);
				String query=scanner.nextLine().trim();
				if (query.equalsIgnoreCase("bye") ||query.equalsIgnoreCase("\"bye\"")  ) {
					break;
				}else if (query.isEmpty()) {
					continue;
				}
				parkingLot=currentStard.equals(Strategy.one)?strategy.stardOne(query):strategy.stardTwo(query);
				invoker.execute(parkingLot,query);
				
			}
			
			break;
		case 1:
			File inputFile = new File(args[0]);
	        try {
	            BufferedReader br = new BufferedReader(new FileReader(inputFile));
	            String query;
	            try {
	                while ((query = br.readLine()) != null) {
	                	parkingLot=currentStard.equals(Strategy.one)?strategy.stardOne(query):strategy.stardTwo(query);
	                	invoker.execute(parkingLot,query);
	                }
	            } catch (IOException ex) {
	                System.out.println("Error in reading the input file.");
	                ex.printStackTrace();
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("File not found");
	            e.printStackTrace();
	        }
	        break;

		default:
			System.out.println("Usage: java -jar <jar_file_path> <input_file_path> or java -jar <jar_file_path>");
			break;
		}
		

	}

}
