/**
 * 
 */
package com.saurabh.parkinglot.command;

import com.saurabh.parkinglot.ParkingLot;
import com.saurabh.parkinglot.factory.CommandFactory;
import com.saurabh.query.Query;

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
