package VideoPoker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextPane;


import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.border.LineBorder;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VideoPokerGUI extends Mode { 

	JFrame frame;
	JPanel menu;
	JPanel playVP;
	JPanel panel_2;
	static JLabel[] labels =  new JLabel[5];
	static int[] hold = new int[5];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deck initialdeck = new Deck();
					initialdeck.CreateDeck();
					Variation variation = new Double107();
					VideoPokerGUI window = new VideoPokerGUI(variation);
					Player player = new Player(10000, window, initialdeck);
					window.SetPlayer(player);
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
	public VideoPokerGUI(Variation variation) throws IOException {
		super(variation);
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
		
		JLabel win = new JLabel("");
		win.setBounds(307, 70, 666, 380);
		playVP.add(win);
		win.setVisible(false);
		
		playVP.setVisible(false);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, "name_185084483559803");
		panel_2.setLayout(null);
		panel_2.setVisible(false);
		JButton play = new JButton("Play");
		
		play.setBounds(571, 350, 148, 53);
		menu.add(play);
		
		play.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) { // When you click the button perform this code:
				
				playVP.setVisible(true);
				menu.setVisible(false);
				
				labels[0] =  new JLabel(); labels[1] =  new JLabel(); labels[2] =  new JLabel(); labels[3] =  new JLabel(); labels[4] =  new JLabel();
				java.awt.Image Back= new ImageIcon(this.getClass().getResource("/back_card.jpg")).getImage();
				Buttons_Card_Images(player.hand.GetHand(),playVP,Back);	

				JButton draw = new JButton("Draw");
				JButton deal = new JButton("Deal");
					
				Show_cards_images(player.hand.GetHand());

				Buttons(draw, deal, win); // Check if the player clicks the buttons
				
				draw.setBounds(725, 440, 97, 25);
				playVP.add(draw);	
				deal.setBounds(725, 440, 97, 25);
				playVP.add(deal);
				deal.setVisible(false);
				
			}
		});
	}
	
	public void Buttons(JButton draw, JButton deal, JLabel win){
		draw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // Button "Draw" pressed
				
				player.hand.Hold(hold);
				System.out.println(hold[0] + " " + hold[1]+ " " + hold[2]+ " " + hold[3]+ " " + hold[4]);
				Show_cards_images(player.hand.GetHand());
				System.out.println("DRAW");
				command.SetType(Type.HOLD);
				command.SetHold(hold);
				hold[0]=0;hold[1]=0;hold[2]=0;hold[3]=0;hold[4]=0;
				int won = player.hand.CheckHand();
				System.out.println(won);
				java.awt.Image win_img= new ImageIcon(this.getClass().getResource("/win_"+Integer.toString(won)+".png")).getImage();
				win.setIcon(new ImageIcon(win_img));
				win.setVisible(true);
				draw.setVisible(false);
				deal.setVisible(true);
				
			}
		});
		deal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // Button "Deal" pressed
				System.out.println("DEAL");
				deal.setVisible(false);
				draw.setVisible(true);
				player.hand.Hand_init();
				hold[0]=0;hold[1]=0;hold[2]=0;hold[3]=0;hold[4]=0;
				command.SetType(Type.DEAL); ////////////////////////////////////////////////////////// FALTA BET
				command.SetHold(hold);
				win.setVisible(false);
				Show_cards_images(player.hand.GetHand());	
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

	@Override
	protected Command GetCommand() {
		// TODO Auto-generated method stub
		return command;
	}
}
