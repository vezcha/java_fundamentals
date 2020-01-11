package com.brandon.java8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class DateAPI {

	public static void main(String[] args) {
		// Java 7 uses java.util.Date for all date operations
		// This Date class from java 7 is flawed because it's mutable
		// allows code to reset value from outside the object. ex: d.setTime(0L)

		Date date = new Date(); //Gets the current Date
		
		Calendar cal = Calendar.getInstance(); //gets calendar for now
		
		cal.set(2014, 1, 10); //sets calendar for feb 10th (0 is jan)
		Date feb10th = cal.getTime();

		cal.add(Calendar.DAY_OF_MONTH, 7); //add 7 days to calendar object
		Date oneWeeklater = cal.getTime();
		
		//Solution to project date is to use a 'defensive copy' pattern
		// this solves the problem but adds overhead to the class
		// ideal solution would be to have an immutable date class
		/*
		 * public class Customer{
		 * 	private Date creationDate;
		 * 
		 * 	public Date getCreationDate() {
		 *		return new Date(this.creationDate.getTime()); instead of
		 *		return this.creationDate.getTime();
		 * 	}
		 * }
		 */
		
		//Java 8 introduces instants which are immutable
		//only used for high precision duration finding
		
		Instant start = Instant.now();
		
		for(int i=0;i<9999999;i++) {
			for(int j=0; j<9999999;j++) {
				int x = i+1/2*5;
			}
		}
		Instant end = Instant.now();
		
		Duration elapsed = Duration.between(start, end);
		
		long millis = elapsed.toMillis(); //toNanos(), toSeconds(), toMinutes(), toHours(), to Days()
		System.out.println(millis); //plusNanos(), minusNanos()
		
		/*
		 * Java 8 - LocalDate used to find days without high precision
		 * a Period is amount of time between two local dates
		 */
		LocalDate now = LocalDate.now();
		LocalDate dateOfBirth = LocalDate.of(1564, Month.APRIL, 23);
		
		Period p = dateOfBirth.until(now);
		System.out.println("# years = " + p.getYears());
		
		long days = dateOfBirth.until(now,ChronoUnit.DAYS);
		System.out.println("# days = " + days);
		
		/*
		 * Example reading from a file
		 */
		
		List<LocalDate> list = new ArrayList<>();
		
		//try-catch-finally with resources
		
		try (BufferedReader reader = new BufferedReader( // try with resource block
				new InputStreamReader(
						DateAPI.class.getResourceAsStream("people.txt")));
			Stream<String> stream = reader.lines();
				
		){ //logic block
			stream.forEach(
				line -> {
					String[] s = line.split(" "); //s[0]-Name s[1]-Year s[2]-Month s[3]-Day
					int year = Integer.parseInt(s[1]);
					int month = Integer.parseInt(s[2]);
					int day = Integer.parseInt(s[3]);
					list.add(LocalDate.of(year, month, day));
				}
			);
			

			
		}catch(Exception e){ //catch block
			
		}finally{ //finally block
			
		}
		
		list.forEach(System.out::println);
		
		LocalDate compareDate = LocalDate.of(1991, 2, 12);
		
		list.stream()
			.forEach( d -> {
				System.out.println(compareDate.until(d).getYears());
			});
		
		/*
		 * TemporalAdjuster example
		 * firstDayOfMonth(), lastDayOfMonth(), dayOfWeekInMonth()
		 */
		
		/*
		 * LocalTime example
		 */
		LocalTime nowLT = LocalTime.now();
		LocalTime time = LocalTime.of(10, 20);
		
		/*
		 * Zoned Time example
		 */
		Set<String> allZonesIds = ZoneId.getAvailableZoneIds();
		ZoneId ukTZ = ZoneId.of("Europe/London");
		
		
		
		
	}

}
