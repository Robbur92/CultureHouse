package kulturhus;
/*
 * Denne klassens inneholder alt som skal lagres ved opprettelse av nytt teater og metoder for lagring
 * Laget av Robin Burø s236374, Jonas Kampenhaug s236328 og Per-Tore Berg-Domaas s236333
 * sist redigert 20.05.2015
 * hensikten med denne klassen er å opprette et nytt teater
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JOptionPane;

public class Teater implements Serializable 
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sal, tittel, gruppe, dato, tidspunkt;
	Teater neste;
	Register register;

	public Teater (String s, String ti, String g, String d, String t)
	{
		sal = s;
		tittel = ti;
		gruppe = g;
		dato = d;
		tidspunkt = t;
		neste = null;
	}
	// Get og set metoder 
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

	public String getGruppe() {
		return gruppe;
	}

	public void setGruppe(String gruppe) {
		this.gruppe = gruppe;
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
	// toString som vise i utskriftsområde i brukervinduet
	public String listeString()
	{
		return "Sal:" + sal + ", Tittel:" + tittel + ", Gruppe:"
				+ gruppe + ", Dato:" + dato + ", Tidspunkt:" + tidspunkt;
	}
	// toString som vises i comboboxen
	@Override
	public String toString() {
		return "Tittel: " + tittel + ", Gruppe: " + gruppe;
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
