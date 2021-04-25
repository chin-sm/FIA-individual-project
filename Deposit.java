import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class Deposit extends JFrame{
	
	public static DecimalFormat twoDP = new DecimalFormat("#.00");
	
	//class constructor
	Deposit() {
		super("Deposit");
		
		//creates panels to hold components
		JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        
        //sets panel locations
        getContentPane().add(topPanel, BorderLayout.CENTER);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
        //declares label and formats its font
        JLabel instructions = new JLabel("Enter the amount you wish to deposit");
        instructions.setFont(new Font("Arial", Font.BOLD, 20));
        
        //declares text field and formats its font and size
        JTextField amountField = new JTextField(10);
        amountField.setFont(new Font("Arial", Font.PLAIN, 20));
        
        //declares buttons and formats their fonts and sizes
        JButton submitButton = new JButton("Submit");
        JButton backButton = new JButton("Back");
        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
		backButton.setFont(new Font("Arial", Font.BOLD, 20));
		
		//gives functionality to the buttons
		submitButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        double amount = 0;
		        
		        //ensures the user enters number
		        try{
		        	amount = Double.parseDouble(amountField.getText());
		        } catch (NumberFormatException exception) {
		        	JOptionPane.showMessageDialog(null, "Please enter a valid amount", "Error", JOptionPane.ERROR_MESSAGE);
		        	return;
		        }
		        

		        String[] splitter = Double.toString(amount).split("\\.");
		        int decimalLength = splitter[1].length();


		        //ensures that the user enters a positive number
		        if (amount<=0) {
		        	JOptionPane.showMessageDialog(null, "Please enter a valid amount", "Error", JOptionPane.ERROR_MESSAGE);
		        //sets a limit for transactions
			    } else if (amount>=10000) {
			    	JOptionPane.showMessageDialog(null, "Maximum amount per transaction is RM9999.99", "Error", JOptionPane.ERROR_MESSAGE);
		        //ensures that the user enters a maximum of two decimal places
		        } else if (decimalLength>2) {
			        JOptionPane.showMessageDialog(null, "Please enter a maximum of two decimal places", "Error", JOptionPane.ERROR_MESSAGE);
		        //adds to the balance and asks the user if they would like to perform another transaction
		        } else {
		        	BalanceEnquiry.balance += amount; 
		        	JOptionPane.showMessageDialog(null, "You have successfully deposited RM" + twoDP.format(amount), "Success", JOptionPane.INFORMATION_MESSAGE);
		        	new NewTransaction();
		        	dispose();
		        }
		    }
		});
		
		backButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	new ATM();
		    	dispose();
		    }
		});
		
		//adds components to the panels
		topPanel.add(instructions);
		topPanel.add(amountField);
		bottomPanel.add(submitButton);
		bottomPanel.add(backButton);
		
		//sets background colours
		topPanel.setBackground(Color.LIGHT_GRAY);
		bottomPanel.setBackground(Color.GRAY);

		//sets size
		setBounds(300,200,400,400);
	    setVisible(true);
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
