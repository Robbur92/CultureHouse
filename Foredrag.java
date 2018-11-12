package kulturhus;

/*
 * Denne klassens inneholder alt som skal lagres ved opprettelse av nytt foredrag og metoder for lagring
 * Laget av Robin Burø s236374, Jonas Kampenhaug s236328 og Per-Tore Berg-Domaas s236333
 * sist redigert 20.05.2015
 * hensikten med denne klassen er å opprette et nytt foredrag
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JOptionPane;

public class Foredrag implements Serializable
{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sal, tittel, foredragsholder, dato, tidspunkt;
	Foredrag neste;
	Register register;

	public Foredrag (String s, String ti, String fh, String d, String t)
	{
		sal = s;
		tittel = ti;
		foredragsholder = fh;
		dato = d;
		tidspunkt = t;
		neste = null;
	}
	//Set og get metoder
	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public String getForedragsholder() {
		return foredragsholder;
	}

	public void setForedragsholder(String foredragsholder) {
		this.foredragsholder = foredragsholder;
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
		return "Sal:" + sal + ", Tittel:" + tittel
				+ ", Foredragsholder:" + foredragsholder + ", Dato:" + dato
				+ ", Tidspunkt:" + tidspunkt;

	}
	//toString som skal vises i combobox ved kjøp av billett
	@Override
	public String toString() 
	{
		return "Tittel: " + tittel + ", Foredragsholder: " + foredragsholder;
	}
	//Lagring 
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
