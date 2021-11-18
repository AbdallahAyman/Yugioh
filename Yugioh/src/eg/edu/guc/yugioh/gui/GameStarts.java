package eg.edu.guc.yugioh.gui;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Player;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.cards.spells.CardDestruction;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;

public class GameStarts extends JFrame {
	JLabel endGame;
	updateGui ug;
	activeSpellArea asa;
	activeMonstersArea ama;
	opponentSpellArea osa;
	opponentMonstersArea oma;
	phases p;
	opponentDeck od;
	opponentGraveyard og;
	activeGraveyard ag;
	activeDeck ad;
	activeHand ah;
	opponentHand oh;
	JLabel txt1;
	JLabel txt2;
	JLabel Background;
	JLabel player1;
	JLabel player2;
	JLabel Player1Health;
	JLabel player2Health;
	JPanel cardDescription;
	JLabel[][] l;
	activeLifePoints alp;
	opponentLifePoints olp;
	//JPanel grid;
	//StartGame startGame;
	Player p1;
	Player p2;
	public Player getP1() {
		return p1;
	}
	public void setP1(Player p1) {
		this.p1 = p1;
	}
	public Player getP2() {
		return p2;
	}
	public void setP2(Player p2) {
		this.p2 = p2;
	}
	//Card c;
	public GameStarts(Player p12, Player p22) throws NumberFormatException, IOException, UnexpectedFormatException{
		setSize(1366,768);
		setTitle("Let's Duel");
		//setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//add(new JLabel("Empty JFrame"));
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	    	setVisible(true);
	    
	    
	    	p1=p12;
	    	p2=p22;

	        player1=new JLabel("Player1:");
			player1.setBounds(0,187,180,20);
			player1.setForeground(Color.WHITE);
			player1.setFont(new Font("Courier New", Font.ITALIC, 21));
			player2=new JLabel("Player2:");
			player2.setBounds(0,580,180,20);
			player2.setForeground(Color.WHITE);
			player2.setFont(new Font("Courier New", Font.ITALIC, 21));
			

			
			txt1=new JLabel(p1.getName());
			txt1.setBounds(100,187,180,20);
			txt1.setForeground(Color.WHITE);
			txt1.setFont(new Font("Courier New", Font.ITALIC, 21));
			txt2=new JLabel(p2.getName());
			txt2.setBounds(100,580,180,20);
			txt2.setForeground(Color.WHITE);
			txt2.setFont(new Font("Courier New", Font.ITALIC, 21));
			
			Background=new JLabel();
			//Background.setBounds(0,0,1366,768);
			Background.setIcon(new ImageIcon("Background.jpg"));
			
			cardDescription=new JPanel(/*new ImageIcon(getImage())*/);
			cardDescription.setBounds(0,227,220,353);
			cardDescription.setOpaque(false);
			cardDescription.setBackground(Color.black);
			cardDescription.setBorder(new LineBorder(Color.black));
			
			
			asa=new activeSpellArea(p2);
			asa.setGs(this);
			ama=new activeMonstersArea(p2);
			ama.setGs(this);
			osa=new opponentSpellArea(p1);
			osa.setGs(this);
			oma=new opponentMonstersArea(p1);
			oma.setGs(this);
			p=new phases();
			p.setGs(this);
			od=new opponentDeck(p1);
			od.setGs(this);
			og=new opponentGraveyard(p1);
			og.setGs(this);
			ag=new activeGraveyard(p2);
			ag.setGs(this);
			ad=new activeDeck(p2);
			ad.setGs(this);
			ah=new activeHand(p2);
			ah.setGs(this);
			ag=new activeGraveyard(p2);
			ag.setGs(this);
			ah=new activeHand(p2);
			ah.setGs(this);
			oh=new opponentHand(p1);
			oh.setGs(this);
			alp=new activeLifePoints(p2);
			alp.setGs(this);
			olp=new opponentLifePoints(p1);
			olp.setGs(this);
			

			
			getContentPane().add(txt1);
			getContentPane().add(txt2);
			getContentPane().add(player1);
			getContentPane().add(player2);
			getContentPane().add(asa);
			getContentPane().add(ama);
			getContentPane().add(osa);
			getContentPane().add(p);
			getContentPane().add(od);
			getContentPane().add(og);
			getContentPane().add(ag);
			getContentPane().add(ad);
			getContentPane().add(oma);
			getContentPane().add(ah);
			getContentPane().add(oh);
			getContentPane().add(alp);
			getContentPane().add(olp);
			getContentPane().add(cardDescription);
			getContentPane().add(Background);
	}

