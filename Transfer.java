import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class Transfer extends JFrame {

	public static DecimalFormat twoDP = new DecimalFormat("#.00");
	
	//class constructor
	Transfer() {
		super ("Transfer");
		
		//creates panels and sets their locations
		JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel middlePanel = new JPanel();

        getContentPane().add(middlePanel, BorderLayout.CENTER);
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
        //creates and formats fonts of labels, text fields and buttons
        JLabel text1 = new JLabel("Transfer amount");
        text1.setFont(new Font("Arial", Font.BOLD, 20));
        
        JLabel text2 = new JLabel("Account number");
        text2.setFont(new Font("Arial", Font.BOLD, 20));
        
        JLabel instructions = new JLabel("*All account numbers are 8 digits in length");
        instructions.setFont(new Font("Arial", Font.BOLD, 14));
        
        JTextField amountField = new JTextField(10);
        amountField.setFont(new Font("Arial", Font.PLAIN, 20));
        
        JTextField accountField = new JTextField(10);
        accountField.setFont(new Font("Arial", Font.PLAIN, 20));
        
        JButton submitButton = new JButton("Submit");
        JButton backButton = new JButton("Back");
        submitButton.setFont(new Font("Arial", Font.BOLD, 20));
		backButton.setFont(new Font("Arial", Font.BOLD, 20));
		
		//adds functionality to the buttons
		submitButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        double amount = 0;
		        int account = 0;
		        
		        //ensures that the user enters a number for the amount they want to transfer
		        try{
		        	amount = Double.parseDouble(amountField.getText());
		        } catch (NumberFormatException exception) {
		        	JOptionPane.showMessageDialog(null, "Please enter a valid amount", "Error", JOptionPane.ERROR_MESSAGE);
		        	return;
		        }
		        
		        //ensures that the user enters a number for the account number they want to transfer to
		        try{
		        	account = Integer.parseInt(accountField.getText());
		        } catch (NumberFormatException ex) {
		        	JOptionPane.showMessageDialog(null, "Please enter a valid account number", "Error", JOptionPane.ERROR_MESSAGE);
		        	return;
		        }
		        
		        //splits amount into before and after the decimal point
		        String[] splitter = Double.toString(amount).split("\\.");  
		        int decimalLength = splitter[1].length(); 


		        //checks that the user enters a valid account number(8 digits in length)
		        String accountCheck = Integer.toString(account);		        
		        if (accountCheck.length()!=8) {
		        	JOptionPane.showMessageDialog(null, "Please enter a valid bank account", "Error", JOptionPane.ERROR_MESSAGE);
		        	return;		        	
		        }
		        

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
			       	JOptionPane.showMessageDialog(null, "You have successfully transferred RM" + twoDP.format(amount) + " to the account numbered " + account, "Success", JOptionPane.INFORMATION_MESSAGE);
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
		topPanel.add(text1);
		topPanel.add(amountField);
		middlePanel.add(text2);
		middlePanel.add(accountField);
		middlePanel.add(instructions);
		bottomPanel.add(submitButton);
		bottomPanel.add(backButton);
		
		//sets background colour
		topPanel.setBackground(Color.LIGHT_GRAY);
		middlePanel.setBackground(Color.LIGHT_GRAY);
		bottomPanel.setBackground(Color.GRAY);

		//sets size
		setBounds(300,200,600,400);
	    setVisible(true);
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
