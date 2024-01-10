package a2;

import java.util.Scanner;

public class A2Novice {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		// Your code here.

		int total_veg_ingredients = scan.nextInt();

		String[] ingredientNames = new String[total_veg_ingredients];

		Double[] price_per_ounce = new Double[total_veg_ingredients];

		int[] calories_per_ounce = new int[total_veg_ingredients];

		int if_vegetarian = 0;

		for (int i=0; i < total_veg_ingredients; i++) {

			ingredientNames[i] = scan.next();

			price_per_ounce[i] = scan.nextDouble();

			if (scan.nextBoolean() == true) {

				if_vegetarian = if_vegetarian + 1;
			}

			calories_per_ounce[i] = scan.nextInt();
		}

		Double[] calories_per_dollar = new Double[total_veg_ingredients];

		for (int j=0; j < total_veg_ingredients; j++) {

			Double multiplier1 = 1 / price_per_ounce[j];

			Double calPerDollar = calories_per_ounce[j] * multiplier1;

			calories_per_dollar[j] = calPerDollar;
		}

		Double largest = 0.00;

		int index_l = 0;

		for (int k=0; k < total_veg_ingredients; k++) {

			if (calories_per_dollar[k] > largest) {

				largest = calories_per_dollar[k];

				index_l = k;
			}
		}

		double smallest = largest;

		int index_s = 0;

		for (int l=0; l < total_veg_ingredients; l++) {

			if (calories_per_dollar[l] < smallest) {

				smallest = calories_per_dollar[l];

				index_s = l;
			}
		}
		System.out.println("Number of vegetarian ingredients: " + if_vegetarian );
		System.out.println("Highest cals/$: " + ingredientNames[index_l]);
		System.out.println("Lowest cals/$: " + ingredientNames[index_s]);
	}
	// You can define helper methods here if needed.
	// God help me, I've been trying to submit for two hours
}
