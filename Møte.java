package kulturhus;
/*
 * Denne klassens inneholder alt som skal lagres ved opprettelse av nytt møte og metoder for lagring
 * Laget av Robin Burø s236374, Jonas Kampenhaug s236328 og Per-Tore Berg-Domaas s236333
 * sist redigert 20.05.2015
 * hensikten med denne klassen er å opprette et nytt møte
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JOptionPane;

public class Møte implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rom, bedrift, dato, tidspunkt;
	Møte neste;
	Register register;

	public Møte (String s,String b, String d, String t)
	{
		rom = s;
		bedrift = b;
		dato = d;
		tidspunkt = t;
		neste = null;
	}
	// Get og set metoder 
	public String getRom() {
		return rom;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

	public String getBedrift() {
		return bedrift;
	}

	public void setBedrift(String bedrift) {
		this.bedrift = bedrift;
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
	
	// toString som vises i utskriftsområde i brukervinduet
	@Override
	public String toString() {
		return "Rom:" + rom + ", Bedrift:" + bedrift + ", Dato:" + dato
				+ ", Tidspunkt:" + tidspunkt;
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
