package VideoPoker;

import java.io.*;
public class Main {
			
	 public static double convToDouble(String string){
		 double converted=(double) 0;
		try{
	        converted= Double.parseDouble(string);
	    }catch(NumberFormatException e){
	        System.out.println("Credit must be a number");
	        System.exit(-1);
	    }
		return converted;
	}
	
	public static FileReader fileOpener(String string ) {
		FileReader f=null;
		try{
			f= new FileReader(string);
		}catch(FileNotFoundException e){
			System.out.println("File "+ string+ " does not exist in " + System.getProperty("user.dir") );
			System.exit(-1);
		}		
		return f;
	}
	
	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*Deck initialdeck = new Deck();
		initialdeck.CreateDeck();
		Variation variation = new Double107();
		VideoPokerGUI window = new VideoPokerGUI(variation);
		Player player = new Player(10000, window, initialdeck);
		window.SetPlayer(player);
		window.frame.setVisible(true);
		
		while(true){
			
			System.out.println(window.GetCommand());
		}
		*/
		int arg_nb=args.length;
		if( arg_nb  < 2){
			System.out.println("Missing mode type or mode arguments");
			System.exit(-1);
		}
		for (int i = 0; i < arg_nb; i++) {
			System.out.println(args[i]);
		}
		
		//Escolhe os diferentes modos
		switch (args[0]) {
		case "-i"://Interactive mode
			if(arg_nb > 2){
				System.out.println("Too much arguments for Interactive Mode");
				System.exit(-1);
			}else{
				double credit= convToDouble(args[1]);
				System.out.println("Interactive mode and credit=" + credit);
			}
			break;
		case "-d"://Debug mode
			
			if(arg_nb<3){
				System.out.println("Missing arguments for Debug Mode");
				System.exit(-1);
			}
			if(arg_nb>3){
				System.out.println("Too much arguments for Debug Mode");
				System.exit(-1);
			}
			FileReader cmd_file=fileOpener(args[1]);
			FileReader card_file=fileOpener(args[2]);
		
			System.out.println("Debug mode with " +args[1] + " and " + args[2]);
			break;
		case "-s"://Simulation mode
			if(arg_nb<4){
				System.out.println("Missing arguments for Sim Mode");
				System.exit(-1);
			}
			if(arg_nb>4){
				System.out.println("Too much arguments for Sim Mode");
				System.exit(-1);
			}
			double credit= convToDouble(args[1]);
			double bet=convToDouble(args[2]);
			int nbdeals = (int) ((long) convToDouble(args[3])); // only integer part is catched
			
			break;
		default:
			System.out.println("Invalid Mode");
			System.exit(-1);
			break;
		}
		

	}

}
