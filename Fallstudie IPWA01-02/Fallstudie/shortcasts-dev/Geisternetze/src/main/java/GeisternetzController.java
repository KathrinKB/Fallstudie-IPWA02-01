import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.inject.Produces;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.*;


@Named 
@ViewScoped

public class GeisternetzController implements Serializable
{
	

	
	@Inject
	private GhostNetFishing ghostNetFishing;
	@Inject
	private SessionController sessionController;
	
	private Geisternetz geisternetz = new Geisternetz();
	
	
	
	
	public Geisternetz getGeisternetz()
    {
		
        return geisternetz;
    }
	
	public void setGeisternetz (Geisternetz geisternetz) {
		this.geisternetz = geisternetz;
	}
	
	

	public String startMelden()
	{
		
		return "geisternetzeMelden";
	}

	
	
	public String stopMelden() {
		
		Geisternetz newGeisternetz = new Geisternetz();
		
		newGeisternetz.setLaengengrad(geisternetz.getLaengengrad());
	    newGeisternetz.setBreitengrad(geisternetz.getBreitengrad());
	    newGeisternetz.setGroesse(geisternetz.getGroesse());
		
		EntityManager em = ghostNetFishing.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		
		em.persist(newGeisternetz);
		
		t.commit();
		em.close();
		
		//Liste muss neu geladen werden, damit die Tabelle aktualisiert wird. 
		ghostNetFishing.reloadGeisternetze();
		
		if (sessionController.getBenutzerAngemeldet()) {
			return "userSeite";
			}
				return "index";
		}
	
		public String bergen(Geisternetz geisternetz) {
		
		String currentUser = sessionController.getUsername();
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ghostNetFishingPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Geisternetz currentGeisternetz = em.find(Geisternetz.class, geisternetz.getId());
		currentGeisternetz.setStatus("zur Bergung angemeldet");
		currentGeisternetz.setBergendePerson(currentUser);
		em.merge(currentGeisternetz);
		t.commit();
		
		//Liste muss neu geladen werden, damit die Tabelle aktualisiert wird. 
		ghostNetFishing.reloadGeisternetze();
		
		return "userSeite";
		
		}
		
		public String geborgen(Geisternetz geisternetz) {
				
		EntityManager em = ghostNetFishing.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		Geisternetz currentGeisternetz = em.find(Geisternetz.class, geisternetz.getId());
		currentGeisternetz.setStatus("geborgen");
		em.merge(currentGeisternetz);
		t.commit();
		
		//Liste muss neu geladen werden, damit die Tabelle aktualisiert wird. 
		ghostNetFishing.reloadGeisternetze();
		
		return "benutzerListe";
		
		}
		
		public String verschollen(Geisternetz geisternetz) {
			
			EntityManager em = ghostNetFishing.getEntityManager();
			EntityTransaction t = em.getTransaction();
			t.begin();
			Geisternetz currentGeisternetz = em.find(Geisternetz.class, geisternetz.getId());
			currentGeisternetz.setStatus("verschollen");
			em.merge(currentGeisternetz);
			t.commit();
			
			//Liste muss neu geladen werden, damit die Tabelle aktualisiert wird. 
			ghostNetFishing.reloadGeisternetze();
			
			return "benutzerListe";
			
			}
	
	
	
}
