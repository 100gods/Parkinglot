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

  

}
