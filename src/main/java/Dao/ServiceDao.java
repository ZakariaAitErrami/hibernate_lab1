package Dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;

import Metier.*;
public class ServiceDao {
	
	
	public static ArrayList<User> getAllUsers() throws Exception {
		
		Session sessionHib =  HibernateUtil.getSessionFactory().getCurrentSession();
		sessionHib.beginTransaction();
		Query req = sessionHib.createQuery("from users");
		
		return (ArrayList<User>) req.list();
	}
	
	public static void addUser(User user) throws Exception {
		Session sessionHib =  HibernateUtil.getSessionFactory().getCurrentSession();
		sessionHib.beginTransaction();
		sessionHib.save(user);
		sessionHib.getTransaction().commit();
	}
	
	public static ArrayList<Message> getAllMessages() throws Exception {
		Session sessionHib =  HibernateUtil.getSessionFactory().getCurrentSession();
		sessionHib.beginTransaction();
		Query req = sessionHib.createQuery("from messages"); 
		return (ArrayList<Message>) req.list();
	}
	
	public static void addMessage(Message msg) throws Exception{
		Session sessionHib =  HibernateUtil.getSessionFactory().getCurrentSession();
		sessionHib.beginTransaction();
		sessionHib.save(msg);
		sessionHib.getTransaction().commit();
	}
}
