import jakarta.persistence.*;



@Entity 
public class Benutzer {
	
	
	
	@Id	
	String username;
	String vorname;
	String nachname;
	String telefon;
	String passwort;
	

		
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
	
	
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
		
	public Benutzer() {
	}
	
	public Benutzer(String username, String passwort) {
		this.username = username;
		this.passwort = passwort; 
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Benutzer) {
			Benutzer b= (Benutzer)obj;
			if(b.getUsername().equals(this.username) 
					&& b.getPasswort().equals(this.passwort)) {
				return true;
			}}
			return false;
				}
		
	}
	
