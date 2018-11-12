package kulturhus;
/*
 * Klassens hensikt er � vise et vindu som kunder skal bruke
 * Klassen oppretter brukervindu ved kj�ring av programmet
 * Laget av Robin Bur� s236374, Jonas Kampenhaug s236328 og Per-Tore Berg-Domaas s236333
 * sist redigert 19.05.2015
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Brukervindu extends JFrame
{	
	private static final long serialVersionUID = 1L;
	private JTextArea utskriftsomr�de;
	private JButton kj�p, kino, teater, foredrag, konsert, m�te;
	Date tidspunkt;
	Register register;

	public Brukervindu( Register register ) 
	{
		super ( "Kulturhus" );
		this.register = register;
		// Knapper
		kj�p = new JButton("Kj�p billett eller hold av m�terom");
		kj�p.setBackground(Color.WHITE);
		kj�p.setForeground(Color.BLACK);
		kino = new JButton("Kinoprogram");
		kino.setBackground(Color.WHITE);
		kino.setForeground(Color.BLACK);
		teater = new JButton("Teaterprogram");
		teater.setBackground(Color.WHITE);
		teater.setForeground(Color.BLACK);
		foredrag = new JButton("Oversikt Foredrag");
		foredrag.setBackground(Color.WHITE);
		foredrag.setForeground(Color.BLACK);
		konsert = new JButton("Konserter");
		konsert.setBackground(Color.WHITE);
		konsert.setForeground(Color.BLACK);
		m�te = new JButton("M�terom");
		m�te.setBackground(Color.WHITE);
		m�te.setForeground(Color.BLACK);

		// Info om kino, teater, foredrag osv		
		utskriftsomr�de = new JTextArea( 24, 50 );
		utskriftsomr�de.setEditable( false );


		Container c = getContentPane();
		c.setLayout( new FlowLayout() );
		c.setBackground( new Color(255, 255, 255) );

		// legger til knappene i container
		c.add( kino );
		c.add( teater );
		c.add( foredrag );
		c.add( konsert );
		c.add( m�te );
		c.add( kj�p );
		c.add( new JScrollPane( utskriftsomr�de ) );

		// Registrerer knappetrykk
		Knappelytter lytter = new Knappelytter();

		kj�p.addActionListener( lytter );
		kino.addActionListener( lytter );
		teater.addActionListener( lytter );
		foredrag.addActionListener( lytter );
		konsert.addActionListener( lytter );
		m�te.addActionListener( lytter );
		setSize( 600, 500 );
		setLocation(700,100);
		setVisible( true );    
	}

	private class Knappelytter implements ActionListener
	{

		public void actionPerformed( ActionEvent e )
		{
			// registerer kj�p
			if( e.getSource() == kj�p )
			{
				new Kj�p1(register);
			}
			// Viser program for kino
			else if( e.getSource() == kino )
			{
				register.skrivKinoListe(utskriftsomr�de);
			}
			// Viser program for teater
			else if( e.getSource() == teater )
			{
				register.skrivTeaterListe(utskriftsomr�de);
			}
			// Viser program for foredrag
			else if( e.getSource() == foredrag )
			{
				register.skrivForedragListe(utskriftsomr�de);
			}
			// viser program for konsert
			else if( e.getSource() == konsert )
			{
				register.skrivKonsertListe(utskriftsomr�de);
			}
			// viser lokaler til leie for m�te
			else if( e.getSource() == m�te)
			{
				register.skrivM�teListe(utskriftsomr�de);
			}
		}

	}
	//Henter inn klassen M�teReg
	public void m�teReg(Register register)
	{
		new M�teReg(register);
	}


}