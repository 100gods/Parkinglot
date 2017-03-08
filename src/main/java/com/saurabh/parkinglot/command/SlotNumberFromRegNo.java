/**
 * 
 */
package com.saurabh.parkinglot.command;

import com.saurabh.parkinglot.ParkingLot;

/**
 * @author 100gods
 *
 */
public class SlotNumberFromRegNo implements Command {
ParkingLot parkingLot;
public SlotNumberFromRegNo(ParkingLot parkingLot) {
	this.parkingLot=parkingLot;
}
	/* (non-Javadoc)
	 * @see com.saurabh.parkinglot.command.Command#execute(java.lang.String)
	 */
	public void execute(String query) {
		parkingLot.getSlotNumberFromRegNo(query);

	}

}
