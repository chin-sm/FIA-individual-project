import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;

public class TicketPrice extends JFrame{
    
	//declares and initializes variables
	int pricePerTicket = 0;
	String input = null;
	int ticketNumber = 0;
	
	//creates a method to get the total amount of tickets the user wishes to purchase and its total value
    public void getTicketAmount() {
		//ensures that the user enters an integer and that it is positive
		try{
        	ticketNumber = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
        	JOptionPane.showMessageDialog(null, "Please enter a valid amount", "Error", JOptionPane.ERROR_MESSAGE);
        	return;
        }
		if (ticketNumber<=0) {
        	JOptionPane.showMessageDialog(null, "Please enter a positive number", "Error", JOptionPane.ERROR_MESSAGE);
        	return;
		} else if (ticketNumber>100) {
			JOptionPane.showMessageDialog(null, "The hall only has 100 seats", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
		    int price = ticketNumber*pricePerTicket;
		    JOptionPane.showMessageDialog(null, "You have chosen to purchase "+ticketNumber+" tickets. Your total is RM"+price+".", "Ticket Price", JOptionPane.INFORMATION_MESSAGE);
		}
	
    }
	
	//class constructor
	TicketPrice() {
		
		//sets title
		super ("FIA Cinemas");
		
		JLabel background = null;
        Image image = null;
        
        //gets image and handles exception if image cannot be extracted from the url
        try {
            URL url = new URL("https://www.thetravelmagazine.net/wp-content/uploads/film-travel.jpg");
            image = ImageIO.read(url);
        }   catch (IOException e) {
        	background = new JLabel("",null,JLabel.CENTER);
        	background.setPreferredSize(new Dimension(1280,570));
        	background.setBackground(Color.BLACK);
        	background.setOpaque(true);
        }
        
        //sets image as background 
        if (background == null) {
        	ImageIcon icon = new ImageIcon(image);
            background = new JLabel("",icon,JLabel.CENTER);
        }
        
        background.setLayout(new BorderLayout());
        add(background);
        
        JPanel topPanel = new JPanel();
		
	    //creates and adds label
		JLabel prompt = new JLabel("Enter the day of the week:");
	    prompt.setFont(prompt.getFont().deriveFont(Font.BOLD, 48));
	    prompt.setForeground(Color.WHITE);
	    prompt.setHorizontalAlignment(JLabel.CENTER);
	    topPanel.add(prompt);
        
	    //creates and adds text field
		JTextField dayField = new JTextField(9);
		dayField.setFont(dayField.getFont().deriveFont(Font.BOLD, 24));
		dayField.setForeground(Color.BLACK);
		dayField.setHorizontalAlignment(JLabel.CENTER);
		topPanel.add(dayField);
		
        //adds top panel
		topPanel.setOpaque(false);
		background.add(topPanel, BorderLayout.NORTH);
		
		//adds functionality to the text field
	    dayField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String day = dayField.getText();
				day = day.toLowerCase();
				
				//accounts for multiple spellings of each day
				switch (day) {
				case "monday":
				case "mon":
				case "tuesday":
				case "tues":
				case "tue":
				case "wednesday":
				case "wed":
					//sets the price per ticket and prompts the user to select how many they want
					pricePerTicket = 5;
					input = JOptionPane.showInputDialog(null, "One movie ticket costs RM"+pricePerTicket+".\nHow many would you like to purchase?", "Monday, Tuesday and Wednesday", JOptionPane.QUESTION_MESSAGE);
					getTicketAmount();
					break;
							
				case "thursday":
				case "thurs":
					pricePerTicket = 10;
					input = JOptionPane.showInputDialog(null, "One movie ticket costs RM"+pricePerTicket+".\nHow many would you like to purchase?", "Thursday", JOptionPane.QUESTION_MESSAGE);
					getTicketAmount();
					break;
									
				case "friday":
				case "fri":
				case "sunday":
				case "sun":
					pricePerTicket = 20;
					input = JOptionPane.showInputDialog(null, "One movie ticket costs RM"+pricePerTicket+".\nHow many would you like to purchase?", "Friday and Sunday", JOptionPane.QUESTION_MESSAGE);
					getTicketAmount();
					break;

				case "saturday":
				case "sat":
					pricePerTicket = 30;
					input = JOptionPane.showInputDialog(null, "One movie ticket costs RM"+pricePerTicket+".\nHow many would you like to purchase?", "Saturday", JOptionPane.QUESTION_MESSAGE);
					getTicketAmount();
					break;
					
				//error message if the day was not entered correctly
				default:
					JOptionPane.showMessageDialog(null, "Please ensure that you have entered the day correctly.", "Error", JOptionPane.ERROR_MESSAGE);
			    }
		    }
	    });
	    
	    //sets size
		setBounds(400,100,1000,600);
		setLayout(new FlowLayout());
	    setVisible(true);
	    setResizable(false);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    }
	
	public static void main(String[] args) throws IOException {
		new TicketPrice();
	}
}


