package com.mypack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mypack.database.DatabaseClass;
import com.mypack.model.Message;
import com.mypack.model.Profile;

public class ProfileService {
private Map<String,Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("AA", new Profile(1,"AA","AAA","AAAA"));
	}
	public List<Profile> getAllProfiles(){
		/*Message m1 = new Message(1,"aa","A");
		Message m2 = new Message(2,"BB","B");
		Message m3 = new Message(3,"CC","C");
		List<Message> lst = new ArrayList<Message>();
		lst.add(m1);
		lst.add(m2);
		lst.add(m3);
		return lst;*/
		return new ArrayList<Profile>(profiles.values());
	}
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	public Profile updateProfile(Profile profile) {
		if(profile.getId() == 0) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	public Profile removeAllProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
