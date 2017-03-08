/**
 * 
 */
package com.saurabh.parkinglot.factory;

import java.util.HashMap;
import java.util.Map;

import com.saurabh.parkinglot.command.CreateLot;
import com.saurabh.parkinglot.command.Leave;
import com.saurabh.parkinglot.command.Park;
import com.saurabh.parkinglot.command.RegistrationNumbersFromColor;
import com.saurabh.parkinglot.command.SlotNumbersFromColor;
import com.saurabh.parkinglot.command.Status;
import com.saurabh.query.Query;

/**
 * @author 100gods
 *
 */
public class CommandFactory {
	public static Map<Query, String> featureMap;
	static{
		featureMap=new HashMap<Query, String>();
	}
	public CommandFactory() {
		registerFeature();
	}
	private void registerFeature(){
		featureMap.put(Query.create_parking_lot, CreateLot.class.getCanonicalName());
		featureMap.put(Query.park, Park.class.getCanonicalName());
		featureMap.put(Query.leave, Leave.class.getCanonicalName());
		featureMap.put(Query.status, Status.class.getCanonicalName());
		featureMap.put(Query.registration_numbers_for_cars_with_colour, RegistrationNumbersFromColor.class.getCanonicalName());
		featureMap.put(Query.slot_numbers_for_cars_with_colour, SlotNumbersFromColor.class.getCanonicalName());
	}
	

}
