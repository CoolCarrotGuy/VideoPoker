package VideoPoker;

public class Player { // Super Class Player
	
	private double credit;
	private final double initial_credit;
    Hand hand;
	Mode mode;
	private int[] history = new int[13]; // N1, N2, ...
	
	// Constructor with no arguments - default is Interactive mode
	public Player(){
		Variation variation = new Double107();
		this.mode = new Interactive(variation, this); // Default will be Double Bonus 10/7
		this.credit=10000; // Default money
		this.initial_credit=10000;
		Deck initialDeck = new Deck(); ///////////// Player should only be constructed once (in the begining of the program)
		this.hand = new Hand(initialDeck);
	}
	// Constructor with arguments (input from the command line probably)
	public Player(double credit, Mode mode, Deck initialdeck){
		this.credit=credit;
		this.initial_credit=credit;
		this.hand = new Hand(initialdeck);
		this.mode = mode;
		
	}
	
	
	public void Setcredit(double credit){
		this.credit+=credit;
	}
	
	public double Getcredit(){
		return this.credit;
	}
	
	public boolean Bankrupt(){
		if(this.credit<=0) return true;
		else return false;
	}
	
	public int[] GetAdvice(){
		return mode.variation.Advice();
	}
	
	
	public void UpdateHistory(int wintype){ // receives the type of win the player had (0 = loss, 1=Jacks or better, ....)
		// this.history ....
		
	}
	
	
	
}
