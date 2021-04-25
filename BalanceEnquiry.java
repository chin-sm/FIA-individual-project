import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class BalanceEnquiry extends JFrame {
	
	//declares balance in the account
	public static double balance = 2000;
	
    public static DecimalFormat twoDP = new DecimalFormat("#.00");
	
    //class constructor
	BalanceEnquiry(){
		super ("Balance Enquiry");
		
		//creates panels to hold components
		JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        
        //sets panel locations
        getContentPane().add(topPanel, BorderLayout.CENTER);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
        //declares label and formats its font
        JLabel balance = new JLabel("Your current balance is RM" + twoDP.format(BalanceEnquiry.balance));
        balance.setFont(new Font("Arial", Font.BOLD, 20));
        
        //declares button and formats its font
        JButton button = new JButton("Back");
        button.setFont(new Font("Arial", Font.BOLD, 20));
		
		//adds functionality to the button
		button.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	new ATM();
		    	dispose();
		    }
		});
		
		//adds components to the panels
		topPanel.add(balance);
		bottomPanel.add(button);
		
		//sets the background colour
		topPanel.setBackground(Color.LIGHT_GRAY);
		bottomPanel.setBackground(Color.GRAY);

		//sets the size
		setBounds(300,200,400,200);
	    setVisible(true);
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
}
