package Metier;

import java.util.*;

import Dao.ServiceDao;

public class ServiceMetier {
	
	private static ArrayList<User> users = new ArrayList<User>();
	private static ArrayList<Message> messages = new ArrayList<Message>();
	
	public ServiceMetier() throws Exception {
		users = ServiceDao.getAllUsers();
		messages = ServiceDao.getAllMessages();
	}
	
	public static ArrayList<User> getUsers() {
		return users;
	}
	
	public static ArrayList<Message> getMessages() {
		return messages;
	}
	
	//methode Metier
	
	public static User getUserByEmail(String email) {
		for(User user : users) {
			if(user.getEmail().equals(email)) {
				return user;
			}
		}
		return null;
	}
	
	public static User getUser(String email, String motPasse) {
		for(User user : users) {
			if(user.getEmail().equals(email) && user.getPassword().equals(motPasse)) {
				return user;
			}
		}
		return null;
	}
	
	public static void addUser(User user) throws Exception {
		ServiceDao.addUser(user);
		users.add(user);
	}
	
	public static void addMessage(Message msg) throws Exception {
		ServiceDao.addMessage(msg);
		messages.add(msg);
	}
	
	public static ArrayList<Message> getMessagesByUser(User user) {
		if(user.estProf()) return messages;
		ArrayList<Message> msgs = new ArrayList<Message>();
		for(Message m: messages) {
			if(m.getUser().equals(user))
				msgs.add(m);
		}
		return msgs;
	}
}
