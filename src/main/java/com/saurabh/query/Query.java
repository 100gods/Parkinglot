/**
 * 
 */
package com.saurabh.query;

/**
 * @author 100gods
 *
 */
public enum Query {
	create_parking_lot("create_parking_lot"),
	 park("park"),
	 leave("leave") ,
	 status("status") ,
	 registration_numbers_for_cars_with_colour("registration_numbers_for_cars_with_colour") ,
	 slot_numbers_for_cars_with_colour ("slot_numbers_for_cars_with_colour"),
	 slot_number_for_registration_number("slot_number_for_registration_number") ;
	String query;
	private Query(String query) {
		this.query=query;
	}
	@Override
	public String toString(){
		return query.toString();
	}

}
