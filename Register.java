package kulturhus;
/*
 * Denne klassens har alle metodene for � kunne registrere, slette og skrive ut de ulike arrangementene
 * Laget av Robin Bur� s236374, Jonas Kampenhaug s236328
 * sist redigert 20.05.2015
 * hensikten med denne klassen er � opprette registre
 */
import java.io.Serializable;

import javax.swing.JTextArea;


public class Register implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Teater teaterF�rste;
	private Kino kinoF�rste;
	private M�te m�teF�rste;
	private Konsert konsertF�rste;
	private Foredrag foredragF�rste;
	private Kontaktperson personF�rste;

	public Register()
	{
		teaterF�rste = null;
		kinoF�rste = null;
		m�teF�rste = null;
		konsertF�rste = null;
		foredragF�rste = null;
		personF�rste = null;
	}

	public Kino getF�rsteKino()
	{
		return kinoF�rste;
	}
	// Registrerer ny kino
	public void settInnKino (Kino ny)
	{		

		if( kinoF�rste == null )
		{
			kinoF�rste = ny;
			return;
		}

		Kino l�per = kinoF�rste;
		if(l�per.neste == null)
		{
			kinoF�rste.neste = ny;
			return;
		}

		while(l�per.neste != null)
		{
			l�per = l�per.neste;
			if(l�per.neste == null)
			{
				l�per.neste = ny;
				return;
			}
		}
	}
	// Sletter kino fra registret
	public boolean fjernKino (String tittel)
	{
		Kino l�per = kinoF�rste;
		if(l�per == null)
		{
			return false;
		}
		if(l�per.getTittel().equals(tittel))
		{
			kinoF�rste = l�per.neste;
			return true;
		}
		while(l�per.neste != null)
		{
			if(l�per.neste.neste==null && l�per.neste.getTittel().equals(tittel)){
				l�per.neste = null;
				return true;
			}
			if(l�per.neste.getTittel().equals(tittel))
			{
				l�per = l�per.neste.neste;
				return true;
			}
			l�per = l�per.neste;
		}
		return false;
	}
	// Skriver kino i utskriftsomr�de
	public void skrivKinoListe( JTextArea kino )
	{

		if ( kinoF�rste == null )
		{
			kino.setText("");
			kino.append( "Ingen kinoer er registrert" );
			return;
		}
		kino.setText("");
		Kino l�per = kinoF�rste;
		while(l�per != null)
		{
			kino.append(l�per.listeString() + "\n");
			if(l�per.neste == null){
				return;
			}
			l�per = l�per.neste;
		}

	}

	public Teater getF�rsteTeater()
	{
		return teaterF�rste;
	}
	// Registrerer nytt teater
	public void settInnTeater (Teater ny)
	{
		if( teaterF�rste == null )
		{
			teaterF�rste = ny;
			return;
		}

		Teater l�per = teaterF�rste;
		if(l�per.neste == null)
		{
			teaterF�rste.neste = ny;
			return;
		}

		while(l�per.neste != null)
		{
			l�per = l�per.neste;
			if(l�per.neste == null)
			{
				l�per.neste = ny;
				return;
			}
		}
	}
	// Sletter Teater fra registret
	public boolean fjernTeater (String tittel)
	{
		Teater l�per = teaterF�rste;
		if(l�per == null)
		{
			return false;
		}
		if(l�per.getTittel().equals(tittel))
		{
			teaterF�rste = l�per.neste;
			return true;
		}
		while(l�per.neste != null)
		{
			if(l�per.neste.neste==null && l�per.neste.getTittel().equals(tittel))
			{
				l�per.neste = null;
				return true;
			}
			if(l�per.neste.getTittel().equals(tittel))
			{
				l�per = l�per.neste.neste;
				return true;
			}
			l�per = l�per.neste;
		}
		return false;
	}
	// Skriver ut teater registret i utskriftsomr�de
	public void skrivTeaterListe( JTextArea teater)
	{
		if ( teaterF�rste == null )
		{
			teater.setText("");
			teater.append( "Ingen teater er registrert" );
			return;
		}
		teater.setText("");
		Teater l�per = teaterF�rste;
		while(l�per != null)
		{
			teater.append(l�per.listeString() + "\n");
			if(l�per.neste == null){
				return;
			}
			l�per = l�per.neste;
		}
	}

	public Foredrag getF�rsteForedrag()
	{
		return foredragF�rste;
	}
	// Registrerer nytt foredrag
	public void settInnForedrag (Foredrag ny)
	{
		if( foredragF�rste == null )
		{
			foredragF�rste = ny;
			return;
		}

		Foredrag l�per = foredragF�rste;
		if(l�per.neste == null)
		{
			foredragF�rste.neste = ny;
			return;
		}

		while(l�per.neste != null)
		{
			l�per = l�per.neste;
			if(l�per.neste == null)
			{
				l�per.neste = ny;
				return;
			}
		}
	}
	// Sletter foredrag fra registret 
	public boolean fjernForedrag (String fh)
	{
		Foredrag l�per = foredragF�rste;
		if(l�per == null)
		{
			return false;
		}
		if(l�per.getForedragsholder().equals(fh))
		{
			foredragF�rste = l�per.neste;
			return true;
		}
		while(l�per.neste != null)
		{
			if(l�per.neste.neste==null && l�per.neste.getForedragsholder().equals(fh))
			{
				l�per.neste = null;
				return true;
			}
			if(l�per.neste.getForedragsholder().equals(fh))
			{
				l�per = l�per.neste.neste;
				return true;
			}
			l�per = l�per.neste;
		}
		return false;
	}
	// Skriver ut foredrags registret i utskriftsomr�de
	public void skrivForedragListe( JTextArea foredrag )
	{
		if ( foredragF�rste == null )
		{
			foredrag.setText("");
			foredrag.append( "Ingen foredrag er registrert" );
			return;
		}
		foredrag.setText("");
		Foredrag l�per = foredragF�rste;
		while(l�per != null)
		{
			foredrag.append(l�per.listeString() + "\n");
			if(l�per.neste == null){
				return;
			}
			l�per = l�per.neste;
		}
	}
	// Registrerer nytt m�te i registret
	public void settInnM�te (M�te ny)
	{
		if( m�teF�rste == null )
		{
			m�teF�rste = ny;
			return;
		}

		M�te l�per = m�teF�rste;
		if(l�per.neste == null)
		{
			m�teF�rste.neste = ny;
			return;
		}

		while(l�per.neste != null)
		{
			l�per = l�per.neste;
			if(l�per.neste == null)
			{
				l�per.neste = ny;
				return;
			}
		}
	}
	// Sletter m�te fra registret
	public boolean fjernM�te (String bedrift)
	{
		M�te l�per = m�teF�rste;
		if(l�per == null)
		{
			return false;
		}
		if(l�per.getBedrift().equals(bedrift))
		{
			m�teF�rste = l�per.neste;
			return true;
		}
		while(l�per.neste != null)
		{
			if(l�per.neste.neste==null && l�per.neste.getBedrift().equals(bedrift)){
				l�per.neste = null;
				return true;
			}
			if(l�per.neste.getBedrift().equals(bedrift))
			{
				l�per = l�per.neste.neste;
				return true;
			}
			l�per = l�per.neste;
		}
		return false;
	}
	// Skriver ut m�te registret i utskriftsomr�de
	public void skrivM�teListe( JTextArea m�te )
	{
		if ( m�teF�rste == null )
		{
			m�te.setText("");
			m�te.append( "Ingen m�ter er registrert" );
			return;
		}
		m�te.setText("");
		M�te l�per = m�teF�rste;
		while(l�per != null)
		{
			m�te.append(l�per.toString() + "\n");
			if(l�per.neste == null){
				return;
			}
			l�per = l�per.neste;
		}
	}

	public Konsert getF�rsteKonsert()
	{
		return konsertF�rste;
	}
	// Registrerer konsert i registret
	public void settInnKonsert (Konsert ny)
	{
		if( konsertF�rste == null )
		{
			konsertF�rste = ny;
			return;
		}

		Konsert l�per = konsertF�rste;
		if(l�per.neste == null)
		{
			konsertF�rste.neste = ny;
			return;
		}

		while(l�per.neste != null)
		{
			l�per = l�per.neste;
			if(l�per.neste == null)
			{
				l�per.neste = ny;
				return;
			}
		}
	}
	// Sletter konsert fra registret
	public boolean fjernKonsert (String artist)
	{
		Konsert l�per = konsertF�rste;
		if(l�per == null)
		{
			return false;
		}
		if(l�per.getArtist().equals(artist))
		{
			konsertF�rste = l�per.neste;
			return true;
		}
		while(l�per.neste != null)
		{
			if(l�per.neste.neste==null && l�per.neste.getArtist().equals(artist)){
				l�per.neste = null;
				return true;
			}
			if(l�per.neste.getArtist().equals(artist))
			{
				l�per = l�per.neste.neste;
				return true;
			}
			l�per = l�per.neste;
		}
		return false;
	}
	// Skriver ut konsert registret i utskriftsomr�de
	public void skrivKonsertListe( JTextArea konsert )
	{
		if ( konsertF�rste == null )
		{
			konsert.setText("");
			konsert.append( "Ingen konserter er registrert" );
			return;
		}
		konsert.setText("");
		Konsert l�per = konsertF�rste;
		while(l�per != null)
		{
			konsert.append(l�per.listeString() + "\n");
			if(l�per.neste == null){
				return;
			}
			l�per = l�per.neste;
		}
	}
	// Registrerer en ny person i registret
	public void settInnPerson (Kontaktperson ny)
	{		

		if( personF�rste == null )
		{
			personF�rste = ny;
			return;
		}

		Kontaktperson l�per = personF�rste;
		if(l�per.neste == null)
		{
			personF�rste.neste = ny;
			return;
		}

		while(l�per.neste != null)
		{
			l�per = l�per.neste;
			if(l�per.neste == null)
			{
				l�per.neste = ny;
				return;
			}
		}
	}
	// Skriver ut person registret i utskriftsomr�de
	public void skrivPersonListe( JTextArea person )
	{
		if ( personF�rste == null )
		{
			person.setText("");
			person.append( "Ingen personer registrert" );
			return;
		}
		person.setText("");
		Kontaktperson l�per = personF�rste;
		while(l�per != null)
		{
			person.append(l�per.toString() + "\n");
			if(l�per.neste == null){
				return;
			}
			l�per = l�per.neste;
		}
	}
}
