import java.io.Serializable;
import java.util.List;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.*;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.*;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped

public class LoginController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String passwort;
		
	private List<Benutzer> benutzerListe;
	
	@Inject
	private GhostNetFishing ghostNetFishing; 
	
	@Inject
	private SessionController sessionController;
	
	
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
	
	public List<Benutzer> getBenutzerListe() {
        if (benutzerListe == null) {
            benutzerListe = ghostNetFishing.getBenutzerListe();
        }
        return benutzerListe;
    }
	
	
	public void postValidateUsername(ComponentSystemEvent ev) throws AbortProcessingException {
		UIInput temp = (UIInput)ev.getComponent();
		this.username = (String)temp.getValue();
	}
	
	
	public void validateLogin(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		getBenutzerListe();
		for (Benutzer b:benutzerListe) {
			Benutzer temp=new Benutzer(this.username, (String)value);
			if(b.equals(temp))
				return;
		}
		throw new ValidatorException (new FacesMessage("Login fehlgeschlagen"));
	}	
	
	public String login() {
		sessionController.setBenutzerAngemeldet(true);
		sessionController.setUsername(this.username);
		return "userSeite";
	}
	
	
}