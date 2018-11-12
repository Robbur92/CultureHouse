package kulturhus;
/*
 * Denne klassen inneholder metoder for å registrere et nytt teater
 * Laget av Robin Burø s236374 og Jonas Kampenhaug s236328
 * sist redigert 20.05.2015
 * klassens hensikt er å registrere et nytt teater
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

public class TeaterReg extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton bekreft;
	private JTextField salfelt, datofelt, tittelfelt, tidspunktfelt, gruppefelt;
	Register register;

	public TeaterReg(Register register) 
	{
		super("");
		this.register = register;

		// fortsetter betaling til neste vindu 
		bekreft = new JButton("Registrer Teater");

		// Skriver inn antall voksne/barn
		salfelt = new JTextField(15);
		datofelt = new JTextField(15);
		tittelfelt = new JTextField(15);
		tidspunktfelt = new JTextField(15);
		gruppefelt = new JTextField(15);

		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER));
		c.setBackground(new Color(255, 255, 255));

		c.add(new JLabel("Sal"));
		c.add(salfelt);
		c.add(new JLabel("Dato"));
		c.add(datofelt);
		c.add(new JLabel("Tittel"));
		c.add(tittelfelt);
		c.add(new JLabel("Tidspunkt"));
		c.add(tidspunktfelt);
		c.add(new JLabel("Gruppe"));
		c.add(gruppefelt);

		c.add(bekreft);

		setSize(200, 325);
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
				nyTeater();
			}
		}
	}

	public void visMelding(String melding) 
	{
		JOptionPane.showMessageDialog(this, melding);
	}
	//Oppretter nytt teater
	public void nyTeater()
	{
		String sal = salfelt.getText();
		String tittel = tittelfelt.getText();
		String dato = datofelt.getText();
		String gruppe = gruppefelt.getText();		
		String tidspunkt = tidspunktfelt.getText();
		if(sal.length() == 0 || tittel.length() == 0 || gruppe.length() == 0 )
		{
			visMelding("Fyll ut nødvendig tekstfelt");
			return;
		}
		try
		{
			Teater ny = new Teater(sal, tittel, gruppe, dato, tidspunkt);
			register.settInnTeater(ny);
			visMelding("Ny Teater Registrert");
			dispose();
		}
		catch(NumberFormatException n)
		{
			visMelding("Feil med input");
		}
	}	
}