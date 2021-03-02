import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean runAgain = true;
		int whichAction;
		double mean, median, stanDev;
		
		//call sort method
		Insert insert = new Insert();
		insert.sort();
		
		insert.printUnSorted();
		
		while (runAgain) {
			System.out.println();
			System.out.println();
			System.out.println("What would you like to do? Please enter:"
					+ "\n1 to add more numbers. "
					+ "\n2 to print the mean, median, mode, and standard deviation of the list. "
					+ "\n3 to print the whole list in ascending order. "
					+ "\n4 to reset the list. "
					+ "\n5 to stop the program.");
			whichAction = scn.nextInt();
			
			switch (whichAction) {
				//add more numbers
				case 1: whichAction=1; 
					insert.addNum();
					insert.sort();
					runAgain=true;
					break;
					
				//print mean, median, and mode	
				case 2: whichAction=2;
					if (insert.hasSize()) {
						mean = insert.findMean();
						System.out.println("Mean: " + mean);
						
						median = insert.findMedian();
						System.out.println("Median: " + median);
						
						insert.findMode();
						
						//EXTRA CREDIT- print standard deviation
						stanDev = insert.findStandardDeviation();
						System.out.println("Standard Deviation: " + stanDev);
					}else {
						System.out.println("There are no numbers in the list. Click 1 to add numbers.");
					}
					runAgain=true;
					break;
					
					
				//print all	
				case 3: whichAction=3;
					if(insert.hasSize()) {
						insert.printSorted();
					}else {
						System.out.println("There are no numbers in the list. Click 1 to add numbers.");
					}
					runAgain=true;
					break;
					
				//reset	
				case 4: whichAction=4;
					insert.resetList();
					runAgain=true;
					break;
					
				//end	
				case 5: whichAction=5;
					runAgain=false;
					break;
					
				//default	
				default:
					runAgain=true;
					break;
					
			}
			
		}
		
		
		
		scn.close();
		

	}

}
