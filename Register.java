package kulturhus;
/*
 * Denne klassens har alle metodene for å kunne registrere, slette og skrive ut de ulike arrangementene
 * Laget av Robin Burø s236374, Jonas Kampenhaug s236328
 * sist redigert 20.05.2015
 * hensikten med denne klassen er å opprette registre
 */
import java.io.Serializable;

import javax.swing.JTextArea;


public class Register implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Teater teaterFørste;
	private Kino kinoFørste;
	private Møte møteFørste;
	private Konsert konsertFørste;
	private Foredrag foredragFørste;
	private Kontaktperson personFørste;

	public Register()
	{
		teaterFørste = null;
		kinoFørste = null;
		møteFørste = null;
		konsertFørste = null;
		foredragFørste = null;
		personFørste = null;
	}

	public Kino getFørsteKino()
	{
		return kinoFørste;
	}
	// Registrerer ny kino
	public void settInnKino (Kino ny)
	{		

		if( kinoFørste == null )
		{
			kinoFørste = ny;
			return;
		}

		Kino løper = kinoFørste;
		if(løper.neste == null)
		{
			kinoFørste.neste = ny;
			return;
		}

		while(løper.neste != null)
		{
			løper = løper.neste;
			if(løper.neste == null)
			{
				løper.neste = ny;
				return;
			}
		}
	}
	// Sletter kino fra registret
	public boolean fjernKino (String tittel)
	{
		Kino løper = kinoFørste;
		if(løper == null)
		{
			return false;
		}
		if(løper.getTittel().equals(tittel))
		{
			kinoFørste = løper.neste;
			return true;
		}
		while(løper.neste != null)
		{
			if(løper.neste.neste==null && løper.neste.getTittel().equals(tittel)){
				løper.neste = null;
				return true;
			}
			if(løper.neste.getTittel().equals(tittel))
			{
				løper = løper.neste.neste;
				return true;
			}
			løper = løper.neste;
		}
		return false;
	}
	// Skriver kino i utskriftsområde
	public void skrivKinoListe( JTextArea kino )
	{

		if ( kinoFørste == null )
		{
			kino.setText("");
			kino.append( "Ingen kinoer er registrert" );
			return;
		}
		kino.setText("");
		Kino løper = kinoFørste;
		while(løper != null)
		{
			kino.append(løper.listeString() + "\n");
			if(løper.neste == null){
				return;
			}
			løper = løper.neste;
		}

	}

	public Teater getFørsteTeater()
	{
		return teaterFørste;
	}
	// Registrerer nytt teater
	public void settInnTeater (Teater ny)
	{
		if( teaterFørste == null )
		{
			teaterFørste = ny;
			return;
		}

		Teater løper = teaterFørste;
		if(løper.neste == null)
		{
			teaterFørste.neste = ny;
			return;
		}

		while(løper.neste != null)
		{
			løper = løper.neste;
			if(løper.neste == null)
			{
				løper.neste = ny;
				return;
			}
		}
	}
	// Sletter Teater fra registret
	public boolean fjernTeater (String tittel)
	{
		Teater løper = teaterFørste;
		if(løper == null)
		{
			return false;
		}
		if(løper.getTittel().equals(tittel))
		{
			teaterFørste = løper.neste;
			return true;
		}
		while(løper.neste != null)
		{
			if(løper.neste.neste==null && løper.neste.getTittel().equals(tittel))
			{
				løper.neste = null;
				return true;
			}
			if(løper.neste.getTittel().equals(tittel))
			{
				løper = løper.neste.neste;
				return true;
			}
			løper = løper.neste;
		}
		return false;
	}
	// Skriver ut teater registret i utskriftsområde
	public void skrivTeaterListe( JTextArea teater)
	{
		if ( teaterFørste == null )
		{
			teater.setText("");
			teater.append( "Ingen teater er registrert" );
			return;
		}
		teater.setText("");
		Teater løper = teaterFørste;
		while(løper != null)
		{
			teater.append(løper.listeString() + "\n");
			if(løper.neste == null){
				return;
			}
			løper = løper.neste;
		}
	}

	public Foredrag getFørsteForedrag()
	{
		return foredragFørste;
	}
	// Registrerer nytt foredrag
	public void settInnForedrag (Foredrag ny)
	{
		if( foredragFørste == null )
		{
			foredragFørste = ny;
			return;
		}

		Foredrag løper = foredragFørste;
		if(løper.neste == null)
		{
			foredragFørste.neste = ny;
			return;
		}

		while(løper.neste != null)
		{
			løper = løper.neste;
			if(løper.neste == null)
			{
				løper.neste = ny;
				return;
			}
		}
	}
	// Sletter foredrag fra registret 
	public boolean fjernForedrag (String fh)
	{
		Foredrag løper = foredragFørste;
		if(løper == null)
		{
			return false;
		}
		if(løper.getForedragsholder().equals(fh))
		{
			foredragFørste = løper.neste;
			return true;
		}
		while(løper.neste != null)
		{
			if(løper.neste.neste==null && løper.neste.getForedragsholder().equals(fh))
			{
				løper.neste = null;
				return true;
			}
			if(løper.neste.getForedragsholder().equals(fh))
			{
				løper = løper.neste.neste;
				return true;
			}
			løper = løper.neste;
		}
		return false;
	}
	// Skriver ut foredrags registret i utskriftsområde
	public void skrivForedragListe( JTextArea foredrag )
	{
		if ( foredragFørste == null )
		{
			foredrag.setText("");
			foredrag.append( "Ingen foredrag er registrert" );
			return;
		}
		foredrag.setText("");
		Foredrag løper = foredragFørste;
		while(løper != null)
		{
			foredrag.append(løper.listeString() + "\n");
			if(løper.neste == null){
				return;
			}
			løper = løper.neste;
		}
	}
	// Registrerer nytt møte i registret
	public void settInnMøte (Møte ny)
	{
		if( møteFørste == null )
		{
			møteFørste = ny;
			return;
		}

		Møte løper = møteFørste;
		if(løper.neste == null)
		{
			møteFørste.neste = ny;
			return;
		}

		while(løper.neste != null)
		{
			løper = løper.neste;
			if(løper.neste == null)
			{
				løper.neste = ny;
				return;
			}
		}
	}
	// Sletter møte fra registret
	public boolean fjernMøte (String bedrift)
	{
		Møte løper = møteFørste;
		if(løper == null)
		{
			return false;
		}
		if(løper.getBedrift().equals(bedrift))
		{
			møteFørste = løper.neste;
			return true;
		}
		while(løper.neste != null)
		{
			if(løper.neste.neste==null && løper.neste.getBedrift().equals(bedrift)){
				løper.neste = null;
				return true;
			}
			if(løper.neste.getBedrift().equals(bedrift))
			{
				løper = løper.neste.neste;
				return true;
			}
			løper = løper.neste;
		}
		return false;
	}
	// Skriver ut møte registret i utskriftsområde
	public void skrivMøteListe( JTextArea møte )
	{
		if ( møteFørste == null )
		{
			møte.setText("");
			møte.append( "Ingen møter er registrert" );
			return;
		}
		møte.setText("");
		Møte løper = møteFørste;
		while(løper != null)
		{
			møte.append(løper.toString() + "\n");
			if(løper.neste == null){
				return;
			}
			løper = løper.neste;
		}
	}

	public Konsert getFørsteKonsert()
	{
		return konsertFørste;
	}
	// Registrerer konsert i registret
	public void settInnKonsert (Konsert ny)
	{
		if( konsertFørste == null )
		{
			konsertFørste = ny;
			return;
		}

		Konsert løper = konsertFørste;
		if(løper.neste == null)
		{
			konsertFørste.neste = ny;
			return;
		}

		while(løper.neste != null)
		{
			løper = løper.neste;
			if(løper.neste == null)
			{
				løper.neste = ny;
				return;
			}
		}
	}
	// Sletter konsert fra registret
	public boolean fjernKonsert (String artist)
	{
		Konsert løper = konsertFørste;
		if(løper == null)
		{
			return false;
		}
		if(løper.getArtist().equals(artist))
		{
			konsertFørste = løper.neste;
			return true;
		}
		while(løper.neste != null)
		{
			if(løper.neste.neste==null && løper.neste.getArtist().equals(artist)){
				løper.neste = null;
				return true;
			}
			if(løper.neste.getArtist().equals(artist))
			{
				løper = løper.neste.neste;
				return true;
			}
			løper = løper.neste;
		}
		return false;
	}
	// Skriver ut konsert registret i utskriftsområde
	public void skrivKonsertListe( JTextArea konsert )
	{
		if ( konsertFørste == null )
		{
			konsert.setText("");
			konsert.append( "Ingen konserter er registrert" );
			return;
		}
		konsert.setText("");
		Konsert løper = konsertFørste;
		while(løper != null)
		{
			konsert.append(løper.listeString() + "\n");
			if(løper.neste == null){
				return;
			}
			løper = løper.neste;
		}
	}
	// Registrerer en ny person i registret
	public void settInnPerson (Kontaktperson ny)
	{		

		if( personFørste == null )
		{
			personFørste = ny;
			return;
		}

		Kontaktperson løper = personFørste;
		if(løper.neste == null)
		{
			personFørste.neste = ny;
			return;
		}

		while(løper.neste != null)
		{
			løper = løper.neste;
			if(løper.neste == null)
			{
				løper.neste = ny;
				return;
			}
		}
	}
	// Skriver ut person registret i utskriftsområde
	public void skrivPersonListe( JTextArea person )
	{
		if ( personFørste == null )
		{
			person.setText("");
			person.append( "Ingen personer registrert" );
			return;
		}
		person.setText("");
		Kontaktperson løper = personFørste;
		while(løper != null)
		{
			person.append(løper.toString() + "\n");
			if(løper.neste == null){
				return;
			}
			løper = løper.neste;
		}
	}
}
