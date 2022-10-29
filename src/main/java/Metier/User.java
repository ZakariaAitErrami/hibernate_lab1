package Metier;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class User implements Serializable{
	
	private String nomPr;
	private String email;
	private String password;
	private boolean statut = true; //true for student
	private Set<Message> msgs;
	public User() {
		
	}

	public String getNomPr() {
		return nomPr;
	}

	public void setNomPr(String nomPr) {
		this.nomPr = nomPr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setStatut(String statut) {
		if(statut.equals("Etudiant"))
			this.statut = true;
		else
			this.statut = false;
	}
	
	public Set<Message> getMsgs() {
		return msgs;
	}

	public void setMsgs(Set<Message> msgs) {
		this.msgs = msgs;
	}

	public boolean estEtudiant() {
		return this.statut;
	}
	
	public boolean estProf() {
		return !this.statut;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if(email == null) {
			if(other.email !=null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	public void addMessage(Message m) {
		msgs.add(m);
	}
	

}
