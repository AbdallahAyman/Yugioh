package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

public class activeSpellArea extends JPanel implements ActionListener {
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
		activeSpellArea.gs = gs;
	}
	Player p2;
	JButton b;
	ArrayList<JButton> v;
	public activeSpellArea(Player p22){
		p2=p22;
		v=new ArrayList<JButton>();
		buildActivateSpellArea();
	}
	public void buildActivateSpellArea(){

		
		setLayout(new GridLayout());
		
	    setBounds(500,518,700,125);
	    setOpaque(false);
	    setBackground(Color.black);
	    setBorder(new LineBorder(Color.black));

	    
	    v =new ArrayList<JButton>();

	    for(int i=0;i<p2.getField().getSpellArea().size();i++){
	    	b=new JButton();
	    	b.setBackground(Color.black);
	    	b.setOpaque(false);
	    	b.setContentAreaFilled(false);
	    	b.setBorderPainted(true);
	    	if(!(p2.getField().getSpellArea().get(i).getName().equals(null)||p2.getField().getSpellArea().get(i).getName().equals(""))){
	    		if((p2.getField().getSpellArea().get(i) instanceof SpellCard)){
	    			if(!p2.getField().getSpellArea().get(i).isHidden()){
	    				
	    	    		b.setIcon(new ImageIcon(new ImageIcon(
	    	    				"Cards Images Database/Spells/"+p2.getField().getSpellArea().get(i).getName()+".png").getImage()
	    	    	            .getScaledInstance(50,50,
	    	    	                    java.awt.Image.SCALE_SMOOTH)));
	    	    		b.addActionListener(this);
	    	    		v.add(b);
	    	    		add(b);
	    		}
	    		else
	    			{
	    			
    	    		b.setIcon(new ImageIcon(new ImageIcon(
    			    		"Cards Images Database/Card Back.png").getImage()
    			            .getScaledInstance(50,50,
    			                    java.awt.Image.SCALE_SMOOTH)));
    	    		b.addActionListener(this);
    	    		v.add(b);
    	    		add(b);
	    			}
	    }
	    }
	}
	    updateUI();

	}
	public void resetActiveSpellArea(){
		v.clear();
		removeAll();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
			for(int j=0;j<p2.getField().getSpellArea().size();j++){
			if(e.getSource()==b){
				Object[] selectionValues = { "Activate"};
			    String initialSelection = "Activate";
			    String selection=(String)JOptionPane.showInputDialog(null, "Please select to Activate the spell",
			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
			    if(selection=="Activate"){
			    	for (int i=0;i<p2.getField().getSpellArea()
			    			.size();i++){
			    	switch (p2.getField().getSpellArea().get(i).getName()) {

					case "Card Destruction":
						p2.activateSpell(p2.getField().getSpellArea().get(i),null);
						gs.updateThisGui();
						gs.revalidate();
						break;
					case "Change Of Heart":
						String m1 ="";
			    		String m2 ="";
			    		String m3 ="";
			    		String m4 ="";
			    		String m5 ="";
			    		int z=Card.getBoard().getOpponentPlayer().getField().getMonstersArea().size();
			    		for(int h=0; h<z ;h++){
			    			if(Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(h)!=null){

	    			    		m1="Monster 1";
	    			    		if(z==1)
	    			    		break;
	    			    		m2="Monster 2";
	    			    		if(z==2)
    	    			    	break;
	    			    		m3="Monster 3";
	    			    		if(z==3)
    	    			    	break;
	    			    		m4="Monster 4";
	    			    		if(z==4)
    	    			    	break;
	    			    		m5="Monster 5";
	    			    		if(z==5)
    	    			    	break;
			    			}
			    		}
			    		Object[] selectionValue = {m1,m2,m3,m4,m5};
			    		String initialSelections =m1;
			    		selection=(String)JOptionPane.showInputDialog(null, "Please choose which monster you want to attack",
		    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValue, initialSelections);
			    		if(selection.equals(m1)){
			    			p2.activateSpell(p2.getField().getSpellArea().get(i),
			    					Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(0));
			    	}
			    		if(selection.equals(m2)){
			    			p2.activateSpell(p2.getField().getSpellArea().get(i),
			    					Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(1));
			    	}
			    		if(selection.equals(m3)){

			    			p2.activateSpell(p2.getField().getSpellArea().get(i),
			    					Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(2));
			    	}
			    		if(selection.equals(m4)){
			    			p2.activateSpell(p2.getField().getSpellArea().get(i),
			    					Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(3));
			    	}
			    		if(selection.equals(m5)){
			    			p2.activateSpell(p2.getField().getSpellArea().get(i),
			    					Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(4));
			    	}
						gs.updateThisGui();
						gs.revalidate();
						break;
					case "Dark Hole":
						p2.activateSpell(p2.getField().getSpellArea().get(i),null);
						gs.updateThisGui();
						gs.revalidate();
						break;
					case "Graceful Dice":
						p2.activateSpell(p2.getField().getSpellArea().get(i),null);
						
						gs.updateThisGui();
						gs.revalidate();
						break;
					case "Harpie's Feather Duster":
						p2.activateSpell(p2.getField().getSpellArea().get(i),null);
						gs.updateThisGui();
						gs.revalidate();
						break;
					case "Heavy Storm":
						p2.activateSpell(p2.getField().getSpellArea().get(i),null);
						gs.updateThisGui();
						gs.revalidate();
						break;
					case "Mage Power":
						p2.activateSpell(p2.getField().getSpellArea().get(i),null);
						gs.updateThisGui();
						gs.revalidate();
						break;
					case "Monster Reborn":
						m1 ="";
			    		m2 ="";
			    		m3 ="";
			    		m4 ="";
			    		m5 ="";
			    		z=Card.getBoard().getOpponentPlayer().getField().getMonstersArea().size();
			    		for(int h=0; h<z ;h++){
			    			if(Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(h)!=null){

	    			    		m1="Monster 1";
	    			    		if(z==1)
	    			    		break;
	    			    		m2="Monster 2";
	    			    		if(z==2)
    	    			    	break;
	    			    		m3="Monster 3";
	    			    		if(z==3)
    	    			    	break;
	    			    		m4="Monster 4";
	    			    		if(z==4)
    	    			    	break;
	    			    		m5="Monster 5";
	    			    		if(z==5)
    	    			    	break;
			    			}
			    		}
			    		Object[] selectionValuee = {m1,m2,m3,m4,m5};
			    		initialSelections =m1;
			    		selection=(String)JOptionPane.showInputDialog(null, "Please choose which monster you want to Choose",
		    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValuee, initialSelections);
			    		if(selection.equals(m1)){
			    			p2.activateSpell(p2.getField().getSpellArea().get(i),
			    					Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(0));
			    	}
			    		if(selection.equals(m2)){
			    			p2.activateSpell(p2.getField().getSpellArea().get(i),
			    					Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(1));
			    	}
			    		if(selection.equals(m3)){

			    			p2.activateSpell(p2.getField().getSpellArea().get(i),
			    					Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(2));
			    	}
			    		if(selection.equals(m4)){
			    			p2.activateSpell(p2.getField().getSpellArea().get(i),
			    					Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(3));
			    	}
			    		if(selection.equals(m5)){
			    			p2.activateSpell(p2.getField().getSpellArea().get(i),
			    					Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(4));
			    	}
						p2.activateSpell(p2.getField().getSpellArea().get(i),null);
						gs.updateThisGui();
						gs.revalidate();
						break;
					case "Pot of Greed":
						p2.activateSpell(p2.getField().getSpellArea().get(i),null);
						gs.updateThisGui();
						gs.revalidate();
						break;
					case "Raigeki":
						p2.activateSpell(p2.getField().getSpellArea().get(i),null);
						gs.updateThisGui();
						gs.revalidate();
						break;
			    	}
			    }
			}
			
		}
		}
		
	}
	
}
