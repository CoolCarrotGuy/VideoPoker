package VideoPoker;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class VP_GUI_cards {
	
	

	public static int[] Show_Card_Images(JLabel[] labels,Card[] cards, int[] hold, JPanel playVP, java.awt.Image Back){
		System.out.println("SHOW");
		//Card card1 = new Card(cards[1].getrank(),cards[1].getsuit(),cards[1].getrank(),ImageIO.read(new File("Cards/Classic/"+Rank.ACE+"_of_"+Suit.SPADES+".png")));
		//JLabel labels[0] =  new JLabel(new ImageIcon(cards[0].getImage()));
		labels[0].setIcon(new ImageIcon(cards[0].getImage()));
		labels[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(hold[0]==0){
					hold[0]=1;
					labels[0].setIcon(new ImageIcon(Back));
				}else{
					hold[0]=0;
					labels[0].setIcon(new ImageIcon(cards[0].getImage()));
				}
				System.out.println(hold[0]);
			}
		});
		
		labels[0].setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		labels[0].setBounds(45, 72, 199, 294);
		playVP.add(labels[0]);
		
		//Card card2 = new Card(Rank.TEN,Suit.DIAMONDS,10,ImageIO.read(new File("Cards/Classic/"+Rank.TEN+"_of_"+Suit.DIAMONDS+".png")));
		//JLabel labels[1] = new JLabel(new ImageIcon(cards[1].getImage()));
		labels[1].setIcon(new ImageIcon(cards[1].getImage()));
		labels[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				hold[1]=1;
			}
		});
		labels[1].setBorder(new LineBorder(new Color(0, 0, 0)));
		labels[1].setBounds(265, 72, 199, 294);
		playVP.add(labels[1]);
		
		//Card card3 = new Card(Rank.KING,Suit.DIAMONDS,13,ImageIO.read(new File("Cards/Classic/"+Rank.KING+"_of_"+Suit.DIAMONDS+".png")));
		//JLabel labels[2] = new JLabel(new ImageIcon(cards[2].getImage()));
		labels[2].setIcon(new ImageIcon(cards[2].getImage()));
		labels[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				hold[2]=1;
			}
		});
		labels[2].setBorder(new LineBorder(new Color(0, 0, 0)));
		labels[2].setBounds(490, 72, 199, 294);
		playVP.add(labels[2]);
		
		//Card card4 = new Card(Rank.THREE,Suit.HEARTS,3,ImageIO.read(new File("Cards/Classic/"+Rank.THREE+"_of_"+Suit.HEARTS+".png")));
		//JLabel labels[3] = new JLabel(new ImageIcon(cards[3].getImage()));
		labels[3].setIcon(new ImageIcon(cards[3].getImage()));
		labels[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				hold[3]=1;
			}
		});
		labels[3].setBorder(new LineBorder(new Color(0, 0, 0)));
		labels[3].setBounds(713, 72, 199, 294);
		playVP.add(labels[3]);
		
		//Card card5 = new Card(Rank.JACK,Suit.SPADES,11,ImageIO.read(new File("Cards/Classic/"+Rank.JACK+"_of_"+Suit.SPADES+".png")));
		//JLabel labels[4] = new JLabel(new ImageIcon(cards[4].getImage()));
		labels[4].setIcon(new ImageIcon(cards[4].getImage()));
		labels[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				hold[4]=1;
			}
		});
		labels[4].setBorder(new LineBorder(new Color(0, 0, 0)));
		labels[4].setBounds(942, 72, 199, 294);
		playVP.add(labels[4]);
		
		return hold;
		
	}
	
	

}
