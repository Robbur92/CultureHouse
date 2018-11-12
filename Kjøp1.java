package kulturhus;

/*
 * Denne klassen inneholder metoder for å vise et vindu 
 * Laget av Robin Burø s236374 og Jonas Kampenhaug s236328
 * sist redigert 20.05.2015
 * Klassens hensikt er å vise et vindu der man kan velge hvilket arrangement man vil kjøpe billett til
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Kjøp1 extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Register register;
	private JComboBox<String> arrangementer;

	/**
	 * 
	 */
	public Kjøp1(Register r)
	{
		super ( "Betaling" );
		register = r;
		
		//array som vises i combobox
		String arrangement[] = { "Velg fra listen", "Kino", "Teater", "Foredrag", "Konsert", "Møte"};   
		arrangementer = new JComboBox<>(arrangement);
		arrangementer.setSelectedIndex(0);

		Container c = getContentPane();
		c.setLayout( new FlowLayout() );
		c.setBackground( new Color(255, 255, 255) );
		
		//legger til lytter til comboboxen
		Combolytter lytte = new Combolytter();
		arrangementer.addItemListener(lytte);
		c.add( arrangementer );

		setSize( 200, 200 );
		//plasserer vinduet midt på skjermen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setVisible( true );

	}

	//metode for å uteføre klasser ved valg i combobox
	public class Combolytter implements ItemListener
	{
		public void itemStateChanged(ItemEvent arrangementer)
		{
			if( arrangementer.getItem() == "Kino")
			{
				kjøpKino(register);
				dispose();
			}
			else if (arrangementer.getItem() == "Teater")
			{
				kjøpTeater(register);
				dispose();
			}			 
			else if (arrangementer.getItem() == "Foredrag")
			{
				kjøpForedrag(register);
				dispose();
			}
			else if (arrangementer.getItem() == "Konsert")
			{
				kjøpKonsert(register);
				dispose();
			}	
			else if(arrangementer.getItem() == "Møte")
			{
				kjøpMøte(register);
				dispose();
			}
		}
	}
	
	//Henter inn alle klasser som blir brukt
	private void kjøpKino(Register register) 
	{
		new KjøpKino(register);
	}
	private void kjøpForedrag(Register register)
	{
		new KjøpForedrag(register);
	}
	private void kjøpKonsert(Register register)
	{
		new KjøpKonsert(register);
	}
	private void kjøpTeater(Register register)
	{
		new KjøpTeater(register);
	}
	private void kjøpMøte(Register register)
	{
		new MøteReg(register);
	}
}
















