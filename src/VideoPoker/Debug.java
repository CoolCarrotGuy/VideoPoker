package VideoPoker;

import java.io.*;

public class Debug extends Mode{
	FileReader cmd_file;
	FileReader card_file;
	public Debug(Variation variation, Player player) {
		super(variation,player);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Command GetCommand() {
		// TODO Auto-generated method stub
		return command;
	}


	


}
