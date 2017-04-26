package VideoPoker;

public interface Variation{
	// Implements the VideoPoker variation (e.g: Double Bonus 10/7)
	
	//Player player = new Player(); // Can't do it like this, an interface must only have constants
	
	//public void AssociatePlayer();
	public int[] Strategy(); // Each variation has different strategies 
	public void Rules();
	
}
