package a1;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// Your code follows here.
		int inventory = scan.nextInt();
		Hashtable<String, Integer> shopListMap = new Hashtable<>();
		Hashtable<String, Integer> numOfCustomer = new Hashtable<>();
		String[] shopping_list = new String[inventory];
		for (int x=0; x < inventory; x++) {
			String value = scan.next();
			shopping_list[x] = value;
			shopListMap.put(value, 0);
			numOfCustomer.put(value, 0);
			double throwaway = scan.nextDouble();
		}
		int customers = scan.nextInt();
		for (int j=0; j < customers; j++) {
			String first_name = scan.next();
			String last_name = scan.next();
			int products = scan.nextInt();
			ArrayList<String> customer_products = new ArrayList<String>();
			for (int i=0; i < products; i++) {
				int quantity = scan.nextInt();
				String item = scan.next();
				shopListMap.put(item, shopListMap.get(item) + quantity);
				if (!customer_products.contains(item)) {
					numOfCustomer.put(item, numOfCustomer.get(item) + 1);
					customer_products.add(item);
				}
			}
		}
		for (int y=0; y < inventory; y++) {
			String item = shopping_list[y];
			int number = numOfCustomer.get(item);
			int total = shopListMap.get(item);
			if (number == 0) {
				System.out.println("No customers bought " + item);
			}
			else {
				System.out.println(number + " customers bought " + total + " " + item);
			}
		}
	}
}
