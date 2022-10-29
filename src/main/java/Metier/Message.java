package Metier;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Message implements Serializable{
	private long id;
	private User user;
	private String message;
	private Date date;
	
	public static SimpleDateFormat formatter =
			new SimpleDateFormat ("E D MMM yyyy, H:m:s",Locale.FRANCE);
	
	
	public Message() {
		this.date = new Date((new java.util.Date()).getTime() );
	}


	public Message(User user, String message, Date date) {
		super();
		this.user = user;
		this.message = message;
		this.date = date;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getDate() {
		if(date == null)
			return "";
		return formatter.format(
				new java.util.Date(date.getTime())
				);
	}
	
	public Date getDate2() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	
	
}
