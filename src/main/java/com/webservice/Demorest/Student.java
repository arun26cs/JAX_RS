package com.webservice.Demorest;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {

	int roll;
	String name;
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
