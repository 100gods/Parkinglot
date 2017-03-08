/**
 * 
 */
package com.saurabh.parkinglot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 100gods
 * 
 */
public class ParkingLot {

	int MAX_SIZE = 0;

	private class Car {
		String regNo;
		String color;

		public Car(String regNo, String color) {
			this.regNo = regNo;
			this.color = color;
		}
	}

	// Available slots
	ArrayList<Integer> availableSlotList;
	// Map of Slot, Car
	Map<String, Car> slotCar;
	// Map of RegNo, Slot
	Map<String, String> RegSlot;
	// Map of Color, List of RegNo
	Map<String, ArrayList<String>> colorReg;

	public int getMAX_SIZE() {
		return MAX_SIZE;
	}

	public void setMAX_SIZE(int mAX_SIZE) {
		MAX_SIZE = mAX_SIZE;
	}
	

	public ArrayList<Integer> getAvailableSlotList() {
		return availableSlotList;
	}

	public void setAvailableSlotList(ArrayList<Integer> availableSlotList) {
		this.availableSlotList = availableSlotList;
	}

	public Map<String, Car> getSlotCar() {
		return slotCar;
	}

	public void setSlotCar(Map<String, Car> slotCar) {
		this.slotCar = slotCar;
	}

	public Map<String, String> getRegSlot() {
		return RegSlot;
	}

	public void setRegSlot(Map<String, String> regSlot) {
		RegSlot = regSlot;
	}

	public Map<String, ArrayList<String>> getColorReg() {
		return colorReg;
	}

	public void setColorReg(Map<String, ArrayList<String>> colorReg) {
		this.colorReg = colorReg;
	}

	/**
	 * @param slotCount
	 */
	public void createParkingLot(String slotCount) {
		try {
			this.MAX_SIZE = Integer.parseInt(slotCount);
		} catch (Exception exception) {
			System.out.println("Invalid lot count");
			System.out.println();
		}
		this.availableSlotList = new ArrayList<Integer>() {
		};
		for (int i = 1; i <= this.MAX_SIZE; i++) {
			availableSlotList.add(i);
		}
		this.slotCar = new HashMap<String, Car>();
		this.RegSlot = new HashMap<String, String>();
		this.colorReg = new HashMap<String, ArrayList<String>>();
		System.out.println("Created parking lot with " + slotCount + " slots");
		System.out.println();
	}

	/**
	 * @param regNo
	 * @param color
	 */
	public void park(String regNo, String color) {
		if (this.MAX_SIZE == 0) {
			System.out.println("Sorry, parking lot is not created");
			System.out
					.println("RUN COMMAND : create_parking_lot {NO OF SLOTS}");
			System.out.println();
		} else if (this.slotCar.size() == this.MAX_SIZE) {
			System.out.println("Sorry, parking lot is full");
			System.out.println();
		} else {
			Collections.sort(availableSlotList);
			String slot = availableSlotList.get(0).toString();
			Car car = new Car(regNo, color);
			this.slotCar.put(slot, car);
			this.RegSlot.put(regNo, slot);
			if (this.colorReg.containsKey(color)) {
				ArrayList<String> regNoList = this.colorReg.get(color);
				regNoList.add(regNo);
				this.colorReg.put(color, regNoList);
			} else {
				ArrayList<String> regNoList = new ArrayList<String>();
				regNoList.add(regNo);
				this.colorReg.put(color, regNoList);
			}
			System.out.println("Allocated slot number: " + slot);
			System.out.println();
			availableSlotList.remove(0);
		}
	}

	/**
	 * @param slotNo
	 */
	public void leave(String slotNo) {
		if (this.MAX_SIZE == 0) {
			System.out.println("Sorry, parking lot is not created");
			System.out.println();
		} else if (!this.slotCar.isEmpty()) {
			Car carToLeave = this.slotCar.get(slotNo);
			if (carToLeave != null) {
				this.slotCar.remove(slotNo);
				this.RegSlot.remove(carToLeave.regNo);
				ArrayList<String> regNoList = this.colorReg
						.get(carToLeave.color);
				if (regNoList.contains(carToLeave.regNo)) {
					regNoList.remove(carToLeave.regNo);
				}
				// Add the Lot No. back to available slot list.
				this.availableSlotList.add(Integer.parseInt(slotNo));
				System.out.println("Slot number " + slotNo + " is free");
				System.out.println();
			} else {
				System.out.println("Slot number " + slotNo
						+ " is already empty");
				System.out.println();
			}
		} else {
			System.out.println("Parking lot is empty");
			System.out.println();
		}
	}

	/**
     * 
     */
	public void status() {
		if (this.MAX_SIZE == 0) {
			System.out.println("Sorry, parking lot is not created");
			System.out.println();
		} else if (this.slotCar.size() > 0) {
			// Print the current status.
			System.out.println("Slot No.\tRegistration No.\tColor");
			Car car;
			for (int i = 1; i <= this.MAX_SIZE; i++) {
				String key = Integer.toString(i);
				if (this.slotCar.containsKey(key)) {
					car = this.slotCar.get(key);
					System.out.println(i + "\t" + car.regNo + "\t" + car.color);
				}
			}
			System.out.println();
		} else {
			System.out.println("Parking lot is empty");
			System.out.println();
		}
	}

	/**
	 * @param color
	 */
	public void getRegistrationNumbersFromColor(String color) {
		if (this.MAX_SIZE == 0) {
			System.out.println("Sorry, parking lot is not created");
			System.out.println();
		} else if (this.colorReg.containsKey(color)) {
			ArrayList<String> regNoList = this.colorReg.get(color);
			System.out.println();
			for (int i = 0; i < regNoList.size(); i++) {
				if (!(i == regNoList.size() - 1)) {
					System.out.print(regNoList.get(i) + ",");
				} else {
					System.out.print(regNoList.get(i));
				}
			}
		} else {
			System.out.println("Not found");
			System.out.println();
		}
	}

	/**
	 * @param color
	 */
	public void getSlotNumbersFromColor(String color) {
		if (this.MAX_SIZE == 0) {
			System.out.println("Sorry, parking lot is not created");
			System.out.println();
		} else if (this.colorReg.containsKey(color)) {
			ArrayList<String> regNoList = this.colorReg.get(color);
			ArrayList<Integer> slotList = new ArrayList<Integer>();
			System.out.println();
			for (int i = 0; i < regNoList.size(); i++) {
				slotList.add(Integer.valueOf(this.RegSlot.get(regNoList.get(i))));
			}
			Collections.sort(slotList);
			for (int j = 0; j < slotList.size(); j++) {
				if (!(j == slotList.size() - 1)) {
					System.out.print(slotList.get(j) + ",");
				} else {
					System.out.print(slotList.get(j));
				}
			}
			System.out.println();
		} else {
			System.out.println("Not found");
			System.out.println();
		}
	}

	/**
	 * @param regNo
	 */
	public void getSlotNumberFromRegNo(String regNo) {
		if (this.MAX_SIZE == 0) {
			System.out.println("Sorry, parking lot is not created");
			System.out.println();
		} else if (this.RegSlot.containsKey(regNo)) {
			System.out.println(this.RegSlot.get(regNo));
		} else {
			System.out.println("Not found");
			System.out.println();
		}
	}

}
