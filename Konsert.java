package kulturhus;
/*
 * Denne klassens inneholder alt som skal lagres ved opprettelse av ny konsert og metoder for lagring
 * Laget av Robin Burø s236374, Jonas Kampenhaug s236328 og Per-Tore Berg-Domaas s236333
 * sist redigert 20.05.2015
 * hensikten med denne klassen er å opprette en ny konsert
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JOptionPane;

public class Konsert implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String scene, artist, dato, tidspunkt;
	Konsert neste;
	Register register;

	public Konsert (String s, String a, String d, String t)
	{
		scene = s;
		artist = a;
		dato = d;
		tidspunkt = t;
		neste = null;
	}
	
	// set og get metoder
	public String getScene() {
		return scene;
	}

	public void setScene(String scene) {
		this.scene = scene;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public String getTidspunkt() {
		return tidspunkt;
	}

	public void setTidspunkt(String tidspunkt) {
		this.tidspunkt = tidspunkt;
	}
	//toString som vises i utskriftsområde i brukervinduet
	public String listeString()
	{
		return "Scene:" + scene + ", Artist:" + artist + ", Dato:"
				+ dato + ", Tidspunkt:" + tidspunkt;
	}
	//toString som skal vises i combobox ved kjøp av billett
	@Override
	public String toString() {
		return "Artist: " + artist + ", Dato: " + dato;
	}
	
	// Lagring
	public void lesObjectFraFil()
	{
		try(ObjectInputStream ut = new ObjectInputStream(new FileInputStream(Konstanter.SAVE_PATH))){
			register = (Register) ut.readObject();
		}
		catch(FileNotFoundException fnfe)
		{
			JOptionPane.showMessageDialog(null, "Filen ble ikke funnet"); 
		}
		catch(ClassNotFoundException cnfe) 
		{
			JOptionPane.showMessageDialog(null, "Register feil");
		}
		catch(IOException IOException)
		{ 
			JOptionPane.showMessageDialog(null, "Kan ikke lese filen");
		}
	}

	public void lesObjectTilFil(){
		try(ObjectOutputStream inn = new ObjectOutputStream(new FileOutputStream(Konstanter.SAVE_PATH)))
		{
			inn.writeObject(register);
		}
		catch(IOException IOException)
		{ 
			JOptionPane.showMessageDialog(null, "Kunne ikke skrive til fil");
		}
	}

}
