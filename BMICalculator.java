import java.util.*;

public class BMICalculator {
	
	//creates a method to get the height
	static double getHeight() {
		
		//creates a scanner
        Scanner keyboard = new Scanner(System.in);
		
        //prompts user to enter their height in inches
		System.out.println("BMI CALCULATOR\n\nEnter your height in inches:");
		
		//ensures that the user inputs a number 
		while (!keyboard.hasNextDouble()) {
			System.out.println("Please enter a valid input:");
			keyboard.next();
		}
		double heightInInches = keyboard.nextDouble();
		
		//ensures that the user enters a positive number
		while (heightInInches <= 0) {
			System.out.println("Please enter a positive number:");
			try {
				heightInInches = keyboard.nextDouble();
			} catch (Exception e) {
				System.out.println("Please try again.");
				keyboard.nextLine();
			} 
		}
		
		//calculates the height in metres from the height in inches and rounds it off to two decimal places
		double heightInMetres = Math.round(heightInInches*0.0254*100)/100.0;
		
		return heightInMetres;	
	}
	
	//creates a method to get the weight
	static double getWeight() {
		
		//creates a scanner
        Scanner input = new Scanner(System.in);
		
        //prompts user to enter their weight in pounds
		System.out.println("Enter your weight in pounds:");
		
		//ensures that the user inputs a number
		while (!input.hasNextDouble()) {
			System.out.println("Please enter a valid input:");
			input.next();
		}
		double weightInPounds = input.nextDouble();
		
		//ensures that the user enters a positive number
		while (weightInPounds <= 0) {
			System.out.println("Please enter a positive number:");
			try {
				weightInPounds = input.nextDouble();
			} catch (Exception e) {
				System.out.println("Please try again.");
				input.nextLine();
			} 
		}
		
		//calculates the weight in kg from the weight in pounds and rounds it off to two decimal places
		double weightInKg = Math.round(weightInPounds*0.45359237*100)/100.0;
		
		return weightInKg;
	}
	
	
	public static void main(String[] args) {
		
		//declares variables
		double height = getHeight();
		double weight = getWeight();
		//calculates bmi and rounds it off to one decimal place
		double bmi = Math.round(weight/(height*height))*10/10.0;
		
		//shows the user their height, weight and bmi
		System.out.println("\nYour results are in!\n\nYour height is "+height+"m.\nYour weight is "+weight+"kg.\n"+"Your BMI is "+bmi+".");
		
		//tells the user their category of weight
		if (bmi<18.5) {
			System.out.println("You are underweight! Take better care of yourself.");
		} else if (bmi<=24.9) {
			System.out.println("Congratulations! You are normal.");
		} else if (bmi<=29.9) {
			System.out.println("You are overweight! Be careful!");
		} else {
			System.out.println("You are obese! Please look after your health.");
		}
	}   

}
