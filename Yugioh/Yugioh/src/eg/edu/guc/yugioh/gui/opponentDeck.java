package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import eg.edu.guc.yugioh.board.player.Player;

public class opponentDeck extends JPanel {
	updateGui ug;
	public updateGui getUg() {
		return ug;
	}

	public void setUg(updateGui ug) {
		this.ug = ug;
	}
	private static GameStarts gs;
	public static GameStarts getGs() {
		return gs;
	}

	public static void setGs(GameStarts gs) {
		opponentDeck.gs = gs;
	}
	Player p1;
	protected JLabel ldeck;
	JLabel l;
	public opponentDeck(Player p11){
		p1=p11;
		buildOpponentDeck();
	}
	
	public void buildOpponentDeck(){

		setBounds(360,125,140,125);
		setOpaque(false);
	    setBackground(Color.black);
	    setBorder(new LineBorder(Color.black));

	    l=new JLabel(p1.getField().getDeck().getDeck().size()+"");
	    l.setSize(20, 20);
	    l.setFont(new Font("Courier New", Font.BOLD, 21));
	    l.setForeground(Color.WHITE);
	    ldeck=new JLabel(new ImageIcon(((new ImageIcon(
	    		"Cards Images Database/Card Back.png").getImage()
	            .getScaledInstance(140, 110,
	                    java.awt.Image.SCALE_SMOOTH)))));

	    add(l);
	    add(ldeck);
	}
	public void resetOppoenentDeck(){
		removeAll();
	}
}

