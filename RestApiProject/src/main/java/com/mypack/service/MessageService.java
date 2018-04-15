package com.mypack.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.mypack.database.DatabaseClass;
import com.mypack.model.Message;

public class MessageService {
	private Map<Long,Message> messages = DatabaseClass.getMessages();
	
	public MessageService() {
		SimpleDateFormat dateformat2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String strdate2 = "02-04-2018 11:35:42";

		try {
			messages.put(1L, new Message(1,"aa","tt",dateformat2.parse(strdate2)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			messages.put(2L, new Message(2,"CC","AA",dateformat2.parse(strdate2)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Message> getAllMessages(){
		/*Message m1 = new Message(1,"aa","A");
		Message m2 = new Message(2,"BB","B");
		Message m3 = new Message(3,"CC","C");
		List<Message> lst = new ArrayList<Message>();
		lst.add(m1);
		lst.add(m2);
		lst.add(m3);
		return lst;*/
		return new ArrayList<Message>(messages.values());
	}
	public Message getMessage(long id) {
		return messages.get(id);
	}
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put((long) message.getId(), message);
		return message;
	}
	public Message updateMessage(Message message) {
		if(message.getId() == 0) {
			return null;
		}
		messages.put((long) message.getId(), message);
		return message;
	}
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	
	public List<Message> getAllMessageForYear(int year){
		List<Message> messagesForYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for(Message message: messages.values()) {
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}	
		}
		return messagesForYear;
	}
	public List<Message> getAllMessagesPaginated(int start,int size){
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if(start + size >list.size()) {
			return new ArrayList<Message>();
		}
		return list.subList(start, start+size);
	}
}
