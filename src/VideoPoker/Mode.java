package VideoPoker;

public abstract class Mode {
	
	Variation variation;
	protected Player player;
	protected Command command;
	
	public Mode(Variation variation, Player player) {
		this.variation=variation;
		this.player=player;
		this.command= new Command();
	}
	
	public Mode(Variation variation){
		this.variation=variation;
		this.command= new Command();
	}
	
	public void SetPlayer(Player player){
		this.player=player;
	}
	

	// Must be overriden in the type of player (subclass)
	protected abstract Command GetCommand(); // Should return an object Command please see the class "Command"
	// Cant recall now if we need more methods here:

}
