import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

public class TicketPriceAgeGroup extends JFrame {
	
	//class constructor
	public TicketPriceAgeGroup() {
        super ("FIA Cinemas");
        
        JLabel background = null;
        Image image = null;
        
        //gets image and handles exception if image cannot be extracted from the url
        try {
            URL url = new URL("https://www.thetravelmagazine.net/wp-content/uploads/film-travel.jpg");
            image = ImageIO.read(url);
        } catch (IOException e) {
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

        //creates panels
        JPanel topPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        JPanel bottomPanel = new JPanel();
	    
	    //creates and adds label
		JLabel dayPrompt = new JLabel("Enter the day of the week:");
	    dayPrompt.setFont(dayPrompt.getFont().deriveFont(Font.BOLD, 48));
	    dayPrompt.setForeground(Color.WHITE);
	    dayPrompt.setHorizontalAlignment(JLabel.CENTER);
	    topPanel.add(dayPrompt);
        
	    //creates and adds text field
		JTextField dayField = new JTextField(9);
		dayField.setFont(dayField.getFont().deriveFont(Font.BOLD, 24));
		dayField.setForeground(Color.BLACK);
		dayField.setHorizontalAlignment(JLabel.CENTER);
		topPanel.add(dayField);
		
        //adds top panel
		topPanel.setOpaque(false);
		background.add(topPanel, BorderLayout.NORTH);
		
	    //creates and adds label
		JLabel agePrompt = new JLabel("Enter your age                  :");
	    agePrompt.setFont(agePrompt.getFont().deriveFont(Font.BOLD, 48));
	    agePrompt.setForeground(Color.WHITE);
	    agePrompt.setHorizontalAlignment(JLabel.CENTER);
	    agePrompt.setVerticalAlignment(JLabel.CENTER);
	    middlePanel.add(agePrompt);
        
	    //creates and adds text field
		JTextField ageField = new JTextField(9);
		ageField.setFont(ageField.getFont().deriveFont(Font.BOLD, 24));
		ageField.setForeground(Color.BLACK);
		ageField.setHorizontalAlignment(JLabel.CENTER);
		middlePanel.add(ageField);
		
		//adds middle panel
		middlePanel.setOpaque(false);
		background.add(middlePanel, BorderLayout.CENTER);
	    
		//creates and adds buttons
	    JButton priceButton = new JButton("Check Price");
	    priceButton.setFont(new Font("Arial", Font.BOLD, 20));
	    bottomPanel.add(priceButton);
	    JButton backButton = new JButton("Back");
	    backButton.setFont(new Font("Arial", Font.BOLD, 20));
	    bottomPanel.add(backButton);
	    
	    //adds bottom panel
	    bottomPanel.setOpaque(false);
	    bottomPanel.setBorder(new EmptyBorder(0, 10, 40, 10));
	    background.add(bottomPanel, BorderLayout.SOUTH);
	    
	    //adds functionality to the button
	    priceButton.addActionListener(new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		String day = dayField.getText();
	    		day = day.toLowerCase();
	    		int age = 0;
	    		//ensures that the user enters a number for their age
	    		try {
	    		    age = Integer.parseInt(ageField.getText());
	    		} catch (NumberFormatException exception) {
	    			JOptionPane.showMessageDialog(null, "Please enter a valid age", "Error", JOptionPane.ERROR_MESSAGE);
	    			return;   			
	    		}
	    		
	    		//accounts for different spelling of days
	    		switch (day) { 
	    		case "monday":
	    		case "mon":
	    		case "tuesday":
	    		case "tue":
	    		case "tues":
	    		case "wednesday":
	    		case "wed":
	    		case "thursday":
	    		case "thurs":
	    			//shows different ticket prices based on age and ensures that the user enters a valid age (not 0 or a negative number; not too old)
	    			if ((age<10 && age>0)||(age>65 && age<130)) {
	    				JOptionPane.showMessageDialog(null, "Your tickets for '"+MovieSelection.movie+"' are free", "Ticket Price", JOptionPane.INFORMATION_MESSAGE);
	    			} else if (age>=10 && age<=65) {
	    				JOptionPane.showMessageDialog(null, "One ticket for '"+MovieSelection.movie+"' costs RM10", "Ticket Price", JOptionPane.INFORMATION_MESSAGE);
	    			} else {
	    				JOptionPane.showMessageDialog(null, "Please enter a valid age", "Error", JOptionPane.ERROR_MESSAGE);
	    			}	    			
	    			break;
	    		
	    		case "friday":
	    		case "fri":
	    		case "saturday":
	    		case "sat":
	    		case "sunday":
	    		case "sun":
	    			if ((age<10 && age>0)||(age>65 && age<130))  {
	    				JOptionPane.showMessageDialog(null, "One ticket for '"+MovieSelection.movie+"' costs RM10", "Ticket Price", JOptionPane.INFORMATION_MESSAGE);
	    			} else if (age>=10 && age<=65) {
	    				JOptionPane.showMessageDialog(null, "One ticket for '"+MovieSelection.movie+"' costs RM20", "Ticket Price", JOptionPane.INFORMATION_MESSAGE);
	    			} else {
	    				JOptionPane.showMessageDialog(null, "Please enter a valid age", "Error", JOptionPane.ERROR_MESSAGE);
	    			}
	    			break;
	    		
	    		//error message if the day was not entered correctly
	    		default:
	    			JOptionPane.showMessageDialog(null, "Please ensure that you have entered the day correctly.", "Error", JOptionPane.ERROR_MESSAGE);
	    	    }
	    	}
	    });
	    
	    backButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	new MovieSelection();
		    	dispose();
		    }
		});
        
		//sets size and layout
		setBounds(200,100,1000,600);
		setLayout(new FlowLayout());
		setResizable(false);
	    setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

 