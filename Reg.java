package kulturhus;
/*
 * Denne klassens brukes til å få opp en combobox for å registrere 
 * Laget av Robin Burø s236374, Jonas Kampenhaug s236328 og Per-Tore Berg-Domaas s236333
 * sist redigert 20.05.2015
 * hensikten med denne klassen er for å åpne andre klasser for registrering
 */
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Reg extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Register register;
	
	// Oppretter combobox for arrangementer
	private JComboBox<String> arrangementer;
	public Reg( Register register)
	{
		super( "Arrangementer" );
		this.register = register;
		// Setter inn i comboboxen
		String arrangement[] = { "Velg fra listen", "Kino", "Teater", "Foredrag", "Konsert"};   
		arrangementer = new JComboBox<>(arrangement);
		arrangementer.setSelectedIndex(0);

		Container c = getContentPane();
		c.setLayout( new FlowLayout() );
		c.add( arrangementer );
		
		// Legger til lytter
		Combolytter lytte = new Combolytter();
		arrangementer.addItemListener(lytte);
		setSize( 250, 200 );
		
		// Legger vinduet i midten av skjermen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setVisible( true );
	}
	//Utfører en oppgave ved knappetrykk
	public class Combolytter implements ItemListener
	{
		public void itemStateChanged(ItemEvent arrangementer)
		{
			if( arrangementer.getItem() == "Kino")
			{
				kinoReg();
				dispose();
			}
			else if (arrangementer.getItem() == "Teater")
			{
				teaterReg();
				dispose();
			}			 
			else if (arrangementer.getItem() == "Foredrag")
			{
				foredragReg();
				dispose();
			}
			else if (arrangementer.getItem() == "Konsert")
			{
				konsertReg();
				dispose();
			}		 
		}
	}
	
	// Åpner klassen KinoReg
	public void kinoReg()
	{
		new KinoReg(register);
	}
	// Åpner klassen TeaterReg()
	public void teaterReg()
	{
		new TeaterReg(register);
	}
	// Åpner klassen ForedragReg
	public void foredragReg()
	{
		new ForedragReg(register);
	}
	// Åpner klassen MøteReg
	public void møteReg()
	{
		new MøteReg(register);
	}
	// Åpner klassen KonsertReg
	public void konsertReg()
	{
		new KonsertReg(register);
	}
}