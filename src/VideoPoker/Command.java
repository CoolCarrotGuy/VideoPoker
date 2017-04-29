package VideoPoker;

import java.util.Arrays;

public class Command {
	Type type;
	double c; // for bet or credit
	int[] h = new int[5];

	// Set the parameters of the command
	public void SetCommand(Type type, double c, int[] h) {
		this.type=type;
		this.c=c;
		this.h=h;
	}
	
	public void SetType(Type type){
		this.type=type;
	}
	
	public void SetHold(int[] hold){
		for(int i=0;i<5;i++)
			this.h[i]=hold[i];
	}

	@Override
	public String toString() {
		return "Command [type=" + type + ", c=" + c + ", h=" + Arrays.toString(h) + "]";
	}

}
