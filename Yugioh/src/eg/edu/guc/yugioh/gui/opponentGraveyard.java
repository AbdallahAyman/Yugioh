package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

public class opponentGraveyard extends JPanel {
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
		opponentGraveyard.gs = gs;
	}
	Player p1;
	JButton b;
	public opponentGraveyard(Player p11){
		setLayout(new GridLayout(1,5));
		p1=p11;
	    buildOpponentGraveyard();
	    }
	public void buildOpponentGraveyard(){
		setBounds(360,250,140,125);
		setOpaque(false);
	    setBackground(Color.black);
	    setBorder(new LineBorder(Color.black));

	    b=new JButton();
	    
    	b.setOpaque(false);
    	b.setContentAreaFilled(false);
    	b.setBackground(Color.black);
    	b.setBorderPainted(true);
	    if(!p1.getField().getGraveyard().isEmpty()){
	    	if(!(p1.getField().getGraveyard().get(p1.getField().getGraveyard().size()-1).getName().equals(null)||p1.getField().getGraveyard().get(p1.getField().getGraveyard().size()-1).getName().equals(""))){

	    		if((p1.getField().getGraveyard().get(p1.getField().getGraveyard().size()-1) instanceof MonsterCard)){
	    			b.setIcon(new ImageIcon(new ImageIcon(
		    				"Cards Images Database/Monsters/"+p1.getField().getGraveyard().get(p1.getField().getGraveyard().size()-1).getName()+".png").getImage()
		    	            .getScaledInstance(50,50,
		    	                    java.awt.Image.SCALE_SMOOTH)));
	    		add(b);
	    		}
	    	else
	    		if((p1.getField().getGraveyard().get(p1.getField().getGraveyard().size()-1) instanceof SpellCard)){
	    			b.setIcon(new ImageIcon(new ImageIcon(
		    				"Cards Images Database/Spells/"+p1.getField().getGraveyard().get(p1.getField().getGraveyard().size()-1).getName()+".png").getImage()
		    	            .getScaledInstance(50,50,
		    	                    java.awt.Image.SCALE_SMOOTH)));
	    		add(b);
	    		}
	    }

	    }
	    updateUI();
	}
	public void resetOpponentGraveyard(){
		removeAll();
		
	}
}
