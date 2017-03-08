/**
 * 
 */
package com.saurabh.parkinglot.command;

import com.saurabh.parkinglot.ParkingLot;

/**
 * @author 100gods
 *
 */
public class Park implements Command {
	ParkingLot parkingLot;
	public Park(ParkingLot parkingLot) {
		this.parkingLot=parkingLot;
	}

	/* (non-Javadoc)
	 * @see com.saurabh.parkinglot.command.Command#execute(java.lang.String)
	 */
	public void execute(String query) {
		String[] parts=query.split(" ");
		parkingLot.park(parts[1], parts[2]);

	}

}
