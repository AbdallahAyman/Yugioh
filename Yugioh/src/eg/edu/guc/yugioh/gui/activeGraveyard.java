package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

public class activeGraveyard extends JPanel implements ActionListener {
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
		activeGraveyard.gs = gs;
	}
	JButton b;
	Player p2;
	public activeGraveyard(Player p22){
		setLayout(new GridLayout(1,5));
		p2=p22;
		buildActiveGraveyard();
	    
	    }
	public void buildActiveGraveyard(){
		setBounds(1200,393,140,125);
		setOpaque(false);
	    setBackground(Color.black);
	    setBorder(new LineBorder(Color.black));

	    b=new JButton();
	    b.setBackground(Color.black);
    	b.setOpaque(false);
    	b.setContentAreaFilled(false);
    	b.setBorderPainted(true);
	    if(!p2.getField().getGraveyard().isEmpty()){
	    	if(!(p2.getField().getGraveyard().get(p2.getField().getGraveyard().size()-1).getName().equals(null)||p2.getField().getGraveyard().get(p2.getField().getGraveyard().size()-1).getName().equals(""))){

	    		if((p2.getField().getGraveyard().get(p2.getField().getGraveyard().size()-1) instanceof MonsterCard)){
	    			b.setIcon(new ImageIcon(new ImageIcon(
		    				"Cards Images Database/Monsters/"+p2.getField().getGraveyard().get(p2.getField().getGraveyard().size()-1).getName()+".png").getImage()
		    	            .getScaledInstance(50,50,
		    	                    java.awt.Image.SCALE_SMOOTH)));
	    		add(b);
	    		}
	    	else
	    		if((p2.getField().getGraveyard().get(p2.getField().getGraveyard().size()-1) instanceof SpellCard)){
	    			b.setIcon(new ImageIcon(new ImageIcon(
		    				"Cards Images Database/Spells/"+p2.getField().getGraveyard().get(p2.getField().getGraveyard().size()-1).getName()+".png").getImage()
		    	            .getScaledInstance(50,50,
		    	                    java.awt.Image.SCALE_SMOOTH)));
	    		add(b);
	    		}
	    }

	    }
	    updateUI();
	}
	public void resetActiveGraveyard(){
		removeAll();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
