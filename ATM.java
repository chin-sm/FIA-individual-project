import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ATM extends JFrame{
	
	//class constructor
	ATM(){
		
		//gives the title "Home" to the JFrame
		super("Home");
		
		//creates panels to hold components
		JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        
        //sets panel locations
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(middlePanel, BorderLayout.CENTER);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        
        //declares labels and formats their fonts 
        JLabel welcome = new JLabel("Welcome!");
        welcome.setFont(new Font("Times New Roman", Font.BOLD,75));
        JLabel introduction = new JLabel("You are currently banking with Junebank");
        introduction.setFont(new Font("Arial", Font.BOLD,32));
        
        //creates buttons and formats their fonts
        JButton withdrawalButton, depositButton, balanceButton, transferButton, exitButton;
		withdrawalButton = new JButton("Withdrawal");
		depositButton = new JButton("Deposit");
		balanceButton = new JButton("Balance Enquiry");
		transferButton = new JButton("Transfer");
		exitButton = new JButton("Exit");
		withdrawalButton.setFont(new Font("Arial", Font.BOLD, 20));
		depositButton.setFont(new Font("Arial", Font.BOLD, 20));
		balanceButton.setFont(new Font("Arial", Font.BOLD, 20));
		transferButton.setFont(new Font("Arial", Font.BOLD, 20));
		exitButton.setFont(new Font("Arial", Font.BOLD, 20));
		
		//adds functionality to the buttons
		withdrawalButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent withdraw) {
		        new Withdrawal();
		    	dispose();
		    }
		});
		
		depositButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent withdraw) {
		        new Deposit();
		    	dispose();
		    }
		});
		
		balanceButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent withdraw) {
		        new BalanceEnquiry();
		    	dispose();
		    }
		});
		
		transferButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent withdraw) {
		        new Transfer();
		    	dispose();
		    }
		});
		
		exitButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent withdraw) {
		    	dispose();
		    }
		});
		
		//adds components to the panels
		topPanel.add(welcome);
		middlePanel.add(introduction);
		bottomPanel.add(withdrawalButton);
		bottomPanel.add(depositButton);
		bottomPanel.add(balanceButton);
		bottomPanel.add(transferButton);
		bottomPanel.add(exitButton);
		
		//sets the background colour
		topPanel.setBackground(Color.LIGHT_GRAY);
		middlePanel.setBackground(Color.LIGHT_GRAY);
		bottomPanel.setBackground(Color.GRAY);
		
		//sets the size and makes it visible
		setBounds(300,200,700,250);
		setVisible(true);
		setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new ATM();
	}

}
