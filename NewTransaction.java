import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewTransaction extends JFrame{
	
	//class constructor
	NewTransaction() {
		super ("");
		
		//creates panels and sets their locations
		JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        
        getContentPane().add(topPanel, BorderLayout.CENTER);
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        
        //creates label and formats its font
        JLabel instructions = new JLabel("Would you like to perform another transaction?");
        instructions.setFont(new Font("Arial", Font.BOLD, 20));
        
        //creates buttons and formats their fonts
        JButton yesButton = new JButton("Yes");
        JButton noButton = new JButton("No");
        yesButton.setFont(new Font("Arial", Font.BOLD, 20));
		noButton.setFont(new Font("Arial", Font.BOLD, 20));
		
		//adds functionality to the buttons
		yesButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	new ATM();
		    	dispose();
		    }
		});
		
		noButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	dispose();
		    }
		});
		
		//adds components to the panels
		topPanel.add(instructions);
		bottomPanel.add(yesButton);
		bottomPanel.add(noButton);
		
		//sets background colour
		topPanel.setBackground(Color.LIGHT_GRAY);
		bottomPanel.setBackground(Color.GRAY);

		//sets size
		setBounds(300,200,600,200);
	    setVisible(true);
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
