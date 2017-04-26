package VideoPoker;

public abstract class Player { // Super Class Player
	
	private double credit;
	private final double initial_credit;
	private Hand hand;
	private Variation variation;
	private int[] history = new int[13]; // N1, N2, ...
	
	// Constructor with no arguments
	public Player(){
		this.variation = new Double107(); // Default will be Double Bonus 10/7
		this.credit=10000; // Default money
		this.initial_credit=10000;
		Deck initialDeck = new Deck(); ///////////// Player should only be constructed once (in the beggining of the program)
		this.hand = new Hand(initialDeck);
	}
	// Constructor with arguments (input from the command line probably)
	public Player(double credit, Variation variation){
		this.credit=credit;
		this.initial_credit=credit;
		Deck initialDeck = new Deck();
		this.hand = new Hand(initialDeck);
		this.variation = variation;
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
	
	public int[] GetStrategy(){
		return variation.Strategy();
	}
	
	public void UpdateHistory(int wintype){ // receives the type of win the player had (0 = loss, 1=Jacks or better, ....)
		// this.history ....
		
	}
	
	// Must be overriden in the type of player (subclass)
	protected abstract void Play();
	
	protected abstract void Bet();
	
	
	
}
