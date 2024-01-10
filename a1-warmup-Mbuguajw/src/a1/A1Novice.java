package a1;

import java.util.Scanner;

import java.util.ArrayList;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		int customers = scan.nextInt();

		for (int i=0; i<customers; i++) {

			String first_name = scan.next();

			char initial = first_name.charAt(0);

			String last_name = scan.next();

			int items = scan.nextInt();

			ArrayList<Double> sum_list = new ArrayList<>();

			ArrayList<String> product_name = new ArrayList<>();

			for (int j=0; j<items; j++) {

				int packages = scan.nextInt();

				product_name.add(scan.next());

				double price = scan.nextDouble();

				double multiplication = packages * price;

				sum_list.add(multiplication);
			}

			double total = 0.00;

			for (Double aDouble : sum_list) {

				total = total + aDouble;
			}

			String new_total = String.format("%.2f", total);

			System.out.println(initial + ". " + last_name + ": " + new_total);

		}
	}
}
