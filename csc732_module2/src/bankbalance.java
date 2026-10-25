import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class bankbalance extends JFrame implements ActionListener {
	JButton exitButton;							//Exit program
	JButton updateButton;						//Update Account Balance
	JFormattedTextField depositField;			//Number formatted Deposit field
	JFormattedTextField startingBalanceField;	//Number formatted Starting Balance field
	JFormattedTextField withdrawalField;		//Number formatted Withdrawal field
	JFrame jFrame = new JFrame();				//Main program window JFrame
	JLabel currentBalanceLabel;					//Label for Current Balance field
	JLabel depositLabel;						//Label for Deposit field
	JLabel startingBalanceLabel;				//Label for Starting Balance field
	JLabel withdrawalLabel;						//Label for Withdrawal field
	JPanel jPanel;								//JPanel creation
	JTextField currentBalanceField;				//Current Balance text field
	JTextArea outputArea;						//General text output area	
	GridBagConstraints panelConst;				//jPanel layout
	GridBagConstraints layoutConst;				//layoutConst controls individual element layout
	Double currentBalance = 0.0;				//Current account Balance, initialized to 0.0
	Double startingBalance = 0.0;				//Starting account Balance, initialized to 0.0
		
	bankbalance() {
		
		//jFrame -------------------------------------------------
		setSize(400, 300);						//Set the frame's width to 400 and height to 300 pixels
		setTitle("Bank Balance");				//Set the frame's title
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Set program to exit when the frame is closed
		
		//GridBag -----------------------------------------------
		setLayout(new GridBagLayout());			//Create GridBagLayout
		layoutConst = new GridBagConstraints();	//Create GridBagConstraints that will adjust formatting
		
		//jPanel ---------------------------------------------
		jPanel = new JPanel(new GridBagLayout());

		//jPanel layout --------------------------------------
		panelConst = new GridBagConstraints();
		panelConst.gridx = 0;
		panelConst.gridy = 0;
		add(jPanel, panelConst);
		
		//Instructions for StartingBalance -----------------------------------------
		outputArea = new JTextArea();
		outputArea.setText("Instructions: Type a starting account balance using the\n"
				+ "number format xxxx.xx and press Enter");
		outputArea.setEditable(false);
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		layoutConst.gridwidth = 2;
		layoutConst.fill = GridBagConstraints.HORIZONTAL;
		layoutConst.insets = new Insets(10,10,10,10);
		jPanel.add(outputArea, layoutConst);
				
		//StartingBlance -----------------------------------------------------------
		startingBalanceField = new JFormattedTextField(NumberFormat.getNumberInstance());	//Create a field for the starting balance
		startingBalanceField.setColumns(10);
		startingBalanceLabel = new JLabel("Starting Balance:");
		
		//Positioning for startingBalance -------------------------------------------
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		layoutConst.gridwidth = 1;
		layoutConst.fill = GridBagConstraints.NONE;
		layoutConst.insets = new Insets(10,10,10,10);
		jPanel.add(startingBalanceLabel, layoutConst);
	
		layoutConst.gridx = 1;
		layoutConst.gridy = 1;
		layoutConst.gridwidth = 1;
		layoutConst.fill = GridBagConstraints.NONE;
		layoutConst.insets = new Insets(10,10,10,10);
		jPanel.add(startingBalanceField, layoutConst);	//Add a field for startingBlanceField to the JFrame
		
		startingBalanceField.setText("0");
		
		startingBalanceField.addActionListener(this);
		
		//Instructions for Withdrawal or Deposit --------------------------------------
		outputArea = new JTextArea();
		outputArea.setText("Instructions: Enter a Withdrawal and/or Deposit amount\n"
				+ "using the number format xxxx.xx");
		outputArea.setEditable(false);
		layoutConst.gridx = 0;
		layoutConst.gridy = 2;
		layoutConst.gridwidth = 2;
		layoutConst.fill = GridBagConstraints.HORIZONTAL;
		jPanel.add(outputArea, layoutConst);
	
		//Withdrawal amount ------------------------------------------------------------
		withdrawalField = new JFormattedTextField(NumberFormat.getNumberInstance());	//Create a field for the starting balance
		withdrawalField.setColumns(10);
		withdrawalLabel = new JLabel("Withdrawal Amount:");
		
		//Positioning for withdrawalAmount ---------------------------------------------
		layoutConst.gridx = 0;
		layoutConst.gridy = 3;
		layoutConst.gridwidth = 1;
		layoutConst.fill = GridBagConstraints.NONE;
		layoutConst.insets = new Insets(10,10,10,10);
		jPanel.add(withdrawalLabel, layoutConst);
	
		layoutConst.gridx = 1;
		layoutConst.gridy = 3;
		layoutConst.gridwidth = 1;
		layoutConst.fill = GridBagConstraints.NONE;
		layoutConst.insets = new Insets(10,10,10,10);
		jPanel.add(withdrawalField, layoutConst);
		
		withdrawalField.setValue(0);
		
		//Deposit amount ---------------------------------------------------------------
		depositField = new JFormattedTextField(NumberFormat.getNumberInstance());	//Create a field for the starting balance
		depositField.setColumns(10);
		depositLabel = new JLabel("Deposit Amount:");
		
		//Positioning for depositAmount ---------------------------------------------
		layoutConst.gridx = 0;
		layoutConst.gridy = 4;
		layoutConst.gridwidth = 1;
		layoutConst.fill = GridBagConstraints.NONE;
		layoutConst.insets = new Insets(10,10,10,10);
		jPanel.add(depositLabel, layoutConst);
	
		layoutConst.gridx = 1;
		layoutConst.gridy = 4;
		layoutConst.gridwidth = 1;
		layoutConst.fill = GridBagConstraints.NONE;
		layoutConst.insets = new Insets(10,10,10,10);
		jPanel.add(depositField, layoutConst);
		
		depositField.setValue(0);
		
		//Instructions updating account -------------------------------------------------
		outputArea = new JTextArea();
		outputArea.setText("Instructions: Select button \"Update Account\" to make\n"
				+ "Withdrawal and/or Deposit amount entered.");
		outputArea.setEditable(false);
		layoutConst.gridx = 0;
		layoutConst.gridy = 5;
		layoutConst.gridwidth = 2;
		layoutConst.fill = GridBagConstraints.HORIZONTAL;
		jPanel.add(outputArea, layoutConst);			

		//Button to update account -------------------------------------------------------
		updateButton = new JButton("Update Account");
		updateButton.addActionListener(this);
		
		//Add button to panel ------------------------------------------------------------
		layoutConst.gridx = 0;
		layoutConst.gridy = 6;
		layoutConst.gridwidth = 2;
		layoutConst.fill = GridBagConstraints.NONE;
		layoutConst.insets = new Insets(10,10,10,10);
		jPanel.add(updateButton, layoutConst);
		
		//CurrentBalance -----------------------------------------------------------------
		currentBalanceField = new JTextField(10);
		currentBalanceLabel = new JLabel("Current Blance:");
	
		//Positioning for currentBlance ---------------------------------------------------
		layoutConst.gridx = 0;
		layoutConst.gridy = 7;
		layoutConst.gridwidth = 1;
		layoutConst.fill = GridBagConstraints.NONE;
		jPanel.add(currentBalanceLabel, layoutConst);
	
		layoutConst.gridx = 1;
		layoutConst.gridy = 7;
		layoutConst.gridwidth = 1;
		layoutConst.fill = GridBagConstraints.NONE;
		jPanel.add(currentBalanceField, layoutConst);
		
		//Button to update account ------------------------------------------------------
		exitButton = new JButton("Exit program");
		exitButton.addActionListener(this);
		
		//Add button to panel -----------------------------------------------------------
		layoutConst.gridx = 0;
		layoutConst.gridy = 8;
		layoutConst.gridwidth = 2;
		layoutConst.fill = GridBagConstraints.NONE;
		layoutConst.insets = new Insets(10,10,10,10);
		jPanel.add(exitButton, layoutConst);
	}
	
	//Event Handler ----------------------------------------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == updateButton) {
			//Able to update both Deposit and Withdrawal in the same action execution
			double updateAmount = 0.0;
			updateAmount = ((Number) withdrawalField.getValue()).doubleValue();
			currentBalance = currentBalance - updateAmount;
			withdrawalField.setValue(0);
			currentBalanceField.setText(Double.toString(currentBalance));

			updateAmount = ((Number) depositField.getValue()).doubleValue();
			currentBalance = currentBalance + updateAmount;
			depositField.setValue(0);
			currentBalanceField.setText(Double.toString(currentBalance));
		}
		else if (e.getSource() == exitButton) {
			System.exit(0);
		}
		else if (e.getSource() == startingBalanceField) {
			//JOptionPane.showMessageDialog(this, "Enter was pressed"); //Used for testing
			currentBalance = ((Number) startingBalanceField.getValue()).doubleValue();
			startingBalance = ((Number) startingBalanceField.getValue()).doubleValue();
			currentBalanceField.setText(Double.toString(currentBalance));
		}
	}
	
	//Main program ----------------------------------------------------------------------------------
	public static void main (String args[]) {
		
		bankbalance bankFrame = new bankbalance();
		
		bankFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Set program to exit when the frame is closed
		bankFrame.pack();											//Auto size the program to fit everything
		bankFrame.setVisible(true);									//Make the frame visible
	}
}



