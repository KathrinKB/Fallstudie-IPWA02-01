import java.io.Serializable;



import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;


@Named 
@ViewScoped

public class BenutzerController implements Serializable
{
	
	
	private Benutzer benutzer = new Benutzer();
	
	
	
	
	public Benutzer getBenutzer()
    {
		
        return benutzer;
    }
	
	public void setBenutzer (Benutzer benutzer) {
		this.benutzer = benutzer;
	}
		
}
