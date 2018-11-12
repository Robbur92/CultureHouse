package kulturhus;
/*
 * Klassens hensikt er å vise et vindu som kunder skal bruke
 * Klassen oppretter brukervindu ved kjøring av programmet
 * Laget av Robin Burø s236374, Jonas Kampenhaug s236328 og Per-Tore Berg-Domaas s236333
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
	private JTextArea utskriftsområde;
	private JButton kjøp, kino, teater, foredrag, konsert, møte;
	Date tidspunkt;
	Register register;

	public Brukervindu( Register register ) 
	{
		super ( "Kulturhus" );
		this.register = register;
		// Knapper
		kjøp = new JButton("Kjøp billett eller hold av møterom");
		kjøp.setBackground(Color.WHITE);
		kjøp.setForeground(Color.BLACK);
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
		møte = new JButton("Møterom");
		møte.setBackground(Color.WHITE);
		møte.setForeground(Color.BLACK);

		// Info om kino, teater, foredrag osv		
		utskriftsområde = new JTextArea( 24, 50 );
		utskriftsområde.setEditable( false );


		Container c = getContentPane();
		c.setLayout( new FlowLayout() );
		c.setBackground( new Color(255, 255, 255) );

		// legger til knappene i container
		c.add( kino );
		c.add( teater );
		c.add( foredrag );
		c.add( konsert );
		c.add( møte );
		c.add( kjøp );
		c.add( new JScrollPane( utskriftsområde ) );

		// Registrerer knappetrykk
		Knappelytter lytter = new Knappelytter();

		kjøp.addActionListener( lytter );
		kino.addActionListener( lytter );
		teater.addActionListener( lytter );
		foredrag.addActionListener( lytter );
		konsert.addActionListener( lytter );
		møte.addActionListener( lytter );
		setSize( 600, 500 );
		setLocation(700,100);
		setVisible( true );    
	}

	private class Knappelytter implements ActionListener
	{

		public void actionPerformed( ActionEvent e )
		{
			// registerer kjøp
			if( e.getSource() == kjøp )
			{
				new Kjøp1(register);
			}
			// Viser program for kino
			else if( e.getSource() == kino )
			{
				register.skrivKinoListe(utskriftsområde);
			}
			// Viser program for teater
			else if( e.getSource() == teater )
			{
				register.skrivTeaterListe(utskriftsområde);
			}
			// Viser program for foredrag
			else if( e.getSource() == foredrag )
			{
				register.skrivForedragListe(utskriftsområde);
			}
			// viser program for konsert
			else if( e.getSource() == konsert )
			{
				register.skrivKonsertListe(utskriftsområde);
			}
			// viser lokaler til leie for møte
			else if( e.getSource() == møte)
			{
				register.skrivMøteListe(utskriftsområde);
			}
		}

	}
	//Henter inn klassen MøteReg
	public void møteReg(Register register)
	{
		new MøteReg(register);
	}


}