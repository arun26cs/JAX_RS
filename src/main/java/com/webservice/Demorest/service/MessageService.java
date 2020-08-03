package com.webservice.Demorest.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.webservice.Demorest.database.DatabaseClass;
import com.webservice.Demorest.model.Message;


public class MessageService {
//creates dummy messages
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		System.out.println("executed");
		messages.put(1l, new Message(1,"message1","Arun"));
		messages.put(2l, new Message(2,"message2","kiran"));
	}
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
		
	}
	public List<Message> getAllMessagesInYear(int year){
		List<Message> messagesForYears= new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for(Message m:messages.values()) {
			cal.setTime(m.getCreated());
			if(cal.get(Calendar.YEAR)==year) {
				messagesForYears.add(m);
			}
		}
		return messagesForYears;
	}
	
	public List<Message> getAllMessagesPaginated(int start,int size){
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		System.out.println("inlist "+list.subList(start, size));
		return list.subList(start, size);
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message m) {
		m.setId(messages.size()+1);
		messages.put(m.getId(), m);
		return m;
	}
	
	public Message updateMessage(Message m) {
		messages.replace(m.getId(), m);
		return m;
	}
	public Message removeMessage(Long id) {
		Map<Long, Message> messages1=messages;
		messages1.remove(id);
		System.out.println(messages1);
		return messages.remove(id);
	}
	
	 
}
