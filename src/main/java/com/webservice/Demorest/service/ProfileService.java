package com.webservice.Demorest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.webservice.Demorest.database.DatabaseClass;
import com.webservice.Demorest.model.Message;
import com.webservice.Demorest.model.Profile;

public class ProfileService {

	Map<String, Profile> profiles = DatabaseClass.getProfiles();
	public ProfileService() {
		profiles.put("Arun", new Profile("Arun", 1l, "Arun", "Varghese"));
		profiles.put("kiran", new Profile("kiran", 2l, "kiran", "Varghese"));
	}
	
	public List<Profile> getProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	
	public Profile getProfile(String name) {
		System.out.println(profiles);
		return profiles.get(name);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1l);
		profiles.put(profile.getProfilename(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		System.out.println(profile);
		profiles.replace(profile.getProfilename(), profile);
		System.out.println(profiles);
		return profile;
	}
	
	public Profile deleteProfile(String name) {
		return profiles.remove(name);
	}
	
}
