package kulturhus;

/*
 * Klassen inneholder metoder for å kunne kjøpe billett til foredrag
 * Laget av Robin Burø s236374 og Jonas Kampenhaug s236328
 * sist redigert 20.05.2015
 * Klassens hensikt er å utføre et kjøp av billett til foredrag
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class KjøpForedrag extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton betal;
	private JTextField telefon, navn, enavn, adresse, epost, voksen, barn;
	private JComboBox<Foredrag> foredrag;
	Register register;

	public KjøpForedrag(Register register)
	{
		super ( "Foredragbillett" );
		this.register = register;
		
		// oppretter combobox og legger til registrerte foredrag i listen
		foredrag = new JComboBox<Foredrag>();
		Foredrag løper = register.getFørsteForedrag();

		while(løper!=null){
			foredrag.addItem(løper);
			løper = løper.neste;
		}
		//^^
		foredrag.setSelectedIndex(0);
		
		betal = new JButton("Fullfør Kjøp");
		//oppretter input felter
		telefon = new JTextField(13);
		navn = new JTextField(13);
		enavn = new JTextField(13);
		adresse = new JTextField(13);
		epost = new JTextField(13);
		voksen = new JTextField(10);
		barn = new JTextField(10);

		Container c = getContentPane();
		c.setLayout( new FlowLayout() );
		c.setBackground( new Color(255, 255, 255) );
		//legger til input felter
		c.add( new JLabel ("Navn: "));
		c.add( navn );
		c.add( new JLabel ("Etternavn: "));
		c.add( enavn );
		c.add( new JLabel ("Telefon: "));
		c.add( telefon );
		c.add( new JLabel ("Adresse: "));
		c.add( adresse );
		c.add( new JLabel ("E-post: "));
		c.add( epost );
		c.add( new JLabel ("Antall Voksne: "));
		c.add( voksen );
		c.add( new JLabel ("Antall Barn: "));
		c.add( barn );     
		c.add( new JLabel ("Pris Voksne: 100 nok"));
		c.add( new JLabel ("Pris Barn: 50 nok"));

		c.add( foredrag);
		c.add( betal );
		setSize( 450, 250 );
		setVisible( true );
		//plasserer vinduet midt på skjermen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		//legger til knappelytter
		Knappelytter lytter = new Knappelytter();
		betal.addActionListener( lytter );

	}
	//Knappelytter
	private class Knappelytter implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			if( e.getSource() == betal )
			{
				nyPerson();
			}
		}
	}
	//oppretter en ny kontaktperson ved kjøp av billett
	public void nyPerson()
	{
		String nnavn = navn.getText();
		String eenavn= enavn.getText();
		String ttelefon = telefon.getText();
		String aadresse = adresse.getText();
		String eepost = epost.getText();
		String vvoksen = voksen.getText();
		String bbarn = barn.getText();
		String arrangement = "Kjøpte billett til Foredrag: " + foredrag.getSelectedItem() + " for kr "+ regnUtPris();

		if(nnavn.length() == 0 || eenavn.length() == 0 || ttelefon.length() == 0 || eepost.length() == 0 || aadresse.length() == 0)
		{
			visMelding("Fyll ut nødvendig tekstfelt");
			return;
		}
		try
		{
			//hvis det ikke er skrevet inn antall voksne eller barn får man beskjed om dette
			if( vvoksen.length() == 0 && bbarn.length() == 0)
			{
				visMelding("Fyll ut nødvendige felter");
				return;
			}
			else
			{
				Kontaktperson ny = new Kontaktperson(nnavn, eenavn, ttelefon, aadresse, eepost, arrangement);
				register.settInnPerson(ny);
				JOptionPane.showMessageDialog(null, "Billett til: " +  foredrag.getSelectedItem() + "\nTotal Pris: " 
						+ regnUtPris() + "kr\n" + "\nFaktura blir sendt til: " + epost.getText());
				Inntekt.leggTilTotal(regnUtPris());
				dispose();
			}

		}
		catch(NumberFormatException n)
		{
			visMelding("Feil med input");
		}
	}

	public void visMelding(String melding) 
	{
		JOptionPane.showMessageDialog(this, melding);
	}
	
	//regner ut prisen på billetter som blir solgt
	public int regnUtPris()
	{
		int total = 0;
		if( !voksen.getText().equals(""))
		{
			total += Integer.parseInt(voksen.getText()) * 100;
		}
		if( !barn.getText().equals(""))
		{
			total += Integer.parseInt(barn.getText()) * 50;
		}
		return total;


	}

}
