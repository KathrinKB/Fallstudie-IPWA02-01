import jakarta.persistence.*;


@Entity

public class Geisternetz
{


    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double breitengrad;
	private double laengengrad;
	private int groesse;
    private String status = "gemeldet";
    private String bergendePerson;
    
	
	
	public String getBergendePerson() {
		return bergendePerson;
	}
	public void setBergendePerson(String bergendePerson) {
		this.bergendePerson = bergendePerson;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getLaengengrad() {
		return laengengrad;
	}
	public void setLaengengrad(double laengengrad) {
		this.laengengrad = laengengrad;
	}
	public double getBreitengrad() {
		return breitengrad;
	}
	public void setBreitengrad(double breitengrad) {
		this.breitengrad = breitengrad;
	}
	public int getGroesse() {
		return groesse;
	}
	public void setGroesse(int groesse) {
		this.groesse = groesse;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Geisternetz() {
		
	}

}
    
 