/**
 * Test class
 * Created by : Abdulaziz Jamal
 *
 */
public class Test {

	/**
	 * Main function
	 * @param args
	 */
	public static void main(String[] args) {
		//test Date class without arguments.
		Date today=new Date();
		System.out.println("Today is: "+today.toString());
		
		//test Date class with arguments.
		Date randomDate=new Date(5,11,2011);
		System.out.println("Random date is: "+randomDate.toString());
		
		//A constructor that accepts an ISO 8601 date string as a parameter.
		Date stringDate=new Date("6-8-2008");
		//test earlier comparing function.
		System.out.println("String argument date is: "+stringDate.toString());
		if(stringDate.isEarlier(today)){
			System.out.println("String argument date is earlier than today date.");
		}else{
			System.out.println("String argument date is not earlier than today date.");
		}

	}

}
