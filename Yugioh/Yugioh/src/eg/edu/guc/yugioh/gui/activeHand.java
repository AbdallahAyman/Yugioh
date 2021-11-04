package eg.edu.guc.yugioh.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import eg.edu.guc.yugioh.board.player.Phase;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.MonsterCard;
import eg.edu.guc.yugioh.cards.spells.SpellCard;

public class activeHand extends JPanel implements ActionListener {
	updateGui ug;
	private static activeMonstersArea g;
	
	public updateGui getUg() {
		return ug;
	}
	public void setUg(updateGui ug) {
		this.ug = ug;
	}
	private static GameStarts gs;
	protected JLabel lhand;
	JButton b;
	JLabel l;
	Player p2;
	ArrayList<JButton> v;
	ArrayList<JButton> a;

	public activeHand(Player p22){
		setLayout(new GridLayout());
	    setBounds(500,643,700,125);
	    setOpaque(false);
	    setBackground(Color.black);
	    setBorder(new LineBorder(Color.black));

	    v =new ArrayList<JButton>();
	    a =new ArrayList<JButton>();
		p2=p22;
		buildActiveHand();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<v.size();i++){
			
	    		if(Card.getBoard().getActivePlayer()==p2){
	    			if(e.getSource()==v.get(i)){
	    				if((p2.getField().getHand().get(i) instanceof MonsterCard)){
	    				Object[] selectionValues = { "set", "summon"};
	    			    String initialSelection = "set";
	    			    String selection=(String)JOptionPane.showInputDialog(null, "Please select to set or activate the monster.",
	    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
	    			    ArrayList<MonsterCard> sacrifices=new ArrayList<MonsterCard>();
	    			    MonsterCard m=(MonsterCard) p2.getField().getHand().get(i);
	    			    if(m.getLevel()<5){
	    			    if(selection=="summon"){

	    					p2.summonMonster((MonsterCard)p2.getField().getHand().get(i));
	    					
	    				}
	    				else
	    					if(selection=="set"){
	    						p2.setMonster((MonsterCard)p2.getField().getHand().get(i));

	    					}
	    			    }
	    			    if(m.getLevel() == 6 || m.getLevel() == 5){
	    			    	if(selection=="summon"){
	    			      		String m1="";
	    			    		String m2="";
	    			    		String m3="";
	    			    		String m4="";
	    			    		String m5="";
	    			    		int k=Card.getBoard().getActivePlayer().getField().getMonstersArea().size();
	    			    		for(int j=0;j<k;j++){
	    			    			if(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(j)!=null){
	    			    		m1=Card.getBoard().getActivePlayer().getField().getMonstersArea().get(0).getName();
	    			    		if(k==1)
	    			    		break;	
	    			    		m2=Card.getBoard().getActivePlayer().getField().getMonstersArea().get(1).getName();
	    			    		if(k==2)
		    			    	break;	
	    			    		m3=Card.getBoard().getActivePlayer().getField().getMonstersArea().get(2).getName();
	    			    		if(k==3)
		    			    	break;	
	    			    		m4=Card.getBoard().getActivePlayer().getField().getMonstersArea().get(3).getName();
	    			    		if(k==4)
			    			    break;	
	    			    		m5=Card.getBoard().getActivePlayer().getField().getMonstersArea().get(4).getName();
	    			    		if(k==5)
	    			    		break;
	    			    		}
	    			    		}
	    			    		
	    			    		Object[] selectionValue = {m1,m2,m3,m4,m5};
	    			    		String initialSelections =m1;
	    			    		selection=(String)JOptionPane.showInputDialog(null, "Please choose the first monster you want to sacrifise",
	    		    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValue, initialSelections);
	    			    	if(selection.equals(m1)){
		    			    		sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(0));
		    			    	p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m2)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(1));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m3)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(2));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m4)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(3));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m5)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(4));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		
	    			    	}
	    			    	if(selection=="set"){     		String m1="";
    			    		String m2="";
    			    		String m3="";
    			    		String m4="";
    			    		String m5="";
    			    		int k=Card.getBoard().getActivePlayer().getField().getMonstersArea().size();
    			    		for(int j=0;j<k;j++){
    			    			if(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(j)!=null){
    			    		m1=Card.getBoard().getActivePlayer().getField().getMonstersArea().get(0).getName();
    			    		if(k==1)
    			    		break;	
    			    		m2=Card.getBoard().getActivePlayer().getField().getMonstersArea().get(1).getName();
    			    		if(k==2)
	    			    	break;	
    			    		m3=Card.getBoard().getActivePlayer().getField().getMonstersArea().get(2).getName();
    			    		if(k==3)
	    			    	break;	
    			    		m4=Card.getBoard().getActivePlayer().getField().getMonstersArea().get(3).getName();
    			    		if(k==4)
		    			    break;	
    			    		m5=Card.getBoard().getActivePlayer().getField().getMonstersArea().get(4).getName();
    			    		if(k==5)
    			    		break;
    			    		}
    			    		}
    			    		
    			    		Object[] selectionValue = {m1,m2,m3,m4,m5};
    			    		String initialSelections =m1;
    			    		selection=(String)JOptionPane.showInputDialog(null, "Please choose the first monster you want to sacrifise",
    		    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValue, initialSelections);
    			    	if(selection.equals(m1)){
	    			    		sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(0));
	    			    	p2.summonMonster(m, sacrifices);
    			    	}
    			    		if(selection.equals(m2)){
    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(1));
    			    		p2.summonMonster(m, sacrifices);
    			    	}
    			    		if(selection.equals(m3)){
    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(2));
    			    		p2.summonMonster(m, sacrifices);
    			    	}
    			    		if(selection.equals(m4)){
    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(3));
    			    		p2.summonMonster(m, sacrifices);
    			    	}
    			    		if(selection.equals(m5)){
    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(4));
    			    		p2.summonMonster(m, sacrifices);
    			    	}
	    			    		
	    		}
	    			    	
	    		}
	    			    if(m.getLevel() == 7 || m.getLevel() == 8){
	    			    	if(selection=="summon"){
	    			      		String m1="";
	    			    		String m2="";
	    			    		String m3="";
	    			    		String m4="";
	    			    		String m5="";
	    			    		int k=Card.getBoard().getActivePlayer().getField().getMonstersArea().size();
	    			    		for(int j=0;j<k;j++){
	    			    			if(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(j)!=null){
	    			    		m1=Card.getBoard().getActivePlayer().getField().getMonstersArea().get(0).getName();
	    			    		if(k==1)
	    			    		break;	
	    			    		m2=Card.getBoard().getActivePlayer().getField().getMonstersArea().get(1).getName();
	    			    		if(k==2)
		    			    	break;	
	    			    		m3=Card.getBoard().getActivePlayer().getField().getMonstersArea().get(2).getName();
	    			    		if(k==3)
		    			    	break;	
	    			    		m4=Card.getBoard().getActivePlayer().getField().getMonstersArea().get(3).getName();
	    			    		if(k==4)
			    			    break;	
	    			    		m5=Card.getBoard().getActivePlayer().getField().getMonstersArea().get(4).getName();
	    			    		if(k==5)
	    			    		break;
	    			    		}
	    			    		}
	    			    		
	    			    		Object[] selectionValue = {m1,m2,m3,m4,m5};
	    			    		String initialSelections =m1;
	    			    		selection=(String)JOptionPane.showInputDialog(null, "Please choose the first monster you want to sacrifise",
	    		    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValue, initialSelections);
	    			    		if(selection.equals(m1)){

		    			    		Object[] selectionValued = {m2,m3,m4,m5};
		    			    		initialSelections =m2;
		    			    		selection=(String)JOptionPane.showInputDialog(null, "Please choose the second monster you want to sacrifise",
		    		    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValued, initialSelections);
		    			    		 sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(0));
	    			    		if(selection.equals(m2)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(1));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m3)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(2));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m4)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(3));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m5)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(4));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		}
	    			    		else{
	    			     		if(selection.equals(m2)){

		    			    		Object[] selectionValued = {m1,m3,m4,m5};
		    			    		initialSelections =m1;
		    			    		selection=(String)JOptionPane.showInputDialog(null, "Please choose the second monster you want to sacrifise",
		    		    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValued, initialSelections);
		    			    		 sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(1));
	    			    		if(selection.equals(m1)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(0));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m3)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(2));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m4)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(3));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m5)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(4));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		}
	    			    	
	    			    		
	    			    		else{
	    			    		if(selection.equals(m3)){

		    			    		Object[] selectionValued = {m1,m2,m4,m5};
		    			    		initialSelections =m1;
		    			    		selection=(String)JOptionPane.showInputDialog(null, "Please choose the second monster you want to sacrifise",
		    		    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValued, initialSelections);
		    			    		 sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(2));
	    			    		if(selection.equals(m1)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(0));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m2)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(1));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m4)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(3));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m5)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(4));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		}
	    			    		
	    			     		
	    			    		else{
	    			    		if(selection.equals(m4)){

		    			    		Object[] selectionValued = {m1,m2,m3,m5};
		    			    		initialSelections =m1;
		    			    		selection=(String)JOptionPane.showInputDialog(null, "Please choose the second monster you want to sacrifise",
		    		    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValued, initialSelections);
		    			    		 sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(3));
	    			    		if(selection.equals(m1)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(0));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m2)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(1));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m3)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(2));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m5)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(4));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		}
	    			    		else{
	    			    		if(selection.equals(m5)){

		    			    		Object[] selectionValued = {m1,m2,m3,m5};
		    			    		initialSelections =m1;
		    			    		selection=(String)JOptionPane.showInputDialog(null, "Please choose the second monster you want to sacrifise",
		    		    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValued, initialSelections);
		    			    		 sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(4));
	    			    		if(selection.equals(m1)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(0));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m2)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(1));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m3)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(2));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m4)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(3));
	    			    		p2.summonMonster(m, sacrifices);
	    			    	}
	    			    		}
	    			    		}
	    			    		}
	    			    		}
	    			    		}
	    			    	}
	    			    	if(selection=="set"){
	    			    		String m1="";
	    			    		String m2="";
	    			    		String m3="";
	    			    		String m4="";
	    			    		String m5="";
	    			    		int k=Card.getBoard().getActivePlayer().getField().getMonstersArea().size();
	    			    		for(int j=0;j<k;j++){
	    			    			if(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(j)!=null){
	    			    		m1=Card.getBoard().getActivePlayer().getField().getMonstersArea().get(0).getName();
	    			    		if(k==1)
	    			    		break;	
	    			    		m2=Card.getBoard().getActivePlayer().getField().getMonstersArea().get(1).getName();
	    			    		if(k==2)
		    			    	break;	
	    			    		m3=Card.getBoard().getActivePlayer().getField().getMonstersArea().get(2).getName();
	    			    		if(k==3)
		    			    	break;	
	    			    		m4=Card.getBoard().getActivePlayer().getField().getMonstersArea().get(3).getName();
	    			    		if(k==4)
			    			    break;	
	    			    		m5=Card.getBoard().getActivePlayer().getField().getMonstersArea().get(4).getName();
	    			    		if(k==5)
	    			    		break;
	    			    		}
	    			    		}
	    			    		
	    			    		Object[] selectionValue = {m1,m2,m3,m4,m5};
	    			    		String initialSelections =m1;
	    			    		selection=(String)JOptionPane.showInputDialog(null, "Please choose the first monster you want to sacrifise",
	    		    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValue, initialSelections);
	    			    		if(selection.equals(m1)){

		    			    		Object[] selectionValued = {m2,m3,m4,m5};
		    			    		initialSelections =m2;
		    			    		selection=(String)JOptionPane.showInputDialog(null, "Please choose the second monster you want to sacrifise",
		    		    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValued, initialSelections);
		    			    		 sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(0));
	    			    		if(selection.equals(m2)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(1));
	    			    		p2.setMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m3)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(2));
	    			    		p2.setMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m4)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(3));
	    			    		p2.setMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m5)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(4));
	    			    		p2.setMonster(m, sacrifices);
	    			    	}
	    			    		}
	    			    		else{
	    			     		if(selection.equals(m2)){

		    			    		Object[] selectionValued = {m1,m3,m4,m5};
		    			    		initialSelections =m1;
		    			    		selection=(String)JOptionPane.showInputDialog(null, "Please choose the second monster you want to sacrifise",
		    		    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValued, initialSelections);
		    			    		 sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(1));
	    			    		if(selection.equals(m1)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(0));
	    			    		p2.setMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m3)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(2));
	    			    		p2.setMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m4)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(3));
	    			    		p2.setMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m5)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(4));
	    			    		p2.setMonster(m, sacrifices);
	    			    	}
	    			    		}
	    			    	
	    			    		
	    			    		else{
	    			    		if(selection.equals(m3)){

		    			    		Object[] selectionValued = {m1,m2,m4,m5};
		    			    		initialSelections =m1;
		    			    		selection=(String)JOptionPane.showInputDialog(null, "Please choose the second monster you want to sacrifise",
		    		    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValued, initialSelections);
		    			    		 sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(2));
	    			    		if(selection.equals(m1)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(0));
	    			    		p2.setMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m2)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(1));
	    			    		p2.setMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m4)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(3));
	    			    		p2.setMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m5)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(4));
	    			    		p2.setMonster(m, sacrifices);
	    			    	}
	    			    		}
	    			    		
	    			     		
	    			    		else{
	    			    		if(selection.equals(m4)){

		    			    		Object[] selectionValued = {m1,m2,m3,m5};
		    			    		initialSelections =m1;
		    			    		selection=(String)JOptionPane.showInputDialog(null, "Please choose the second monster you want to sacrifise",
		    		    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValued, initialSelections);
		    			    		 sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(3));
	    			    		if(selection.equals(m1)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(0));
	    			    		p2.setMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m2)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(1));
	    			    		p2.setMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m3)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(2));
	    			    		p2.setMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m5)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(4));
	    			    		p2.setMonster(m, sacrifices);
	    			    	}
	    			    		}
	    			    		else{
	    			    		if(selection.equals(m5)){

		    			    		Object[] selectionValued = {m1,m2,m3,m5};
		    			    		initialSelections =m1;
		    			    		selection=(String)JOptionPane.showInputDialog(null, "Please choose the second monster you want to sacrifise",
		    		    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValued, initialSelections);
		    			    		 sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(4));
	    			    		if(selection.equals(m1)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(0));
	    			    		p2.setMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m2)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(1));
	    			    		p2.setMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m3)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(2));
	    			    		p2.setMonster(m, sacrifices);
	    			    	}
	    			    		if(selection.equals(m4)){
	    			    			sacrifices.add(Card.getBoard().getActivePlayer().getField().getMonstersArea().get(3));
	    			    		p2.setMonster(m, sacrifices);
	    			    	}
	    			    		}
	    			    		}
	    			    		}
	    			    		}
	    			    		}
	    			    		
	    			    		}
	    			    			
	    			    
	    			    	}
		    			    }
	    				else{
	    		    		if((p2.getField().getHand().get(i) instanceof SpellCard)){
	    		    			if(e.getSource()==v.get(i)){
	    		    			Object[] selectionValuess = { "set", "activate"};
	    		    			String initialSelection = "set";
	    		    			String selection=(String)JOptionPane.showInputDialog(null, "Please select to set or activate the spell.",
	    		    		        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValuess, initialSelection);
	    		    		    if(selection=="set"){
	    		    		    	p2.setSpell((SpellCard)p2.getField().getHand().get(i));

	    		    		    }
	    		    		    
		    		    		    if(selection=="activate"){
		    		    		    	for (int j=0;j<p2.getField().getHand()
		    					    			.size();j++){
		    					    	switch (p2.getField().getHand().get(j).getName()) {
	
		    							case "Card Destruction":
		    								p2.activateSpell((SpellCard)p2.getField().getHand().get(j),null);

		    								break;

		    							case "Dark Hole":
		    								p2.activateSpell((SpellCard)p2.getField().getHand().get(j),null);

		    								break;
		    							case "Graceful Dice":
		    								p2.activateSpell((SpellCard)p2.getField().getHand().get(j),null);
		    								for(int y=0;y<Card.getBoard().getActivePlayer().getField().getMonstersArea().size();y++){
		    									g.getV().get(y).setText(""+Card.getBoard().getActivePlayer().getField().getMonstersArea().get(y).getAttackPoints()+'\n'+
		    											Card.getBoard().getActivePlayer().getField().getMonstersArea().get(y).getDefensePoints());
		    								}

		    								break;
		    							case "Harpie's Feather Duster":
		    								p2.activateSpell((SpellCard)p2.getField().getHand().get(j),null);
		    								gs.updateThisGui();
		    								gs.revalidate();
		    								break;
		    							case "Heavy Storm":
		    								p2.activateSpell((SpellCard)p2.getField().getHand().get(j),null);
		    								gs.updateThisGui();
		    								gs.revalidate();
		    								break;
		    							case "Mage Power":
		    								p2.activateSpell((SpellCard)p2.getField().getHand().get(j),null);
		    								gs.updateThisGui();
		    								gs.revalidate();
		    								break;

		    							case "Pot of Greed":
		    								p2.activateSpell((SpellCard)p2.getField().getHand().get(j),null);
;
		    								break;
		    							case "Raigeki":
		    								p2.activateSpell((SpellCard)p2.getField().getHand().get(j),null);

		    								break;
		    					    	}
		    					    }
		    					}
	    					
	    				}
	    				}
	    		    		    	
	    		    		    }
	    		    		}
	    		    		}
	    		    	}
		gs.updateThisGui();
		gs.revalidate() ;
	    			}
	
	    		
	    			

	public static GameStarts getGs() {
		return gs;
	}
	public static void setGs(GameStarts gs) {
		activeHand.gs = gs;
	}
	public void buildActiveHand(){
		

	    for(int i=0;i<p2.getField().getHand().size();i++){
	    	b=new JButton();
	    	b.setBackground(Color.black);
	    	b.setOpaque(false);
	    	b.setContentAreaFilled(false);
	    	b.setBorderPainted(true);

	    	if(!(p2.getField().getHand().get(i).getName().equals(null)||p2.getField().getHand().get(i).getName().equals(""))){
	    		if(Card.getBoard().getActivePlayer()==p2){
	    		if((p2.getField().getHand().get(i) instanceof MonsterCard)){
	    			
	    			b.setIcon((new ImageIcon(new ImageIcon(
		    				"Cards Images Database/Monsters/"+p2.getField().getHand().get(i).getName()+".png").getImage()
		    	            .getScaledInstance(50,50,
		    	                    java.awt.Image.SCALE_SMOOTH))));	
	    			b.addActionListener(this);
	    			v.add(b);
	    			add(b);
	    		}

	    	else
	    		if((p2.getField().getHand().get(i) instanceof SpellCard)){
	    			
	    		b.setIcon(new ImageIcon(new ImageIcon(
	    				"Cards Images Database/Spells/"+p2.getField().getHand().get(i).getName()+".png").getImage()
	    	            .getScaledInstance(50,50,
	    	                    java.awt.Image.SCALE_SMOOTH)));
	    		b.addActionListener(this);
	    		v.add(b);
	    		add(b);
	    		}
	    }
	    		else
	    			if(Card.getBoard().getOpponentPlayer()==p2){
	    				
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
	public void resetActiveHand(){
		v.clear();
		removeAll();
	}
	public static void setG(activeMonstersArea activeMonstersArea) {
		// TODO Auto-generated method stub
		g=activeMonstersArea;
	}
}