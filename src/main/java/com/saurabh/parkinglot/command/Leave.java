/**
 * 
 */
package com.saurabh.parkinglot.command;

import com.saurabh.parkinglot.ParkingLot;

/**
 * @author 100gods
 *
 */
public class Leave implements Command {
	ParkingLot parkingLot;
	public Leave(ParkingLot parkingLot) {
		this.parkingLot=parkingLot;
	}
	/* (non-Javadoc)
	 * @see com.saurabh.parkinglot.command.Command#execute(java.lang.String)
	 */
	public void execute(String query) {
		parkingLot.leave(query);

	}

}
