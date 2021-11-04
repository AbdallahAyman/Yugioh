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

import eg.edu.guc.yugioh.board.player.Phase;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

public class activeMonstersArea extends JPanel implements ActionListener {
	updateGui ug;
	public activeMonstersArea(){
		
		activeHand.setG(this);
	}
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
		activeMonstersArea.gs = gs;
	}
	Player p2;
	JButton b;
	ArrayList<JButton> v;
	public activeMonstersArea(Player p22){
		p2=p22;
		buildActiveMonster();
	}
	public void buildActiveMonster(){
		setLayout(new GridLayout());
	    setBounds(500,393,700,125);
	    setOpaque(false);
	    setBackground(Color.black);
	    setBorder(new LineBorder(Color.black));
	    
	    v =new ArrayList<JButton>();
	    for(int i=0;i<p2.getField().getMonstersArea().size();i++){
	    	b=new JButton();
	    	b.setBackground(Color.black);
	    	b.setOpaque(false);
	    	b.setContentAreaFilled(false);
	    	b.setBorderPainted(true);
	    	if(!(p2.getField().getMonstersArea().get(i).getName().equals(null)||p2.getField().getMonstersArea().get(i).getName().equals(""))){

	    		if((p2.getField().getMonstersArea().get(i) instanceof MonsterCard)){
	    		if(p2.getField().getMonstersArea().get(i).isHidden()){
	    			
	    			b.setIcon(new ImageIcon(new ImageIcon(
    			    		"Cards Images Database/Card Back.png").getImage()
    			            .getScaledInstance(50,50,
    			                    java.awt.Image.SCALE_SMOOTH)));	
	    			b.addActionListener(this);
	    			v.add(b);
	    			add(b);
	    		}
	    		else{
	    			
	    			b.setIcon((new ImageIcon(new ImageIcon(
		    				"Cards Images Database/Monsters/"+p2.getField().getMonstersArea().get(i).getName()+".png").getImage()
		    	            .getScaledInstance(50,50,
		    	                    java.awt.Image.SCALE_SMOOTH))));	
	    			b.addActionListener(this);
	    			v.add(b);
	    			add(b);
	    		}
	    		}
	    }
	    }
	    updateUI();
	}
	public void resetActiveMonster(){
		v.clear();
		removeAll();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<p2.getField().getMonstersArea().size();i++){

	    	if(!(p2.getField().getMonstersArea().get(i).getName().equals(null)||p2.getField().getMonstersArea().get(i).getName().equals(""))){
	    		if(Card.getBoard().getActivePlayer()==p2){
	    		if((p2.getField().getMonstersArea().get(i) instanceof MonsterCard)){
	    			
	    				MonsterCard m =p2.getField().getMonstersArea().get(i);

	    			if(p2.getField().getPhase()==Phase.MAIN1){
	    				if(e.getSource()==v.get(i)){
	    				Object[] selectionValues = {"switch mode"};
	    			    String initialSelection = "switch mode";
	    			    String selection=(String)JOptionPane.showInputDialog(null, "please choose to switch monster or cancel",
	    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
	    			    if(selection=="switch mode"){
	    			    	p2.switchMonsterMode(m);
	    			    	gs.updateThisGui();
	    					gs.revalidate();
	    			    }
	    			}
	    			}
	    			if(p2.getField().getPhase()==Phase.BATTLE){
	    				if(e.getSource()==v.get(i)){
	    				
	    			    	if(Card.getBoard().getOpponentPlayer().getField().getMonstersArea().size()==0){
	    			    		Object[] selectionValues = {"Declare Attack"};
	    	    			    String initialSelection = "Declare Attack";
	    	    			    String selection=(String)JOptionPane.showInputDialog(null, "please choose to switch monster or cancel",
	    	    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
	    	    			    if(selection=="Declare Attack"){
	    			    		p2.declareAttack(m);
	    			    	}
	    			    	}
	    			    	else{
	    			    		String m1 ="";
	    			    		String m2 ="";
	    			    		String m3 ="";
	    			    		String m4 ="";
	    			    		String m5 ="";
	    			    		int z=Card.getBoard().getOpponentPlayer().getField().getMonstersArea().size();
	    			    		for(int j=0; j<z ;j++){
	    			    			if(Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(j)!=null){

	    	    			    		m1=Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(0).getName();
	    	    			    		if(z==1)
	    	    			    		break;
	    	    			    		m2=Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(1).getName();
	    	    			    		if(z==2)
		    	    			    	break;
	    	    			    		m3=Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(2).getName();
	    	    			    		if(z==3)
		    	    			    	break;
	    	    			    		m4=Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(3).getName();
	    	    			    		if(z==4)
		    	    			    	break;
	    	    			    		m5=Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(4).getName();
	    	    			    		if(z==5)
		    	    			    	break;
	    			    			}
	    			    		}
	    			    		Object[] selectionValue = {m1,m2,m3,m4,m5};
	    			    		String initialSelections =m1;
	    			    		String selection=(String)JOptionPane.showInputDialog(null, "Please choose which monster you want to attack",
	    		    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValue, initialSelections);
	    			    		if(selection.equals(m1)){
	    			    			p2.declareAttack(m,Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(0));
	    			    	}
	    			    		if(selection.equals(m2)){
	    			    			p2.declareAttack(m,Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(1));
	    			    	}
	    			    		if(selection.equals(m3)){
	    			    			p2.declareAttack(m,Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(2));
	    			    	}
	    			    		if(selection.equals(m4)){
	    			    			p2.declareAttack(m,Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(3));
	    			    	}
	    			    		if(selection.equals(m5)){
	    			    			p2.declareAttack(m,Card.getBoard().getOpponentPlayer().getField().getMonstersArea().get(4));
	    			    	}
	    			    		

	    			    }
	    				}
	    			}
	    			if(p2.getField().getPhase()==Phase.MAIN2){
	    				if(e.getSource()==v.get(i)){
	    				Object[] selectionValues = {"switch mode"};
	    			    String initialSelection = "switch mode";
	    			    String selection=(String)JOptionPane.showInputDialog(null, "please choose to switch monster or cancel",
	    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
	    			    if(selection=="switch mode"){

	    			}
	    				}
	    			}
	    		}
	    			}
	    		
	    	
		}
		}
		gs.updateThisGui();
		gs.revalidate();
	}
	public ArrayList<JButton> getV() {
		return v;
	}
	public void setV(ArrayList<JButton> v) {
		this.v = v;
	}
}
