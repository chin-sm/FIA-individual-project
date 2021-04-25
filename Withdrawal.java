import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class Withdrawal extends JFrame {
	
	public static DecimalFormat twoDP = new DecimalFormat("#.00");
	
	//class constructor
	Withdrawal() {
		super("Withdrawal");
		
		//creates and formats panels, labels, text fields and buttons
		JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        
        getContentPane().add(topPanel, BorderLayout.CENTER);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
        JLabel instructions = new JLabel("Enter the amount you wish to withdraw");
        instructions.setFont(new Font("Arial", Font.BOLD, 20));
        
        JTextField amountField = new JTextField(10);
        amountField.setFont(new Font("Arial", Font.PLAIN, 20));
        
        JButton submitButton = new JButton("Submit");
        JButton backButton = new JButton("Back");
        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
		backButton.setFont(new Font("Arial", Font.BOLD, 20));
		
		//adds functionality to buttons
		submitButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        double amount = 0;
		        
		        //ensures the user enters a number for the amount
		        try{
		        	amount = Double.parseDouble(amountField.getText());
		        } catch (NumberFormatException exception) {
		        	JOptionPane.showMessageDialog(null, "Please enter a valid amount", "Error", JOptionPane.ERROR_MESSAGE);
		        	return;
		        }
		        
		        //splits amount into before and after the decimal point
		        String[] splitter = Double.toString(amount).split("\\.");  
		        int decimalLength = splitter[1].length(); 

		        //checks that the user does not enter a negative amount 
		        if (amount<=0) {
			        JOptionPane.showMessageDialog(null, "Please enter a positive amount", "Error", JOptionPane.ERROR_MESSAGE);
			    //ensures the user does not enter an amount that is more than their balance
			    } else if (amount>BalanceEnquiry.balance) {
			      	JOptionPane.showMessageDialog(null, "Insufficent balance", "Error", JOptionPane.ERROR_MESSAGE);
			    //sets a limit for transactions
			    } else if (amount>=10000) {
			    	JOptionPane.showMessageDialog(null, "Maximum amount per transaction is RM9999.99", "Error", JOptionPane.ERROR_MESSAGE);
			    //ensures the user enters a maximum of two decimal places
			    } else if (decimalLength>2) {
				    JOptionPane.showMessageDialog(null, "Please enter a maximum of two decimal places", "Error", JOptionPane.ERROR_MESSAGE);
				//subtracts from the balance and asks the user if they would like to perform another transaction
			    } else {
			       	BalanceEnquiry.balance -= amount;
			       	JOptionPane.showMessageDialog(null, "You have successfully withdrawn RM" + twoDP.format(amount), "Success", JOptionPane.INFORMATION_MESSAGE);
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
		
		//adds components
		topPanel.add(instructions);
		topPanel.add(amountField);
		bottomPanel.add(submitButton);
		bottomPanel.add(backButton);
		
		//sets background colour
		topPanel.setBackground(Color.LIGHT_GRAY);
		bottomPanel.setBackground(Color.GRAY);

		//sets size
		setBounds(300,200,400,400);
	    setVisible(true);
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
