package com.webservice.Demorest.model;

import java.util.Date;

public class Profile {

	String profilename;
	Long id;
	Date created;
	public Profile() {
		
	}
	public Profile(String profilename, Long id, String fname, String lname) {
		super();
		this.profilename = profilename;
		this.id = id;
		this.created = new Date();
		this.fname = fname;
		this.lname = lname;
	}
	@Override
	public String toString() {
		return "Profile [profilename=" + profilename + ", id=" + id + ", created=" + created + ", fname=" + fname
				+ ", lname=" + lname + "]";
	}
	String fname;
	String lname;
	public String getProfilename() {
		return profilename;
	}
	public void setProfilename(String profilename) {
		this.profilename = profilename;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
}
