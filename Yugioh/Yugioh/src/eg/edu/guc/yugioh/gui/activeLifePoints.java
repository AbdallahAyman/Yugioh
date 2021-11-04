package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import eg.edu.guc.yugioh.board.player.Player;

public class activeLifePoints extends JPanel {
	GameStarts gs;
	public GameStarts getGs() {
		return gs;
	}
	public void setGs(GameStarts gs) {
		this.gs = gs;
	}
	Player p2;
	JLabel player2Health;
	public activeLifePoints(Player p22){
		p2=p22;
		buildActiveLifePoints();
	}
	public void buildActiveLifePoints(){
		setLayout(new GridLayout());
		setBounds(0,600,180,20);
		setOpaque(false);
	    setBackground(Color.black);
	    setBorder(new LineBorder(Color.black));
		player2Health=new JLabel(p2.getLifePoints()+"");
		player2Health.setFont(new Font("Courier New", Font.BOLD, 21));
		player2Health.setForeground(Color.WHITE);
		add(player2Health);
		updateUI();
		
	}
	public void resetActiveLifePoints(){
		removeAll();
	}
}
