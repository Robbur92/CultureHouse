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

public class KonsertReg extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton bekreft;
	private JTextField scenefelt, datofelt, tidspunktfelt, artistfelt;
	Register register;

	public KonsertReg(Register register) {
		super("");
		this.register = register;

		// fortsetter betaling til neste vindu 
		bekreft = new JButton("Registrer Konsert");

		// Skriver inn antall voksne/barn
		scenefelt = new JTextField(15);
		datofelt = new JTextField(15);
		tidspunktfelt = new JTextField(15);
		artistfelt = new JTextField(15);

		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER));
		c.setBackground(new Color(255, 255, 255));
		//legger til felter for input
		c.add(new JLabel("Scene"));
		c.add(scenefelt);
		c.add(new JLabel("Dato"));
		c.add(datofelt);
		c.add(new JLabel("Tidspunkt"));
		c.add(tidspunktfelt);
		c.add(new JLabel("Artist"));
		c.add(artistfelt);

		c.add(bekreft);

		setSize(200, 275);
		
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
	private class Knappelytter implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == bekreft) {
				nyKonsert();


			}
		}
	}

	public void visMelding(String melding) {
		JOptionPane.showMessageDialog(this, melding);
	}
	//Oppretter ny konsert
	public void nyKonsert()
	{
		String scene = scenefelt.getText();
		String dato = datofelt.getText();
		String artist = artistfelt.getText();		
		String tidspunkt = tidspunktfelt.getText();
		if(scene.length() == 0 || artist.length() == 0 )
		{
			visMelding("Fyll ut nødvendig tekstfelt");
			return;
		}
		try
		{
			Konsert ny = new Konsert(scene, artist, dato, tidspunkt);
			register.settInnKonsert(ny);
			visMelding("Ny Konsert Registrert");
			dispose();
		}
		catch(NumberFormatException n)
		{
			visMelding("Feil med Input");
		}
	}	
}