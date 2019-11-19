/**
 * 
 */
package com.saurabh.parkinglot.parkinglot;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.saurabh.parkinglot.Entry;

/**
 * @author 100gods
 * 
 */
public class TestEntry {
	Entry entry = new Entry();
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

	@Test @Ignore
	public void FileTest() {
		String[] args = {this.getClass().getResource( "/parking_input.txt" ).getPath() };
		entry.main(args);
		String output = "Created a parking lot with 6 slots\n\nAllocated slot number: 1\n\nAllocated slot number: 2\n\nAllocated slot number: 3\n\nAllocated slot number: 4\n\nAllocated slot number: 5\n\nAllocated slot number: 6\n\nSlot number 4 is free\n\nSlot No. Registration No. Colour\n\n1 KA-01-HH-1234 White\n\n2 KA-01-HH-9999 White\n\n3 KA-01-BB-0001 Black\n\n5 KA-01-HH-2701 Blue\n\n6 KA-01-HH-3141 Black\n\nAllocated slot number: 4\n\nSorry, parking lot is full\n\nKA-01-HH-1234, KA-01-HH-9999, KA-01-P-333\n\n1, 2, 4\n\n6\n\n Not found";
		output.replaceAll("\\s+", "").replaceAll("\n+", "");
		
		assertTrue(output.replaceAll("\\s+", "").replaceAll("\\n+", "").equalsIgnoreCase(
				outContent.toString().trim().replaceAll("\\s+", "").replaceAll("\\n+", "")));
	}

}
