import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@SessionScoped
@Named
public class SessionController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private boolean benutzerAngemeldet = false;
    private String username;
    
    public boolean getBenutzerAngemeldet() {
        return benutzerAngemeldet;
    }
    public void setBenutzerAngemeldet(boolean benutzerAngemeldet) {
        this.benutzerAngemeldet = benutzerAngemeldet;
    }
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
   
}
