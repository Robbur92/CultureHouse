package kulturhus;
/*
 *Denne klassen inneholder metoder for � opprette vinduet til admin
 * Laget av Robin Bur� s236374, Jonas Kampenhaug s236328 og Per-Tore Berg-Domaas s236333
 *sist redigert 19.05.2015
 *Hensikten med denne klassen er � �pne et vindu for administrator
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Adminvindu extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea utskriftsomr�de;
	private JButton kontaktpersoner, slett, inntekt, registrer;
	private JTextField slettefelt;
	Register register;
	int inntekter;
	
	//Konstrukt�r som tar imot registeret for lagring/henting av metoder
	public Adminvindu( Register register ) 
	{
		super ( "Administrator" );
		this.register = register;
		
		// Knapper
		kontaktpersoner = new JButton("Kontaktpersoner");
		kontaktpersoner.setBackground(Color.WHITE);
		kontaktpersoner.setForeground(Color.BLACK);
		slett = new JButton("Slett");
		slett.setBackground(Color.WHITE);
		slett.setForeground(Color.BLACK);
		inntekt = new JButton("Totalinntekt");
		inntekt.setBackground(Color.WHITE);
		inntekt.setForeground(Color.BLACK);
		registrer = new JButton("Registrer arrangement");
		registrer.setBackground(Color.WHITE);
		registrer.setForeground(Color.BLACK);

		// S�kefelt
		slettefelt = new JTextField(25);

		// Info om kino, teater, foredrag osv		
		utskriftsomr�de = new JTextArea( 24, 50 );
		utskriftsomr�de.setEditable( false );

		Container c = getContentPane();
		c.setLayout( new FlowLayout() );
		c.setBackground( new Color(255, 255, 255) );

		// legger til knappene i container
		c.add( registrer );
		c.add( kontaktpersoner );
		c.add( inntekt );
		
		// legger til slettefelt i container
		c.add( slettefelt );
		c.add( slett );
		// legger til tekst som forklarer slettefunksjonen
		c.add( new JLabel("Slett ved � skrive film, tittel, foredragsholder etc.."));
		// Legger til utskriftsomr�det
		c.add( new JScrollPane( utskriftsomr�de ) );
		// Registrerer knappetrykk
		Knappelytter lytter = new Knappelytter();

		//Legger til lytteklassen p� knappene
		kontaktpersoner.addActionListener( lytter );
		slett.addActionListener( lytter );
		registrer.addActionListener( lytter );
		inntekt.addActionListener( lytter );
		
		setSize( 575, 500 );
		setLocation(100,100);
		setVisible( true );    
	}
	
	//Metode som registrerer knappetrykk
	private class Knappelytter implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			if( e.getSource() == registrer )
			{
				//�pner vindu for registrering av arrangement etc..
				registrer();
			}
			else if( e.getSource() == kontaktpersoner )
			{
				//Skriver ut kontaktpersoner
				register.skrivPersonListe(utskriftsomr�de);
			}

			else if( e.getSource() == slett )
			{
				//Utf�rer sletting ved trykk p� slett knappen
				register.fjernKino(slettefelt.getText());
				register.fjernForedrag(slettefelt.getText());
				register.fjernKonsert(slettefelt.getText());
				register.fjernM�te(slettefelt.getText());
				register.fjernTeater(slettefelt.getText());
				if(!slettefelt.getText().equals(""))
				{
					visMelding(slettefelt.getText() + " er slettet");
				}
			}

			else if( e.getSource() == inntekt )
			{
				inntekt();
			}
		}
	}
	
	//henter klassen registrer
	public void registrer() 
	{
		new Reg( register);	
	}
	
	//Henter klassen inntekt
	public void inntekt()
	{
		new Inntekt();
	}
	
	//Viser ut melding p� skjerm
	public void visMelding(String melding) 
	{
		JOptionPane.showMessageDialog(this, melding);
	}
	
	public void lesObjektFraFil() //Leser Info
	 {
		 try(DataInputStream input = new DataInputStream(new FileInputStream(Konstanter.SAVE_INNTEKT)))
		 {
			 Inntekt.lesFraFil(input);
			 inntekter = input.readInt();
		 }
		 catch(FileNotFoundException fne)
		 {
			 visMelding("Finner ikke fil");
		 }
		 catch(IOException s)
		 {
			 visMelding("Finner ikke str�mmen");
		 }
	 }
	 
	public void skrivObjektTilFil() //Skriver Info Til Fil
	 {
		 try(DataOutputStream output = new DataOutputStream(new FileOutputStream(Konstanter.SAVE_INNTEKT)))
		 {
			 Inntekt.skrivTilFil(output);
			 output.writeInt(inntekter);
		 }
		 catch( NotSerializableException nse )
		 {
			 visMelding("Objektet er ikke serialisert");
		 }
		 catch(IOException io)
		 {
			 visMelding("Finner ikke str�mmen");
		 }

	 }



}