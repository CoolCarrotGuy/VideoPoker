package VideoPoker;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;

public class VideoPoker_app {
	private static Text txtVideopokerDouble;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(1000, 600);
		shell.setText("VideoPoker");
		

		// Text on the top center
		txtVideopokerDouble = new Text(shell, SWT.CENTER);
		txtVideopokerDouble.setForeground(SWTResourceManager.getColor(204, 204, 204));
		txtVideopokerDouble.setEnabled(false);
		txtVideopokerDouble.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		txtVideopokerDouble.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		txtVideopokerDouble.setText("VideoPoker - Double Bonus 10/7");
		txtVideopokerDouble.setBounds(343, 10, 297, 34);
		/////////////////////////////
		
		// Images
		Label Ist_logo = new Label(shell, SWT.NONE);
		Ist_logo.setImage(new Image(display,"images/IST_Logo.png"));
		Ist_logo.setBounds(289, 0, 98, 86);
		
		Label icon = new Label(shell, SWT.NONE);
		icon.setImage(new Image(display,"images/VideoPokerLogo.png"));
		icon.setBounds(324, 61, 316, 251);
		
		Label royalFlush = new Label(shell, SWT.NONE);
		royalFlush.setImage(new Image(display,"images/royalFlush.png"));
		royalFlush.setBounds(10, 0, 199, 193);
		///////////////////////
		
		
		shell.open();
		shell.layout();
		
		Button btnNewButton = new Button(shell, SWT.BORDER | SWT.CENTER);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) { // When you click the button perform this code:
				
				//shell.close();
				Ist_logo.setVisible(false);
				icon.setVisible(false);
				royalFlush.setVisible(false);
				btnNewButton.setVisible(false);
				
				
				
				Deck initialDeck = new Deck();
				try {
					initialDeck.CreateDeck();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(initialDeck);
				

				
			}
		});

		btnNewButton.setBounds(401, 386, 166, 34);
		btnNewButton.setText("Create Deck");
		
		
		
		
		
		
		
		
		
		
		
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}
