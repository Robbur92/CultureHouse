package kulturhus;

/*
 * Denne klassen inneholder metoder for � vise et vindu 
 * Laget av Robin Bur� s236374 og Jonas Kampenhaug s236328
 * sist redigert 20.05.2015
 * Klassens hensikt er � vise et vindu der man kan velge hvilket arrangement man vil kj�pe billett til
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

public class Kj�p1 extends JFrame
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
	public Kj�p1(Register r)
	{
		super ( "Betaling" );
		register = r;
		
		//array som vises i combobox
		String arrangement[] = { "Velg fra listen", "Kino", "Teater", "Foredrag", "Konsert", "M�te"};   
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
		//plasserer vinduet midt p� skjermen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setVisible( true );

	}

	//metode for � utef�re klasser ved valg i combobox
	public class Combolytter implements ItemListener
	{
		public void itemStateChanged(ItemEvent arrangementer)
		{
			if( arrangementer.getItem() == "Kino")
			{
				kj�pKino(register);
				dispose();
			}
			else if (arrangementer.getItem() == "Teater")
			{
				kj�pTeater(register);
				dispose();
			}			 
			else if (arrangementer.getItem() == "Foredrag")
			{
				kj�pForedrag(register);
				dispose();
			}
			else if (arrangementer.getItem() == "Konsert")
			{
				kj�pKonsert(register);
				dispose();
			}	
			else if(arrangementer.getItem() == "M�te")
			{
				kj�pM�te(register);
				dispose();
			}
		}
	}
	
	//Henter inn alle klasser som blir brukt
	private void kj�pKino(Register register) 
	{
		new Kj�pKino(register);
	}
	private void kj�pForedrag(Register register)
	{
		new Kj�pForedrag(register);
	}
	private void kj�pKonsert(Register register)
	{
		new Kj�pKonsert(register);
	}
	private void kj�pTeater(Register register)
	{
		new Kj�pTeater(register);
	}
	private void kj�pM�te(Register register)
	{
		new M�teReg(register);
	}
}
















