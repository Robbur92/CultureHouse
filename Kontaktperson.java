package kulturhus;
/*
 * Denne klassens inneholder alt som skal lagres ved opprettelse av ny kontaktperson og metoder for lagring
 * Laget av Robin Burø s236374, Jonas Kampenhaug s236328 og Per-Tore Berg-Domaas s236333
 * sist redigert 20.05.2015
 * hensikten med denne klassen er å opprette en ny kontaktperson
 */
import java.io.Serializable;

public class Kontaktperson implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String navn, enavn, adresse, epost, telefon, arrangement;
	Kontaktperson neste;

	public Kontaktperson(String n, String en, String t, String adr, String e, String k)
	{
		navn = n;
		enavn = en;
		telefon = t;
		adresse = adr;
		epost = e;
		arrangement = k;
		neste = null;
	}
	//Get og set metoder
	public String getNavn() 
	{
		return navn;
	}

	public void setNavn(String n) 
	{
		navn = n;
	}

	public String getEpost() 
	{
		return epost;
	}

	public void setEpost(String e) 
	{
		epost = e;
	}

	public String getTelefon() 
	{
		return telefon;
	}

	public void setTelefon(String t) 
	{
		telefon = t;
	}

	public String getAdresse() 
	{
		return adresse;
	}

	public void setAdresse(String adresse) 
	{
		this.adresse = adresse;
	}

	public String getEnavn() 
	{
		return enavn;
	}

	public void setEnavn(String enavn) 
	{
		this.enavn = enavn;
	}
	
	// toString metode som vises i utskriftsområde i Adminvindu
	@Override
	public String toString() 
	{
		return "Navn:" + navn + ", Etternavn:" + enavn
				+ ", Adresse:" + adresse + ", \nEpost:" + epost + ", Telefon:" + telefon + "\n" + arrangement+"\n";
	}

}
