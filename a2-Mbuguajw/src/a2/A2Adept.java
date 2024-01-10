package a2;

import java.util.Scanner;

public class A2Adept {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		// Your code here.

		int total_veg_ingredients = scan.nextInt();

		String[] ingredientNames = new String[total_veg_ingredients];

		Double[] price_per_ounce = new Double[total_veg_ingredients];

		int[] calories_per_ounce = new int[total_veg_ingredients];

		boolean[] vegetarian = new boolean[total_veg_ingredients];

		for (int i=0; i < total_veg_ingredients; i++) {

			ingredientNames[i] = scan.next();

			price_per_ounce[i] = scan.nextDouble();

			if (scan.nextBoolean()) {

				vegetarian[i] = true;
			}

			else {

				vegetarian[i] = false;
			}

			calories_per_ounce[i] = scan.nextInt();
		}

		int menu_items = scan.nextInt();

		String[] dishes = new String[menu_items];

		for (int j=0; j < menu_items; j++) {

			double itemCaloricSum = 0;

			double itemPriceSum = 0;

			dishes[j] = scan.next();

			int recipe_ingredients = scan.nextInt();

			boolean[] vegetarianCheck = new boolean[recipe_ingredients];

			for (int k=0; k < recipe_ingredients; k++) {

				String ingredient = scan.next();

				float totalWeight = scan.nextFloat();

				for (int l=0; l < total_veg_ingredients; l++) {

					if (ingredientNames[l].equals(ingredient)) {

						itemCaloricSum = itemCaloricSum + (totalWeight * calories_per_ounce[l]);

						itemPriceSum = itemPriceSum + (totalWeight * price_per_ounce[l]);

						vegetarianCheck[k] = vegetarian[l];
					}
				}

			}

			boolean veggie_check = false;

			String indentLine0 = ((Math.round(itemCaloricSum)) + " calories");

			String indentLine1 = "  $" + String.format("%.2f", itemPriceSum);

			System.out.println(dishes[j] + ": ");
			System.out.println("  " + indentLine0);
			System.out.println(indentLine1);

			for (int m=0; m < recipe_ingredients; m++) {

				if (vegetarianCheck[m]) {

					veggie_check = true;
				}
				else {

					veggie_check = false;

					break;
				}
			}
			if (veggie_check) {

				System.out.println(("  Vegetarian"));
			}
			else {

				System.out.println(("  Non-Vegetarian"));
			}
		}
	}
	// You can define helper methods here if needed.
	// God help me, I've been trying to submit for two hours
}
