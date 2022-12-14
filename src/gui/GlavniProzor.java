package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import konzola.Igrica;
import logika.PoljaZaIgricu;
import logika.Polje;

public class GlavniProzor extends JFrame {

	private GamePanel gamePanel;
	private KontrolniPanel kontrolniPanel;
	private Igrica igrica;

	public GlavniProzor(Igrica igrica) {
		super("Seven Seas");
		this.igrica = igrica;

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		gamePanel = new GamePanel(this, igrica.dajPoljaZaIgricu());
		kontrolniPanel = new KontrolniPanel();

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 0;

		add(gamePanel, c);

		c.weightx = .2;
		c.gridx = 1;
		add(kontrolniPanel, c);

		setSize(730, 590);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public int dajTezinu() {
		return igrica.dajTezinu();
	}

	public int dajLevel() {
		return igrica.dajLevel();
	}

	public void proslijediKlik(int x, int y) {
		igrica.proslijediKlik(x, y);
	}

	public void proslijediIzmjeneMatricePolja(Polje[][] matricaPolja) {
		gamePanel.izmjeniMatricuPolja(matricaPolja);
	}

	public boolean jeLiIgracNaPotezu() {
		return igrica.jeLiIgracNaPotezu();
	}

	public void postaviIgracNaPotezu() {
		gamePanel.postaviIgracNaPotezu();
	}

}
