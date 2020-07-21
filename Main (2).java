/******************************************************************************

                           VINAYAKA MUDRADI

*******************************************************************************/
import java.util.Scanner;
class InvalidException extends Exception{
    InvalidException(String s){
        super(s);
    }
}
class BinarySearch{
    private int key;
    private int arraySize;
    private int begin;
    private int mid;
    private int end;
    private int[] arr;
    private boolean inConditionSatisfied(){
        int temp = this.arr[0];
        boolean condition = false;
        for(int i=1; i<this.arr.length; i++){
            if(temp<=arr[i]){
                temp = arr[i];
                condition = true;
            }
            else{
                condition = false;
                break;
            }
        }
        if(condition){
            return true;
        }
        else{
            condition = false;
            temp = this.arr[0];
            for(int i=1; i<this.arr.length; i++){
                if(temp>=arr[i]){
                    temp = arr[i];
                    condition = true;
                }
                else{
                    condition = false;
                    break;
                }
            }
            if(condition){
            return true;
            }
            return false;
        }
    }
    private void validateSize(int size) throws InvalidException{
        if(size<=0){
            throw new InvalidException("EXCEPTION: The array size is less than 1.");
        }
        
    }
    private void populateArray(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        this.arraySize = scan.nextInt();
        try{
            this.validateSize(this.arraySize);
        }
        catch(InvalidException s){
            System.out.println(s.getMessage());
            System.exit(0);
        }
        this.arr = new int[this.arraySize];
        System.out.println("New empty array is created.!");
        System.out.println("Enter the elements of the array:");
        for(int i=0; i<arraySize; i++){
            arr[i] = scan.nextInt();
        }
        System.out.println("Array got populated!");
        if(! inConditionSatisfied()){
            System.out.println("CANNOT PROCESS: Array is not in sorted order.");
            System.exit(0);
        }
        System.out.println("Enter the key to be searched:");
        this.key = scan.nextInt();
        scan.close();
    }
    public int search(){
        this.populateArray();
        System.out.println("Searching for the key "+this.key+"...");
        this.mid = this.arraySize/2;
        this.begin = 0;
        this.end = this.arraySize-1;
        while(this.begin <= this.end){
            this.mid = (this.begin + this.end)/2;
            if(this.arr[this.mid] == this.key){
                return this.mid;
            }
            else if(this.key > this.arr[this.mid]){
                this.begin = this.mid+1;
            }
            else{
                this.end = this.mid-1;
            }
        }
        return -1;
    }
}
public class Main
{
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		int val = bs.search();
		if(val!= -1){
		    System.out.println("The key Found At:"+(val+1));
		}
		else{
		    System.out.println("Key Not Found!");
		}
	}
}
