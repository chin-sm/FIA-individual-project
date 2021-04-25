import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieSelection extends JFrame{
    
	//declares string to be accessed in the TicketPriceAgeGroup class
	public static String movie = "";
	    
	//class constructor
	MovieSelection() {
			
	    super ("FIA Cinemas");
	    //next few lines of code create a combo box and sets default value
		String[] movies = {"Assignment Avalanche", "The Missing Curly Bracket", "How Google Saved My Life", "Flowchart Frustration"};
		JComboBox movieChoice = new JComboBox(movies);
		movieChoice.setSelectedIndex(2);
		
		//creates button and adds functionality
		JButton goButton = new JButton("Go");			
		goButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent go) {
		    	movie = (String)movieChoice.getSelectedItem();
				new TicketPriceAgeGroup();
				dispose();
		    }
		});
			
        //sets the design of the frame
		add(movieChoice);
		add(goButton);
		setBounds(400,300,300,200);
		setLayout(new FlowLayout());
		setResizable(false);
		setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MovieSelection();
	}
}

