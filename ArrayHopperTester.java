package leetcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayHopperTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

		File inputFile = new File("C:\\Users\\Yuvraj\\Desktop\\arrayHopper_TextSampleInput_10000.txt");
		Scanner scanner = new Scanner(inputFile);
		
		

        ArrayList<Integer> inputList= new ArrayList<Integer>();

       

            while (scanner.hasNextInt()) {

               int i = scanner.nextInt();

                if(i<0){  // test for negative values

                   System.out.println("invalid_file negative int found");

                   System.exit(0);

                }

                else

                	inputList.add(i);

           }

        
		
		ArrayHopper objHopper = new ArrayHopper();
		
		ArrayList<Integer> outputList = objHopper.getShortestHops(inputList);
		System.out.println("Size of Input list of hops is "+ inputList.size());
		System.out.println("Size of output list of hops is "+ outputList.size());
		
		for(Integer index: outputList){
			
			System.out.println(index);
			
			}
			
			
			
		
		
	} 
	catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    catch(Exception e)

       {

       System.out.println("Exception occured..something went wrong");

   }

	}
	
}

