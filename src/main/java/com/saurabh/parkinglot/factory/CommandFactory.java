/**
 * 
 */
package com.saurabh.parkinglot.factory;

import java.util.HashMap;
import java.util.Map;

import com.saurabh.parkinglot.command.CreateLot;
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
	}
	

}
