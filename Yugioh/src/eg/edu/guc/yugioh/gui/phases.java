package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import eg.edu.guc.yugioh.cards.Card;


public class phases extends JPanel implements ActionListener {
	updateGui ug;
	public updateGui getUg() {
		return ug;
	}
	public void setUg(updateGui ug) {
		this.ug = ug;
	}
	JButton endPhase;
	JButton endTurn;
	JLabel currentPhase;
	JLabel activePlayer;
	private static GameStarts gs;
	public phases(){
		buildPhase();
	
	}
	public void resetPhase(){
		removeAll();
	}
	public void buildPhase(){
    	setBounds(220,125,140,518);
	    setBackground(Color.black);
	    setOpaque(false);
	    setBackground(Color.black);
	    setBorder(new LineBorder(Color.black));
	    endPhase=new JButton("End phase");
	    endPhase.setBounds(220, 125,140,50);
	    endPhase.setBackground(Color.black);
	    endPhase.setOpaque(false);
	    endPhase.setContentAreaFilled(false);
	    endPhase.setBorderPainted(true);
	    endPhase.setForeground(Color.WHITE);
	    endPhase.addActionListener(this);
	    endTurn=new JButton("End turn");
	    endTurn.setBounds(220,250,140,150);
	    endTurn.setBackground(Color.black);
	    endTurn.setOpaque(false);
	    endTurn.setContentAreaFilled(false);
	    endTurn.setBorderPainted(true);
	    endTurn.setForeground(Color.WHITE);
	    endTurn.addActionListener(this);
	    currentPhase=new JLabel("Phase is: "+Card.getBoard().getActivePlayer().getField().getPhase());
	    currentPhase.setBounds(220,350,140,50);
	    currentPhase.setForeground(Color.WHITE);
	    activePlayer=new JLabel("Active player is: "+Card.getBoard().getActivePlayer().getName());
	    activePlayer.setBounds(220,500,140,50);
	    activePlayer.setForeground(Color.WHITE);
	    add(endPhase);
	    add(endTurn);
	    add(currentPhase);
	    add(activePlayer);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==endPhase){
			Card.getBoard().getActivePlayer().endPhase();

			gs.updateThisGui();
			gs.revalidate();
		}
		if(e.getSource()==endTurn){
			Card.getBoard().getActivePlayer().endTurn();

			gs.updateThisGui();
			gs.revalidate();
		}
		
	}
	public static GameStarts getGs() {
		return gs;
	}
	public static void setGs(GameStarts gs) {
		phases.gs = gs;
	}
}
