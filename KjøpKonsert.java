package kulturhus;

/*
 * Klassen inneholder metoder for å kunne kjøpe billett til konsert
 * Laget av Robin Burø s236374 og Jonas Kampenhaug s236328
 * sist redigert 20.05.2015
 * Klassens hensikt er å utføre et kjøp av billett til konsert
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

public class KjøpKonsert extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton betal;
	private JTextField telefon, navn, enavn, adresse, epost, voksen, barn;
	private JComboBox<Konsert> konserter;
	Inntekt inntekt;
	Register register;

	public KjøpKonsert(Register register)
	{
		super ( "Konsertbillett" );
		this.register = register;
		//Oppretter combobox og legger til registrerte arrangementer i listen
		konserter = new JComboBox<Konsert>();
		Konsert løper = register.getFørsteKonsert();

		while(løper!=null){
			konserter.addItem(løper);
			løper = løper.neste;
		}

		konserter.setSelectedIndex(0);

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
		//Legger til input felter
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

		c.add( konserter );
		c.add( betal );

		setSize( 450, 250 );
		setVisible( true );
		//plasserer vinduet midt på skjermen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		Knappelytter lytter = new Knappelytter();
		betal.addActionListener( lytter );

	}

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
	//oppretter ny kontaktperson ved salg av konsertbillett
	public void nyPerson()
	{
		String nnavn = navn.getText();
		String eenavn= enavn.getText();
		String ttelefon = telefon.getText();
		String aadresse = adresse.getText();
		String eepost = epost.getText();
		String vvoksen = voksen.getText();
		String bbarn = barn.getText();
		String arrangement = "Kjøpte billett til Konsert: " + konserter.getSelectedItem() + " for kr " + regnUtPris();
		
		if(nnavn.length() == 0 || eenavn.length() == 0 || ttelefon.length() == 0 || eepost.length() == 0 || aadresse.length() == 0)
		{
			visMelding("Fyll ut nødvendig tekstfelt");
			return;
		}
		try
		{
			if( vvoksen.length() == 0 && bbarn.length() == 0)
			{
				visMelding("Fyll ut nødvendige felter");
				return;
			}
			else
			{
			Kontaktperson ny = new Kontaktperson(nnavn, eenavn, ttelefon, aadresse, eepost, arrangement);
			register.settInnPerson(ny);
			JOptionPane.showMessageDialog(null, "Billett til: " +  konserter.getSelectedItem() + "\nTotal Pris: " 
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
	//Regner ut prisen på ant solgte billeter ved dette salget
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
