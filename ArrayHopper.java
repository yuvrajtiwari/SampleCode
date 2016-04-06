package leetcode;

import java.util.ArrayList;

public class ArrayHopper {
	
	ArrayList<Integer> pathIndexes ;  //// arrayList holding the indexes of those hops in the shortest path path

	
	public ArrayList<Integer> getShortestHops(ArrayList<Integer> input){
		
		int currentElement = 0, currentReach = 0, globalMaxReach = 0;int index = 0;
		pathIndexes = new ArrayList<Integer>() ;
		
		if(input == null){
			
			System.out.println("Input array is null");
			return null;
			
		}
		
		if(input.get(0) == 0){
			
			System.out.println("Invalid Input array-- first element is zero so cannot hop over this array");
			
		}
		
		for(int i = 0; i < input.size() ; i++){
			
			currentElement = input.get(i) ;
			
			
			if(currentReach < currentElement + i) { //local < ls[i]+i:
				
				currentReach = currentElement + i ;
				
				index = i ;
			}
			
			
			if((currentReach > globalMaxReach) && (i == globalMaxReach)){  //local > glob and i == glob:
				
				globalMaxReach = currentReach ;
				
				pathIndexes.add(index);
				
			} 
			if(globalMaxReach >= input.size() -1 ){
				System.out.println("Breaking at i = " + i);
				break;
			}
			
			
			
		}
		int lastIndex = input.size() -1;
		if(globalMaxReach > lastIndex){
			
			System.out.println("We managed to hop through the array in "+ pathIndexes.size()+ " steps");
			
		}
		else if(globalMaxReach == lastIndex){
			
			if(input.get(lastIndex) > 0){
				
				pathIndexes.add(lastIndex);
				
			}
			else{
				
				System.out.println("We got caught at the last element..cannot hop through this array");
				
			}
			
		}
		
		return pathIndexes;
		
	}
	
	

}
