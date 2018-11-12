package kulturhus;

/*
 * Denne klassen inneholder en int som lagrer den totale inntekten
 * Laget av Robin Burø s236374, Jonas Kampenhaug s236328 og Per-Tore Berg-Domaas s236333
 * sist redigert 20.05.2015
 * Hensikten med denne klassen er å skrive ut på skjermen hvor mye den totale inntekten er
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Inntekt
{
	private static int totalinntekt;
	Inntekt inntekt;
	
	//Tar imot prisen på billetter ved salg og legger til i variabelen som er lagret her
	public static void leggTilTotal(int tall)
	{
		totalinntekt += tall;
	}
	
	@Override
	public String toString() 
	{
		return "Inntekt av billettsalg: " + totalinntekt + "kr"; 
	}
	
	//Skriver ut inntekt i JOptionPane
	public Inntekt()
	{
		JOptionPane.showMessageDialog(null, toString() );
	}
	
	public static void lesFraFil( DataInputStream input ) throws IOException
	{
		try
		{
			totalinntekt = input.readInt();
		}
		catch( IOException s )
		{
			JOptionPane.showMessageDialog(null, "Finner ikke strømmen");
		}
	}	
	
	public static void skrivTilFil( DataOutputStream output ) throws IOException
	{
		try
		{
			output.writeInt(totalinntekt);
		}
		catch( IOException s )
		{
			JOptionPane.showMessageDialog(null, "Finner ikke strømmen");
		}
	}
	
	
}