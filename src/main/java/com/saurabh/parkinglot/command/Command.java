/**
 * 
 */
package com.saurabh.parkinglot.command;

import com.saurabh.parkinglot.ParkingLot;


/**
 * @author 100gods
 *
 */
public interface Command {
	
	/**
	 * @param parkingLot
	 * @param query
	 */
	public void execute(String query);
}
