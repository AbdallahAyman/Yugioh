package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import eg.edu.guc.yugioh.board.player.Player;

public class opponentLifePoints extends JPanel {
	GameStarts gs;
	public GameStarts getGs() {
		return gs;
	}
	public void setGs(GameStarts gs) {
		this.gs = gs;
	}
	JLabel player1Health;
	Player p1;
	public opponentLifePoints(Player p11){
		p1=p11;
		buildOpponentLifePoints();
	}
	public void buildOpponentLifePoints(){

		setLayout(new GridLayout());
		setBounds(0,207,180,20);
		setOpaque(false);
	    setBackground(Color.black);
	    setBorder(new LineBorder(Color.black));
		player1Health=new JLabel(p1.getLifePoints()+"");
		player1Health.setFont(new Font("Courier New", Font.BOLD, 21));
		player1Health.setForeground(Color.WHITE);
		add(player1Health);
		updateUI();

	}
	public void resetOpponentLifePoints(){
		removeAll();
	}
}
