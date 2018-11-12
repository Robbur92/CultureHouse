package kulturhus;

/*
 * Denne klassen inneholder metoder som oppretter et kino arrangement
 * Laget av Robin Burø s236374 og Jonas Kampenhaug s236328
 * sist redigert 20.05.2015
 * Klassens hensikt er å lagre et nytt kino arrangement
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

public class KinoReg extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton bekreft;
	private JTextField salfelt, tittelfelt, datofelt, tidspunktfelt, sjangerfelt;
	Register register;
	KjøpKino kjøp;

	public KinoReg(Register register) 
	{
		super("");
		this.register = register;
		// fortsetter betaling til neste vindu 
		bekreft = new JButton("Registrer Kino");
		tittelfelt = new JTextField(15);
		sjangerfelt = new JTextField(15);
		salfelt = new JTextField(15);
		datofelt = new JTextField(15);
		tidspunktfelt = new JTextField(15);

		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER));
		c.setBackground(new Color(255, 255, 255));

		//Legger til input felter 
		c.add(new JLabel("Sal"));
		c.add(salfelt);
		c.add(new JLabel("Dato"));
		c.add(datofelt);
		c.add(new JLabel("Tittel"));
		c.add(tittelfelt);
		c.add(new JLabel("Tidspunkt"));
		c.add(tidspunktfelt);
		c.add(new JLabel("Sjanger"));
		c.add(sjangerfelt);

		c.add(bekreft);

		setSize(200, 325);
		setVisible(true);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2
				- this.getSize().height / 2);


		Knappelytter lytter = new Knappelytter();
		bekreft.addActionListener(lytter);
	}
	
	//legger til knappelytter
	private class Knappelytter implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			if (e.getSource() == bekreft) 
			{
				nyKino();	
			}
		}
	}

	public void visMelding(String melding) 
	{
		JOptionPane.showMessageDialog(this, melding);
	}

	//Oppretter et nytt kino arrangement 
	public void nyKino()
	{
		String sal = salfelt.getText();
		String tittel = tittelfelt.getText();
		String dato = datofelt.getText();
		String sjanger = sjangerfelt.getText();		
		String tidspunkt = tidspunktfelt.getText();
		if(sal.length() == 0 || tittel.length() == 0 || sjanger.length() == 0 )
		{
			visMelding("Fyll ut nødvendig tekstfelt");
			return;
		}
		try
		{
			Kino ny = new Kino(sal, tittel, sjanger, dato, tidspunkt);
			register.settInnKino(ny);

			visMelding("Ny Film Registrert");
			dispose();
		}
		catch(NumberFormatException n)
		{
			visMelding("Feil med input");
		}
	}	
}