import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

@Named
@ApplicationScoped

public class GhostNetFishing implements Serializable 
{
	
	
	private static final long serialVersionUID = 1L;
	
	private static transient EntityManagerFactory emf = Persistence.createEntityManagerFactory("ghostNetFishingPersistenceUnit");
	
	private List<Geisternetz> geisternetzeListe = new ArrayList<Geisternetz>();
	private List<Benutzer> benutzerListe = new ArrayList<Benutzer>();
	
	private Benutzer benutzer = new Benutzer();

	
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
    
	public void closeEntityManagerFactory() {
		if(emf != null && emf.isOpen()) {
			emf.close();
		}
	}
	
    

	public List<Geisternetz> getGeisternetzeListe() {
	    if (geisternetzeListe.isEmpty()) {
	        EntityManager em = getEntityManager();
	        try {
	            Query q = em.createQuery("select g from Geisternetz g");
	            geisternetzeListe = q.getResultList();
	        } finally {
	            em.close();
	        }
	    } else {
	    }
	    return geisternetzeListe;
	}
		

	//Diese Methode wird in der GeisternetzConroller Bean benötigt, damit nach dem Hinzufügen eines neuen Geisternetzes 
	//und nach Statusänderungen die Tabellen aktualisiert werden 
	
	public void reloadGeisternetze() {
	    EntityManager em = emf.createEntityManager();
	    try {
	        Query query = em.createQuery("SELECT g FROM Geisternetz g");
	        geisternetzeListe = query.getResultList(); // Die Liste mit den akutellen Einträgen füllen
	    } finally {
	        em.close(); 
	    }
	}


    
	public List<Benutzer> getBenutzerListe() {
	    if (benutzerListe.isEmpty()) {
	        EntityManager em = getEntityManager();
	        try {
	            Query q = em.createQuery("select b from Benutzer b");
	            benutzerListe = q.getResultList();
	        } finally {
	            em.close();
	        }
	    } else {
	    }
	    return benutzerListe;
	}

	public Benutzer getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}
    
 
	
}
