package VideoPoker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextPane;


import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.border.LineBorder;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VideoPokerGUI { ////////////////////////////////////////////////////// MUST EXTEND PLAYER - NOT YET DONE

	private JFrame frame;
	private JPanel menu;
	private JPanel playVP;
	private JPanel panel_2;
//	private JLabel firstCard;
//	private JLabel secondCard;
//	private JLabel thirdCard;
//	private JLabel fourthCard;
//	private JLabel fifthCard;
	private static JLabel[] labels =  new JLabel[5];
	
	private static int[] hold = new int[5];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VideoPokerGUI window = new VideoPokerGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public VideoPokerGUI() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel menu = new JPanel();
		frame.getContentPane().add(menu, "name_185068142488356");
		menu.setLayout(null);
		menu.setVisible(true);
		
		

		
		
		JTextPane txtpnVideopokerDouble = new JTextPane();
		txtpnVideopokerDouble.setEditable(false);
		txtpnVideopokerDouble.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnVideopokerDouble.setText("VideoPoker - Double Bonus 10/7");
		txtpnVideopokerDouble.setOpaque(false);
		txtpnVideopokerDouble.setBackground(new Color(255, 255, 255));
		txtpnVideopokerDouble.setBounds(500, 11, 304, 36);
		menu.add(txtpnVideopokerDouble);
		
		JLabel Ist_logo = new JLabel("");
		java.awt.Image istimg= new ImageIcon(this.getClass().getResource("/IST_Logo.png")).getImage();
		Ist_logo.setIcon(new ImageIcon(istimg));
		Ist_logo.setBounds(449, 0, 102, 76);
		menu.add(Ist_logo);
		
		JLabel VPicon = new JLabel("");
		VPicon.setAlignmentX(Component.CENTER_ALIGNMENT);
		java.awt.Image VPimg= new ImageIcon(this.getClass().getResource("/VideoPokerLogo.png")).getImage();
		VPicon.setIcon(new ImageIcon(VPimg));
		VPicon.setBounds(481, 95, 304, 244);
		menu.add(VPicon);
		
		JLabel royalFlush = new JLabel("");
		java.awt.Image royalFlushimg= new ImageIcon(this.getClass().getResource("/royalFlush.png")).getImage();
		royalFlush.setIcon(new ImageIcon(royalFlushimg));
		royalFlush.setBounds(50, 0, 244, 194);
		menu.add(royalFlush);
		
		
		
		
		
		
		
		JPanel playVP = new JPanel();
		frame.getContentPane().add(playVP, "name_185082970028280");
		playVP.setLayout(null);
		
		
		

		/*
		Card card1 = new Card(Rank.ACE,Suit.SPADES,14,ImageIO.read(new File("Cards/Classic/"+Rank.ACE+"_of_"+Suit.SPADES+".png")));
		JLabel firstCard =  new JLabel(new ImageIcon(card1.getImage()));
		firstCard.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		firstCard.setBounds(45, 72, 199, 294);
		playVP.add(firstCard);
		
		Card card2 = new Card(Rank.TEN,Suit.DIAMONDS,10,ImageIO.read(new File("Cards/Classic/"+Rank.TEN+"_of_"+Suit.DIAMONDS+".png")));
		JLabel secondCard = new JLabel(new ImageIcon(card2.getImage()));
		secondCard.setBorder(new LineBorder(new Color(0, 0, 0)));
		secondCard.setBounds(265, 72, 199, 294);
		playVP.add(secondCard);
		
		Card card3 = new Card(Rank.KING,Suit.DIAMONDS,13,ImageIO.read(new File("Cards/Classic/"+Rank.KING+"_of_"+Suit.DIAMONDS+".png")));
		JLabel thirdCard = new JLabel(new ImageIcon(card3.getImage()));
		thirdCard.setBorder(new LineBorder(new Color(0, 0, 0)));
		thirdCard.setBounds(490, 72, 199, 294);
		playVP.add(thirdCard);
		
		Card card4 = new Card(Rank.THREE,Suit.HEARTS,3,ImageIO.read(new File("Cards/Classic/"+Rank.THREE+"_of_"+Suit.HEARTS+".png")));
		JLabel fourthCard = new JLabel(new ImageIcon(card4.getImage()));
		fourthCard.setBorder(new LineBorder(new Color(0, 0, 0)));
		fourthCard.setBounds(713, 72, 199, 294);
		playVP.add(fourthCard);
		
		Card card5 = new Card(Rank.JACK,Suit.SPADES,11,ImageIO.read(new File("Cards/Classic/"+Rank.JACK+"_of_"+Suit.SPADES+".png")));
		JLabel fifthCard = new JLabel(new ImageIcon(card5.getImage()));
		fifthCard.setBorder(new LineBorder(new Color(0, 0, 0)));
		fifthCard.setBounds(942, 72, 199, 294);
		playVP.add(fifthCard);
		*/
		
		
		playVP.setVisible(false);
		
		
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, "name_185084483559803");
		panel_2.setLayout(null);
		panel_2.setVisible(false);
		

		JButton btnNewButton = new JButton("Create Deck");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(571, 350, 148, 53);
		menu.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) { // When you click the button perform this code:
				
				playVP.setVisible(true);
				menu.setVisible(false);
				
				Deck initialDeck = new Deck();
				try {
					initialDeck.CreateDeck();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//System.out.println(initialDeck);
				
				
				Hand hand = new Hand(initialDeck);
				//hand.Hand_init(initialDeck);
				
				labels[0] =  new JLabel(); labels[1] =  new JLabel(); labels[2] =  new JLabel(); labels[3] =  new JLabel(); labels[4] =  new JLabel();
				java.awt.Image Back= new ImageIcon(this.getClass().getResource("/back_card.jpg")).getImage();
				Buttons_Card_Images(hand.GetHand(),playVP,Back);	

					JButton draw = new JButton("Draw");
					JButton deal = new JButton("Deal");
					
					Show_cards_images(hand.GetHand());
					
					draw.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) { // Button "Draw" pressed
							
							//Show_Card_Images(labels,hand.GetHand(),playVP,Back); //////////////////// NOT EFFICIENT
							//System.out.println("BEFORE"+hand);
							hand.Hold(hold);
							//System.out.println("AFTER"+hand);
							System.out.println(hold[0] + " " + hold[1]+ " " + hold[2]+ " " + hold[3]+ " " + hold[4]);
							//Show_Card_Images(labels,hand.GetHand(),playVP,Back);	
							Show_cards_images(hand.GetHand());
							System.out.println("DRAW");
							hold[0]=0;hold[1]=0;hold[2]=0;hold[3]=0;hold[4]=0;
							System.out.println(hand.CheckHand());
							draw.setVisible(false);
							deal.setVisible(true);
						
						}
					});
					draw.setBounds(725, 440, 97, 25);
					playVP.add(draw);
					
					
					deal.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) { // Button "Deal" pressed
							System.out.println("DEAL");
							deal.setVisible(false);
							draw.setVisible(true);
							hand.Hand_init(initialDeck);
							hold[0]=0;hold[1]=0;hold[2]=0;hold[3]=0;hold[4]=0;
							//Show_Card_Images(labels,hand.GetHand(),playVP,Back);
							Show_cards_images(hand.GetHand());
							
						}
					});
					deal.setBounds(725, 440, 97, 25);
					playVP.add(deal);
					deal.setVisible(false);
			
					
				
				
			}
		});
		
		
	}
	
	// Update the images of the cards
	public static void Show_cards_images(Card[] cards){
		labels[0].setIcon(new ImageIcon(cards[0].getImage()));
		labels[1].setIcon(new ImageIcon(cards[1].getImage()));
		labels[2].setIcon(new ImageIcon(cards[2].getImage()));
		labels[3].setIcon(new ImageIcon(cards[3].getImage()));
		labels[4].setIcon(new ImageIcon(cards[4].getImage()));
	}
	
	
	
	
	
	
	public static void Buttons_Card_Images(Card[] cards, JPanel playVP, java.awt.Image Back){
		//System.out.println("SHOW");
		labels[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//System.out.println("Pressed");
				if(hold[0]==0){
					hold[0]=1;
					labels[0].setIcon(new ImageIcon(Back));
				}else{
					hold[0]=0;
					labels[0].setIcon(new ImageIcon(cards[0].getImage()));
				}
				//System.out.println(hold[0]);
			}
		});
		labels[0].setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		labels[0].setBounds(45, 72, 199, 294);
		playVP.add(labels[0]);
		

		labels[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(hold[1]==0){
					hold[1]=1;
					labels[1].setIcon(new ImageIcon(Back));
				}else{
					hold[1]=0;
					labels[1].setIcon(new ImageIcon(cards[1].getImage()));
				}
			}
		});
		labels[1].setBorder(new LineBorder(new Color(0, 0, 0)));
		labels[1].setBounds(265, 72, 199, 294);
		playVP.add(labels[1]);
		

		labels[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(hold[2]==0){
					hold[2]=1;
					labels[2].setIcon(new ImageIcon(Back));
				}else{
					hold[2]=0;
					labels[2].setIcon(new ImageIcon(cards[2].getImage()));
				}
			}
		});
		labels[2].setBorder(new LineBorder(new Color(0, 0, 0)));
		labels[2].setBounds(490, 72, 199, 294);
		playVP.add(labels[2]);
		
		labels[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(hold[3]==0){
					hold[3]=1;
					labels[3].setIcon(new ImageIcon(Back));
				}else{
					hold[3]=0;
					labels[3].setIcon(new ImageIcon(cards[3].getImage()));
				}
			}
		});
		labels[3].setBorder(new LineBorder(new Color(0, 0, 0)));
		labels[3].setBounds(713, 72, 199, 294);
		playVP.add(labels[3]);
		

		labels[4].addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(hold[4]==0){
					hold[4]=1;
					labels[4].setIcon(new ImageIcon(Back));
				}else{
					hold[4]=0;
					labels[4].setIcon(new ImageIcon(cards[4].getImage()));
				}
			}
		});
		labels[4].setBorder(new LineBorder(new Color(0, 0, 0)));
		labels[4].setBounds(942, 72, 199, 294);
		playVP.add(labels[4]);
		
	
	}
}
