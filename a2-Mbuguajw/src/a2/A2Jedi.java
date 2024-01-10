package a2;

import java.util.Hashtable;
import java.util.Scanner;

public class A2Jedi {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		// Your code here.
		int total_veg_ingredients = scan.nextInt();

		String[] ingredientNames = new String[total_veg_ingredients];

		Double[] price_per_ounce = new Double[total_veg_ingredients];

		int[] calories_per_ounce = new int[total_veg_ingredients];

		boolean[] vegetarian = new boolean[total_veg_ingredients];

		Hashtable<String, Double> totalOzRequired = new Hashtable<>();

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

			totalOzRequired.put(ingredientNames[i], 0.00);
		}

		int menu_items = scan.nextInt();

		Hashtable<String, Hashtable> recipe_book = new Hashtable<>();

		for (int k=0; k < menu_items; k++) {

			String nameOfRecipe = scan.next();

			Hashtable<String, Double> recipe = new Hashtable<>();

			int ingredientListing = scan.nextInt();

			for (int l=0; l < ingredientListing; l++) {

				String ingredient = scan.next();

				Double ounces = scan.nextDouble();

				recipe.put(ingredient, ounces);
			}

			recipe_book.put(nameOfRecipe, recipe);
		}

		boolean moreOrders = true;

		while (moreOrders) {

			String nextOrder = scan.next();

			if (!nextOrder.equals("EndOrder")) {

				Hashtable<String, Double> inner_recipe = recipe_book.get(nextOrder);

				for (int m=0; m < total_veg_ingredients; m++) {

					Double newOz = inner_recipe.get(ingredientNames[m]);

					if (newOz == null) {

						newOz = 0.00;

						Double oldOz = totalOzRequired.get(ingredientNames[m]);

						Double oz = newOz + oldOz;

						totalOzRequired.replace(ingredientNames[m], oz);
					} else {

						Double oldOz = totalOzRequired.get(ingredientNames[m]);

						Double oz = newOz + oldOz;

						totalOzRequired.replace(ingredientNames[m], oz);
					}
				}
			}
			else {

				break;
			}
		}

		System.out.println("The order will require:");

		for (int l=0; l < total_veg_ingredients; l++) {

			Double finalOz = totalOzRequired.get(ingredientNames[l]);

			System.out.println(String.format("%.2f", finalOz) + " ounces of " + ingredientNames[l]);
		}
	}
	
	// You can define helper methods here if needed.
	// God help me, I've been trying to submit for two hours
	// literally I want to d i e
}