	/*public static void main(String[] args){
		Board board = new Board();
		StartGame m = new StartGame();
		m.setExtendedState(JFrame.MAXIMIZED_BOTH);
		m.setVisible(true);
	}*/
	public void updateThisGui(){
		if(Card.getBoard().isGameOver()){
			if((p1.getLifePoints()<=0&&p2.getLifePoints()<=0)){
				endGame=new JLabel("Draw");
				JOptionPane.showMessageDialog(new JLabel(),
					    endGame,
					    "Game Over",
					    JOptionPane.INFORMATION_MESSAGE);
				Object[] selectionValued = {"Play again","Quit game"};
	    		String initialSelections ="Play again";
	    		String selection=(String)JOptionPane.showInputDialog(null, "Game Fucking over u fucker",
    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValued, initialSelections);
	    		if(selection=="Play again"){
	    			dispose();

	    			new StartGame();
	    		}
	    		else
	    			if(selection=="Quit game"){
	    				dispose();
	    			}
	    		
			}
			else
				if((p1.getLifePoints()<=0)||(Card.getBoard().getActivePlayer()==p1&&p1.getField().getDeck().getDeck().isEmpty())){
					endGame=new JLabel(p2.getName()+" wins");
					JOptionPane.showMessageDialog(new JLabel(),
						    endGame,
						    "Game Over",
						    JOptionPane.INFORMATION_MESSAGE);
					Object[] selectionValued = {"Play again","Quit game"};
		    		String initialSelections ="Play again";
		    		String selection=(String)JOptionPane.showInputDialog(null, "Game over",
	    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValued, initialSelections);
		    		if(selection=="Play again"){
		    			dispose();
		    			new StartGame();
		    		}
		    		else
		    			if(selection=="Quit game"){
		    				dispose();
		    			}
				}
				else{
					if((p2.getLifePoints()<=0)||(Card.getBoard().getActivePlayer()==p2&&p2.getField().getDeck().getDeck().isEmpty())){
						endGame=new JLabel(p1.getName()+" wins");
						JOptionPane.showMessageDialog(new JLabel(),
							    endGame,
							    "Game Over",
							    JOptionPane.INFORMATION_MESSAGE);
						Object[] selectionValued = {"Play again","Quit game"};
			    		String initialSelections ="Play again";
			    		String selection=(String)JOptionPane.showInputDialog(null, "Game over",
		    			        "Action needed", JOptionPane.QUESTION_MESSAGE, null, selectionValued, initialSelections);
			    		if(selection=="Play again"){
			    			dispose();
			    			new StartGame();
			    		}
			    		else
			    			if(selection=="Quit game"){
			    				dispose();
			    			}
				}
			}
		}

		alp.resetActiveLifePoints();
		olp.resetOpponentLifePoints();
		ad.resetActiveDeck();

		ag.resetActiveGraveyard();

		ah.resetActiveHand();

		ama.resetActiveMonster();

		asa.resetActiveSpellArea();

		od.resetOppoenentDeck();

		og.resetOpponentGraveyard();

		oh.resetOpponentHand();

		oma.resetOpponentMonstersArea();

		osa.resetActiveSpellArea();

		p.resetPhase();

		p.buildPhase();

		ad.buildActiveDeck();

		ag.buildActiveGraveyard();

		ah.buildActiveHand();

		ama.buildActiveMonster();

		asa.buildActivateSpellArea();

		od.buildOpponentDeck();

		og.buildOpponentGraveyard();

		oh.buildOpponentHand();

		oma.buildOpponentMonstersArea();

		osa.buildActivateSpellArea();
		

		alp.buildActiveLifePoints();
		olp.buildOpponentLifePoints();
		


	}
}
