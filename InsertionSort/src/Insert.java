import java.util.Scanner;

public class Insert {

	//instance variables
	Scanner scn = new Scanner(System.in);
	private int[] sortedList = new int[26];
	private int[] unSortedList = new int[26];
	private int size;
	public double mean, median, stanDev;
	public int mode;
	
	
	//constructor
	public Insert() {
		this.initialList();
		
	}
	
	//set up list
	private void initialList() {
		int index=0, num;
		String numEnter1, numEnter, numSub;
		int digitCount=0, firstIndex=0;
		
		//EXTRA CREDIT- input list as a string
		System.out.println("Please enter a list of integers, no more than 25."
				+ "\nPlease enter in this format #,#,# with no spaces around commas.");
			
				System.out.println("Enter string here: ");
				numEnter1 = scn.nextLine();
				numEnter = numEnter1 + ",";
				
				for (int i=0; i<numEnter.length(); i++) {
					if (index <= 25) {
					
						try {
							//need to make negatives be possible
							if (numEnter.charAt(i) == '1' || numEnter.charAt(i) == '2' || numEnter.charAt(i) == '3' 
									|| numEnter.charAt(i) == '4' || numEnter.charAt(i) == '5' || numEnter.charAt(i) == '6' 
									|| numEnter.charAt(i) == '7' || numEnter.charAt(i) == '8' || numEnter.charAt(i) == '9' 
									|| numEnter.charAt(i) == '0' || numEnter.charAt(i) == '-') {
									
									if (digitCount==0) {
										firstIndex=i;
									}
									
									digitCount++;
								}
						
								if (numEnter.charAt(i)==',') {
									if (numEnter.charAt(i-1)=='-') {
										numSub = numEnter.substring(firstIndex, i);
										num = Integer.valueOf(numSub);
										num = num*-1;
										unSortedList[index] = num;
										index++;
									}else {
										numSub = numEnter.substring(firstIndex, i);
										num = Integer.valueOf(numSub);
										unSortedList[index] = num;
										index++;
									}
								digitCount=0;
								firstIndex=0;
							}
							
							
							
						}catch (IndexOutOfBoundsException e) {
							numSub = numEnter.substring(firstIndex,i-1);
							num = Integer.valueOf(numSub);
							unSortedList[index] = num;
							index++;
							
						}catch (java.lang.NumberFormatException e) {
							System.out.println("Please only enter in the specified format.");
						}
					}
				
				}

		size = index;
	}
	
	
	//sorts numList into sorted list from least to greatest
	public void sort() {
		int temp;
		
		//copy unSorted
		for (int i=0; i<size; i++) {
			sortedList[i] = unSortedList[i];
		}
		
		//sort
		for (int i=1; i<size; i++) {
			temp = sortedList[i];
			
			int j = i-1;
			while ((j>-1) && (sortedList[j] > temp)) {
				sortedList [j+1] = sortedList[j];
				j--;
			}
			
			sortedList[j+1] = temp;
		}
	
	}
	
	//adds more numbers to unsorted list
	public void addNum() {
		boolean userStop=false;
		int num;
		String runAgain;
		
		if (size<25) {
			
			try {
				while (!userStop && size<25) {
					System.out.println("Please enter a number.");
					num=scn.nextInt();
					unSortedList[size] = num;
					size++;
					
					scn=new Scanner(System.in);
					System.out.println("Would you like to continue entering numbers? Type yes or no in lowercase letters.");
					runAgain = scn.nextLine();
					
					if (runAgain.equals("yes")) {
						userStop = false;
					}else if (runAgain.equals("no")) {
						userStop = true;
					}else {
						System.out.println("That is not an option. Program will not continue entering numbers.");
						userStop = true;
					}
				}//end of while
			}catch (java.util.InputMismatchException e) {
				System.out.println("Please only enter integers.");
			}
			
			if (size==25) {
				System.out.println("You have entered the maximum amount of numbers in the list (25).");
			
			}
			
		}else {
			System.out.println("Sorry, there are too many numbers in the list.");
		}
	}
	
	
	//calculate mean
	public double findMean() {
		double total=0;
		double sortedListDouble;
		
		for (int i=0; i<size; i++) {
			sortedListDouble = (double) sortedList[i];
			total = total + sortedListDouble;
		}
			
		mean = total / size;
		
		
			
		return mean;
	}
	
	
	//calculate median
	public double findMedian() {
		
		
		if (size%2 !=0) {
			median = sortedList[size/2];
						
		}else {
			int index1, index2;
			index1 = (size/2)-1;
			index2 = index1 + 1;
			median = ((double)sortedList[index1] + (double)sortedList[index2]) / 2;
		}
		
		
		return median;
	}
	
	
	//calculate mode and print
	public void findMode() {
		int current, count, most, currentNum;
		int [] countArr = new int [size];
		System.out.print("Mode: ");
		
		//add number of occurrences of each number to parallel array countArr
		for (int i=0; i<size; i++) {
			
			current = sortedList[i];
			count=0;
			
			for (int j=0; j<size; j++) {
				if (current == sortedList[j]) {
					count++;
				}
			}
			
			countArr[i] = count;
		}
		
		//figure out what the largest number in countArr is 
		most = 1;
		for (int i=0; i<size; i++) {
			if (countArr[i] > most) {
				most = countArr[i];
			}
		}
		
		//print numbers that have the most as their number in countArr
		if (most!=1) {
			for (int i=0; i<size; i++) {
				if (countArr[i] == most) {
					System.out.print(sortedList[i] + " ");
					currentNum = sortedList[i];
					
					for (int j=i; j<size; j++) {
						if (sortedList[j] == currentNum) {
							i++;
						}
					}
				}
			}//end of for
		}else {
			System.out.print("There is no mode.");
		}
		System.out.println();
	}
	
	
	//reset list
	public void resetList() {
		for (int i=0; i<size; i++) {
			sortedList[i]=0;
			unSortedList[i]=0;
			size=0;
		}
	}
	
	//print method for sortedList
	public void printSorted() {
		
		System.out.println();
		System.out.print("Ascending Order: ");
		for (int i=0; i<size; i++) {
			System.out.print(sortedList[i] + " ");
		}
	}
	
	
	//print method for unsorted list
	public void printUnSorted() {
		System.out.println();
		System.out.print("Current List: ");
		for (int i=0; i<size; i++) {
			System.out.print(unSortedList[i] + " ");
		}
	}
	
	//EXTRA CREDIT- calculate standard deviation
	public double findStandardDeviation() {
		double tempMean = this.findMean();
		double difference, temp;
		double []devArr = new double [size];
		double devMean, total=0, devDouble;
		
		//square each number-mean
		for (int i=0; i<size; i++) {
			difference = sortedList[i] - tempMean;
			temp = difference * difference;
			devArr[i] = temp;
		}
		
		
		//find mean of numbers in devArr	
		for (int i=0; i<size; i++) {
			devDouble = devArr[i];
			total = total + devDouble;
		}
		devMean = total / size;
			
		//square root devMean
		stanDev = java.lang.Math.sqrt(devMean);
		
		
		return stanDev;
	}
	
	
	public boolean hasSize() {
		if (size==0) {
			return false;
		}else {
			return true;
		}
	}
	
	
}//end of class
