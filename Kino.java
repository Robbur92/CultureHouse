package kulturhus;

/*
 * Denne klassen inneholder det som skal lagres ved opprettelse av kino
 * Laget av Robin Burø s236374, Jonas Kampenhaug s236328 og Per-Tore Berg-Domaas s236333
 * sist redigert 20.05.2015
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JOptionPane;

public class Kino implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sal, sjanger, tittel, dato, tidspunkt;
	Kino neste;
	Register register;

	public Kino (String s, String ti, String sjang,  String d, String t)
	{
		sal = s;
		tittel = ti;
		sjanger = sjang;
		dato = d;
		tidspunkt = t;
		neste = null;
	}
	//set og get metoder
	public String getSal() 
	{
		return sal;
	}

	public void setSal(String sal) 
	{
		this.sal = sal;
	}

	public String getSjanger() 
	{
		return sjanger;
	}

	public void setSjanger(String sjanger) 
	{
		this.sjanger = sjanger;
	}

	public String getTittel() 
	{
		return tittel;
	}

	public void setTittel(String tittel) 
	{
		this.tittel = tittel;
	}

	public String getDato() 
	{
		return dato;
	}

	public void setDato(String dato) 
	{
		this.dato = dato;
	}

	public String getTidspunkt() 
	{
		return tidspunkt;
	}

	public void setTidspunkt(String tidspunkt) 
	{
		this.tidspunkt = tidspunkt;
	}

	//tostring som vises i brukervindu
	public String listeString() 
	{
		return "Sal: " + sal + ", Tittel:" + tittel + ", Sjanger: " + sjanger + ", Dato: " + dato + ", Tidspunkt: " + tidspunkt;
	}
	//tostring som vises ved kjøp av kinobillett
	@Override
	public String toString()
	{
		return "Tittel: " + tittel + ", Tidspunkt: " + tidspunkt;
	}
	
	//lagring
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
