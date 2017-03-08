/**
 * 
 */
package com.saurabh.parkinglot.command;

import com.saurabh.parkinglot.ParkingLot;

/**
 * @author 100gods
 *
 */
public class RegistrationNumbersFromColor implements Command {
	ParkingLot parkingLot;
	public RegistrationNumbersFromColor(ParkingLot parkingLot) {
		this.parkingLot=parkingLot;
	}
	/* (non-Javadoc)
	 * @see com.saurabh.parkinglot.command.Command#execute(java.lang.String)
	 */
	public void execute(String query) {
		parkingLot.getRegistrationNumbersFromColor(query);

	}

}
