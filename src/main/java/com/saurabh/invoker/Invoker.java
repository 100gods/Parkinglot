/**
 * 
 */
package com.saurabh.invoker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.saurabh.parkinglot.ParkingLot;
import com.saurabh.parkinglot.factory.CommandFactory;
import com.saurabh.query.Query;

/**
 * @author 100gods
 * 
 */
public class Invoker {
	private CommandFactory commandFactory;

	public Invoker() {
		commandFactory = new CommandFactory();
	}

	public void execute(ParkingLot parkingLot,String query) {
		String[] parts = query.split(" ");
		switch (parts.length) {
		case 1:

			break;
		case 2:
			Class<?> command;
			Object commandObj;
			Method method;
			try {
				command = Class.forName(CommandFactory.featureMap.get(Query.valueOf(parts[0])));
				commandObj=command.getConstructor(ParkingLot.class).newInstance(parkingLot);
				method=command.getMethod("execute",String.class);
				method.invoke(commandObj,parts[1]);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			break;

		default:
			break;
		}

	}

}
