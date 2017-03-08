/**
 * 
 */
package com.saurabh.parkinglot.parkinglot;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.saurabh.parkinglot.ParkingLot;
/**
 * @author 100gods
 *
 */
public class TestParkingLot {
	ParkingLot parkingLot = new ParkingLot();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }
    @Test
    public void createParkingLot() throws Exception {
        parkingLot.createParkingLot("10");
        assertEquals(10, parkingLot.getMAX_SIZE());
        assertEquals(10, parkingLot.getAvailableSlotList().size());
        assertTrue("Created parking lot with 10 slots".equalsIgnoreCase(outContent.toString().trim()));
    }
    
    @Test
    public void park(){
    	parkingLot.createParkingLot("10");
    	parkingLot.park("KA-01-HH-1234", "White");
    	assertEquals(1, parkingLot.getSlotCar().size());
    	assertTrue("Created parking lot with 10 slots\nAllocated slot number: 1".replaceAll("\\s+", "").equalsIgnoreCase(outContent.toString().trim().replaceAll("\\s+", "")));
    }
    
    @Test
    public void leave(){
    	parkingLot.createParkingLot("10");
    	parkingLot.park("KA-01-HH-1234", "White");
    	assertEquals(1, parkingLot.getSlotCar().size());
    	assertEquals(9, parkingLot.getAvailableSlotList().size());
    	assertTrue("Created parking lot with 10 slots\nAllocated slot number: 1".replaceAll("\\s+", "").equalsIgnoreCase(outContent.toString().trim().replaceAll("\\s+", "")));
    	parkingLot.leave("1");
    	assertEquals(0, parkingLot.getSlotCar().size());
    	assertTrue("Created parking lot with 10 slots\nAllocated slot number: 1\nSlot number 1 is free".replaceAll("\\s+", "").equalsIgnoreCase(outContent.toString().trim().replaceAll("\\s+", "")));
    	assertEquals(10, parkingLot.getAvailableSlotList().size());
    }
    
    @Test
    public void status(){
    	parkingLot.createParkingLot("10");
    	parkingLot.park("KA-01-HH-1234", "White");
    	parkingLot.park("KA-01-HH-0234", "White");
    	assertEquals(2, parkingLot.getSlotCar().size());
    	assertEquals(8, parkingLot.getAvailableSlotList().size());
//    	assertTrue("Created parking lot with 10 slots\nAllocated slot number: 1".replaceAll("\\s+", "").equalsIgnoreCase(outContent.toString().trim().replaceAll("\\s+", "")));
    	parkingLot.leave("1");
    	assertEquals(1, parkingLot.getSlotCar().size());
//    	assertTrue("Created parking lot with 10 slots\nAllocated slot number: 1\nSlot number 1 is free".replaceAll("\\s+", "").equalsIgnoreCase(outContent.toString().trim().replaceAll("\\s+", "")));
    	assertEquals(9, parkingLot.getAvailableSlotList().size());
    	outContent.reset();
    	parkingLot.status();
    	assertTrue("Slot No. Registration No. Colour\n2 KA-01-HH-0234 White".replaceAll("\\s+", "").equalsIgnoreCase(outContent.toString().trim().replaceAll("\\s+", "")));
    	
    }
    @Test
    public void getRegistrationNumbersFromColor(){
    	parkingLot.createParkingLot("10");
    	parkingLot.park("KA-01-HH-1234", "White");
    	parkingLot.park("KA-01-HH-0234", "White");
    	outContent.reset();
    	parkingLot.getRegistrationNumbersFromColor("White");
    	assertTrue("KA-01-HH-1234,KA-01-HH-0234".replaceAll("\\s+", "").equalsIgnoreCase(outContent.toString().trim().replaceAll("\\s+", "")));
    	
    }
    @Test
    public void getSlotNumbersFromColor(){
    	parkingLot.createParkingLot("10");
    	parkingLot.park("KA-01-HH-1234", "White");
    	parkingLot.park("KA-01-HH-0234", "White");
    	outContent.reset();
    	parkingLot.getSlotNumbersFromColor("White");
    	assertTrue("1,2".replaceAll("\\s+", "").equalsIgnoreCase(outContent.toString().trim().replaceAll("\\s+", "")));
    	
    }

  

}
