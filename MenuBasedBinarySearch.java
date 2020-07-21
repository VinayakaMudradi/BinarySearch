/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.Scanner;
public class Main
{
    private static boolean findElement(int[] arr, int key){
        int low = 0;
        int high = arr.length-1;
        int mid = 0;
        while(low<=high){
            mid = (low+high)/2;
            if(arr[mid]==key){
                return true;
            }
            else if(key>arr[mid]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
    private static boolean findString(String[] arr, String key){
        int low = 0;
        int high = arr.length-1;
        int mid = 0;
        while(low<=high){
            mid = (low+high)/2;
            if(arr[mid].equals(key)){
                return true;
            }
            else if(key.compareTo(arr[mid])>0){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
    
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		int[] arr;
		int arrSize = 0;
		int nameSize = 0;
		String[] names;
		while(true){
		    System.out.println("\n\n");
		    System.out.println("1. Binary search for Integer elements");
		    System.out.println("2. Binary search for Strings");
		    System.out.println("3. Exit");
		    System.out.println("Enter your choice:");
		    choice = scan.nextInt();
	        switch(choice){
	            case 1: System.out.println("Enter the size of the array:");
	                    arrSize = scan.nextInt();
	                    arr = new int[arrSize];
	                    System.out.println("Enter the elements:");
	                    for(int i=0; i<arrSize; i++){
	                        arr[i] = scan.nextInt();
	                    }
	                    System.out.println("Enter the key to be searched:");
	                    int eleKey = scan.nextInt();
	                    if(findElement(arr, eleKey)){
	                        System.out.println("Key Found!");
	                    }
	                    else{
	                        System.out.println("Key Not Found!");
	                    }
	                    break;
	            case 2: System.out.println("Enter the size of the array:");
	                    nameSize = scan.nextInt();
	                    names = new String[nameSize];
	                    System.out.println("Enter the Strings:");
	                    for(int i=0; i<nameSize; i++){
	                        names[i] = scan.next();
	                    }
	                    System.out.println("Enter the key to be searched:");
	                    String strKey = scan.next();
	                    if(findString(names, strKey)){
	                        System.out.println("Key Found!");
	                    }
	                    else{
	                        System.out.println("Key Not Found!");
	                    }
	                    break;
	            case 3: System.out.println("Program Terminated Successfully..!");
	                    System.exit(0);
	            default: System.out.println("Invalid Choice");
	                     break;
	        
	        } 
		    
		}
	}
}
