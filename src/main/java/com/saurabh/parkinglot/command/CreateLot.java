/**
 * 
 */
package com.saurabh.parkinglot.command;

import com.saurabh.parkinglot.ParkingLot;

/**
 * @author 100gods
 *
 */
public class CreateLot implements Command {
	ParkingLot parkingLot;
	public CreateLot(ParkingLot parkingLot) {
		this.parkingLot=parkingLot;
		
	}

	/* (non-Javadoc)
	 * @see com.saurabh.parkinglot.command.Command#execute(com.saurabh.parkinglot.ParkingLot, java.lang.String)
	 */
	public void execute(String query) {
		parkingLot.createParkingLot(query);   
		
	}

}
