/**
 * 
 */
package com.saurabh.parkinglot.command;

import com.saurabh.parkinglot.ParkingLot;

/**
 * @author 100gods
 *
 */
public class SlotNumbersFromColor implements Command {
	ParkingLot parkingLot;
	public SlotNumbersFromColor(ParkingLot parkingLot) {
		this.parkingLot=parkingLot;
	}
	/* (non-Javadoc)
	 * @see com.saurabh.parkinglot.command.Command#execute(java.lang.String)
	 */
	public void execute(String query) {
		parkingLot.getSlotNumbersFromColor(query);

	}

}
