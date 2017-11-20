package ziegler0.edu.hm.timekeepingmobileclient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.joda.time.LocalDate;


public class Assignment {

	private int id;

	private String work;

	private double hours;
    
	@JsonFormat
	private LocalDate date;

	private String username;
	
	@JsonCreator
	public Assignment(
			@JsonProperty("id") int id, 
			@JsonProperty("date") LocalDate date,
			@JsonProperty("work") String work, 
			@JsonProperty("hours") double hours,
			@JsonProperty("username") String username
		) {
		this.id = id;
		this.date = date;
		this.work = work;
		this.hours = hours;
		this.username = username;
	}
	
	public Assignment() {
		// Default Constructor
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDate getDate() {
		return date;
	}

	@Override
	public String toString() {
		return hours + " " + "\n" + work;
	}
}
