package kulturhus;

/*
 * Denne klassen inneholder metoder for å registrere en ny konsert
 * Laget av Robin Burø s236374 og Jonas Kampenhaug s236328
 * sist redigert 20.05.2015
 * klassens hensikt er å registrere en ny konsert
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MøteReg extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton bekreft;
	private JTextField romfelt, datofelt, tidspunktfelt, bedriftfelt, telefon, navn, enavn, adresse, epost;
	Register register;

	public MøteReg(Register register) {
		super("");
		this.register = register;

		// fortsetter betaling til neste vindu 
		bekreft = new JButton("Registrer Møte");

		// Skriver inn antall voksne/barn
		romfelt = new JTextField(10);
		datofelt = new JTextField(10);
		tidspunktfelt = new JTextField(10);
		bedriftfelt = new JTextField(10);
		telefon = new JTextField(10);
		navn = new JTextField(10);
		enavn = new JTextField(10);
		adresse = new JTextField(10);
		epost = new JTextField(10);

		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER));
		c.setBackground(new Color(255, 255, 255));

		c.add( new JLabel ("Navn:"));
		c.add( navn );
		c.add( new JLabel ("Etternavn:"));
		c.add( enavn );
		c.add( new JLabel ("Telefon:"));
		c.add( telefon );
		c.add( new JLabel ("Adresse:"));
		c.add( adresse );
		c.add( new JLabel ("E-Post:"));
		c.add( epost );
		c.add(new JLabel("Rom"));
		c.add(romfelt);
		c.add(new JLabel("Dato"));
		c.add(datofelt);
		c.add(new JLabel("Tidspunkt"));
		c.add(tidspunktfelt);
		c.add(new JLabel("Bedrift"));
		c.add(bedriftfelt);

		c.add(bekreft);
		c.add(new JLabel("50kr per rom"));

		setSize( 360, 250 );
		
		//plasserer vinduet midt på skjermen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2
				- this.getSize().height / 2);
		setVisible(true);
		//legger til knappelytter 
		Knappelytter lytter = new Knappelytter();
		bekreft.addActionListener(lytter);
	}
	//Utfører en oppgave ved knappetrykk
	private class Knappelytter implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			if (e.getSource() == bekreft) 
			{
				nyMøte();
				nyPerson();
			}
		}
	}

	public void visMelding(String melding) 
	{
		JOptionPane.showMessageDialog(this, melding);
	}

	//Oppretter nytt møte
	public void nyMøte()
	{
		String rom = romfelt.getText();
		String dato = datofelt.getText();
		String bedrift = bedriftfelt.getText();		
		String tidspunkt = tidspunktfelt.getText();
		if(rom.length() == 0 || bedrift.length() == 0 )
		{
			visMelding("Fyll ut nødvendig tekstfelt");
			return;
		}
		try
		{
			Møte ny = new Møte(rom, bedrift, dato, tidspunkt);
			register.settInnMøte(ny);
			visMelding("Nytt Møte Registrert");
			dispose();
		}
		catch(NumberFormatException n)
		{
			visMelding("Feil med Input");
		}
	}	
	
	// Legger til person i møte
	public void nyPerson()
	{
		String nnavn = navn.getText();
		String eenavn= enavn.getText();
		String ttelefon = telefon.getText();
		String aadresse = adresse.getText();
		String eepost = epost.getText();
		String arrangement = "Holdt av møterom";

		if(nnavn.length() == 0 || eenavn.length() == 0 || ttelefon.length() == 0 || eepost.length() == 0 || aadresse.length() == 0)
		{
			visMelding("Fyll ut nødvendig tekstfelt");
			return;
		}
		try
		{
			Kontaktperson ny = new Kontaktperson(nnavn, eenavn, ttelefon, aadresse, eepost, arrangement);
			register.settInnPerson(ny);
			JOptionPane.showMessageDialog(null, "Rom " +  romfelt.getText() + " holdt av til " + 
					navn.getText() + " " + enavn.getText() + "\nFaktura på kr 50 sendt til: " + epost.getText());
			Inntekt.leggTilTotal(50);
			dispose();

		}
		catch(NumberFormatException n)
		{
			visMelding("Feil med input");
		}
	}

}