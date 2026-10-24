import javax.swing.JFrame;

public class bankbalance {
	public static void main (String args[]) {
		JFrame jFrame = new JFrame();
		
		jFrame.setSize(400, 300);		//Set the frame's width to 400 and height to 300 pixels
		jFrame.setTitle("Bank Balance");	//Set the frame's title
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//Set program to exit when the frame is closed
		
		jFrame.setVisible(true);		//Make the frame visible
	}
}