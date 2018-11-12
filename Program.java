package kulturhus;
/*
 * Denne klassens er main klassen for programmet og brukes til å kjøre programmet
 * Laget av Robin Burø s236374, Jonas Kampenhaug s236328 og Per-Tore Berg-Domaas s236333
 * sist redigert 20.05.2015
 * hensikten med denne klassen er kjøre programmet og hente lagrede data og lagre data
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

public class Program 
{

	private static Register register = new Register();
	public static void main(String[] args) throws IOException 
	{	
		LesFraFil();
		Adminvindu vindu = new Adminvindu(register);
		Brukervindu vindu2 = new Brukervindu(register);
		// Henter lagret data
		vindu.lesObjektFraFil();
		
		//Åpner opp brukervinduet
		vindu2.addWindowListener( new WindowAdapter() 
		{
			public void windowClosing( WindowEvent e )
			{
				SkrivTilFil();
				System.exit( 0 );
			}
		} 
				);
		// Åpner opp adminvinduet
		vindu.addWindowListener( new WindowAdapter() 
		{
			public void windowClosing( WindowEvent e )
			{
				SkrivTilFil();
				vindu.skrivObjektTilFil();
				System.exit( 0 );
			}
		} 
				);
	}

	
	// Leser data fra fil
	public static void LesFraFil() throws IOException
	{
		try(ObjectInputStream inn = new ObjectInputStream(new FileInputStream(Konstanter.SAVE_PATH)))
		{
			register = (Register) inn.readObject();
		}
		catch(ClassNotFoundException cnfe)
		{
			JOptionPane.showMessageDialog(null, "Finner ikke klassen");
		}
		catch(IOException ie)
		{
			JOptionPane.showMessageDialog(null, "Feil i lesing");
		}
	}
	//Skriver data til fil
	public static void SkrivTilFil()
	{
		try(ObjectOutputStream ut = new ObjectOutputStream(new FileOutputStream(Konstanter.SAVE_PATH)))
		{
			ut.writeObject(register);
		}
		catch(IOException ie)
		{
			JOptionPane.showMessageDialog(null, "Feil i lesing");
		}
	}
}



