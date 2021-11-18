package eg.edu.guc.yugioh.gui;
import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.PageAttributes.OriginType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import eg.edu.guc.yugioh.board.Board;
import eg.edu.guc.yugioh.board.player.Player;
import eg.edu.guc.yugioh.cards.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import eg.edu.guc.yugioh.cards.Card;
import eg.edu.guc.yugioh.exceptions.UnexpectedFormatException;
public class StartGame extends JFrame implements ActionListener {
	JTextField txt1;
	JTextField txt2;
	JLabel Background;
	JLabel player1;
	JLabel player2;
	JButton StartTheGame;
	Player p1;
	Player p2;
	Scanner sc;
	String s1;
	String s2;

	public StartGame(){
		

		setSize(1366,768);
		setTitle("Yu-Gi-OH");
		//setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);

		Background=new JLabel();
		Background.setIcon(new ImageIcon("Background.jpg"));
		//Background.setBounds(0,0,1366,768);
		add(Background);
		

		Scanner sc=new Scanner(System.in);
		player1=new JLabel("Player1:");
		player1.setBounds(0,80,104,20);
		player1.setForeground(Color.WHITE);
		player1.setFont(new Font("Courier New", Font.BOLD, 21));
		player2=new JLabel("Player2:");
		player2.setBounds(0,180,104,20);
		player2.setForeground(Color.WHITE);
		player2.setFont(new Font("Courier New", Font.BOLD, 21));
		
		txt1=new JTextField();
		txt1.setBounds(105,80,180,20);
		txt2=new JTextField();
		txt2.setBounds(105,180,180,20);
		
		
		StartTheGame=new JButton("Start Game");
		StartTheGame.setBounds(570,350,300,100);
		StartTheGame.setBackground(Color.black);
		StartTheGame.setOpaque(false);
		StartTheGame.setContentAreaFilled(false);
		StartTheGame.setBorderPainted(true);
		StartTheGame.addActionListener(this);
		StartTheGame.setForeground(Color.WHITE);
		StartTheGame.setFont(new Font("Courier New", Font.BOLD, 30));
		

		getContentPane().add(txt1);
		getContentPane().add(txt2);
		getContentPane().add(player1);
		getContentPane().add(player2);
		getContentPane().add(StartTheGame);
		getContentPane().add(Background);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==StartTheGame){
			while(true){
				if(txt1.getText().equals(null)||txt1.getText().equals("")||txt1.getText().equals(" ")){
					JOptionPane.showMessageDialog(txt1,
						    "Please enter player 1 name.",
						    "Inane error",
						    JOptionPane.ERROR_MESSAGE);
					txt1.setText(sc.nextLine());
				}
				else
					break;
				}

			while(true){
			if(txt2.getText().equals(null)||txt2.getText().equals("")||txt2.getText().equals(" ")){
				JOptionPane.showMessageDialog(txt2,
					    "Please enter player 2 name.",
					    "Inane error",
					    JOptionPane.ERROR_MESSAGE);
				txt1.setText(sc.nextLine());
			}
			else
				break;
			}

			s1 = txt1.getText();
			s2 = txt2.getText();
			try {
				p1=new Player(s1);
			} catch (NumberFormatException | IOException
					| UnexpectedFormatException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				p2=new Player(s2);
			} catch (NumberFormatException | IOException
					| UnexpectedFormatException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			dispose();
			Card.getBoard().whoStarts(p1,p2);
			Card.getBoard().startGame(p1,p2);
            try {
				new GameStarts(p1,p2);
			} catch (NumberFormatException | IOException
					| UnexpectedFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
		}
	}
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
	public static void main(String[] args){
		Board board = new Board();
		StartGame m = new StartGame();
		m.setExtendedState(JFrame.MAXIMIZED_BOTH);
		m.setVisible(true);
		
	}
}
