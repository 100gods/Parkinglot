package com.saurabh.parkinglot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
				}else if (query.isEmpty()) {
					continue;
				}
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

		default:
			System.out.println("Usage: java -jar <jar_file_path> <input_file_path> or java -jar <jar_file_path>");
			break;
		}
		

	}

}
