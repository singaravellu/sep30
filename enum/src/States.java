import java.util.Scanner;

import assignment.State;



public class States {

	public States() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String [] args ) {
		
		 Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		String reuslt;
		 while(true) {  
			 reuslt="";
		 System.out.println("Enter state name");
 
		    String stateName = myObj.nextLine();  
		
		    for(State s:State.values()) {
			 if(stateName.equalsIgnoreCase(s.toString())) {
				 reuslt=s.getValue();
			 }
			
			 
		 }	
		    
		    
		 if(reuslt.equals("")) {
			 System.out.println("entry is wrong");
		 }
		 else 
			 System.out.println(reuslt);
		 }
		 }
	}
	

