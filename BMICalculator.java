1.	import java.util.*;  
2.	  
3.	public class BMICalculator {  
4.	      
5.	    //creates a method to get the height  
6.	    static double getHeight() {  
7.	          
8.	        //creates a scanner  
9.	        Scanner keyboard = new Scanner(System.in);  
10.	          
11.	        //prompts user to enter their height in inches  
12.	        System.out.println("BMI CALCULATOR\n\nEnter your height in inches:");  
13.	          
14.	        //ensures that the user inputs a number   
15.	        while (!keyboard.hasNextDouble()) {  
16.	            System.out.println("Please enter a valid input:");  
17.	            keyboard.next();  
18.	        }  
19.	        double heightInInches = keyboard.nextDouble();  
20.	          
21.	        //ensures that the user enters a positive number  
22.	        while (heightInInches <= 0) {  
23.	            System.out.println("Please enter a positive number:");  
24.	            try {  
25.	                heightInInches = keyboard.nextDouble();  
26.	            } catch (Exception e) {  
27.	                System.out.println("Please try again.");  
28.	                keyboard.nextLine();  
29.	            }   
30.	        }  
31.	          
32.	        //calculates the height in metres from the height in inches and rounds it off  to two decimal places  
33.	        double heightInMetres = Math.round(heightInInches*0.0254*100)/100.0;  
34.	          
35.	        return heightInMetres;    
36.	    }  
37.	      
38.	    //creates a method to get the weight  
39.	    static double getWeight() {  
40.	          
41.	        //creates a scanner  
42.	        Scanner input = new Scanner(System.in);  
43.	          
44.	        //prompts user to enter their weight in pounds  
45.	        System.out.println("Enter your weight in pounds:");  
46.	          
47.	        //ensures that the user inputs a number  
48.	        while (!input.hasNextDouble()) {  
49.	            System.out.println("Please enter a valid input:");  
50.	            input.next();  
51.	        }  
52.	        double weightInPounds = input.nextDouble();  
53.	          
54.	        //ensures that the user enters a positive number  
55.	        while (weightInPounds <= 0) {  
56.	            System.out.println("Please enter a positive number:");  
57.	            try {  
58.	                weightInPounds = input.nextDouble();  
59.	            } catch (Exception e) {  
60.	                System.out.println("Please try again.");  
61.	                input.nextLine();  
62.	            }   
63.	        }  
64.	          
65.	        //calculates the weight in kg from the weight in pounds and rounds it off to two decimal places  
66.	        double weightInKg = Math.round(weightInPounds*0.45359237*100)/100.0;  
67.	          
68.	        return weightInKg;  
69.	    }  
70.	      
71.	      
72.	    public static void main(String[] args) {  
73.	          
74.	        //declares variables  
75.	        double height = getHeight();  
76.	        double weight = getWeight();  
77.	        //calculates bmi and rounds it off to one decimal place  
78.	        double bmi = Math.round(weight/(height*height))*10/10.0;  
79.	          
80.	        //shows the user their height, weight and bmi  
81.	        System.out.println("\nYour results are in!\n\nYour height is "+height+"m.\nYour weight is "+weight+"kg.\n"+"Your BMI is "+bmi+".");  
82.	          
83.	        //tells the user their category of weight  
84.	        if (bmi<18.5) {  
85.	            System.out.println("You are underweight! Take better care of yourself.");  
86.	        } else if (bmi<=24.9) {  
87.	            System.out.println("Congratulations! You are normal.");  
88.	        } else if (bmi<=29.9) {  
89.	            System.out.println("You are overweight! Be careful!");  
90.	        } else {  
91.	            System.out.println("You are obese! Please look after your health.");  
92.	        }  
93.	    }     
94.	  
95.	}  

