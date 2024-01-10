package a1;

import java.util.*;

public class A1Adept {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Your code follows here.

        Hashtable<String, Double> shoplist_map = new Hashtable<>();
        int inventory = scan.nextInt();
        for (int i=0; i < inventory; i++) {
            shoplist_map.put(scan.next(), scan.nextDouble());
        }
        int customers = scan.nextInt();
        String[] customer_names = new String[customers];
        Double[] customer_totals = new Double[customers];

        for (int j=0; j < customers; j++) {

            String first_name = scan.next();

            String last_name = scan.next();

            String full_name = first_name + " " + last_name;

            int products = scan.nextInt();

            double total = 0.00;

            for (int k=0; k < products; k++) {

                double quantity = scan.nextDouble();

                String product = scan.next();

                double price = shoplist_map.get(product);

                double sub_total = price * quantity;

                total = total + sub_total;
            }

            customer_names[j] = full_name;

            customer_totals[j] = total;
        }

        double average = 0.00;

        double largest = 0.00;

        for (int k=0; k < customers; k++) {

            if (customer_totals[k] > largest) {

                largest = customer_totals[k];

                average = average + customer_totals[k];
            }

            else {

                average = average + customer_totals[k];
            }
        }

        int placelarge = 0;

        for (int k=0; k < customers; k++) {

            if (customer_totals[k] == largest) {

                placelarge = k;
            }
        }

        double smallest = largest;

        for (int k=0; k < customers; k++) {

            if (customer_totals[k] < smallest) {

                smallest = customer_totals[k];
            }
        }
        int placesmall = 0;

        for (int l=0; l < customers; l++) {

            if (customer_totals[l] == smallest) {

                placesmall = l;
            }
        }
        average = average / customers;

        System.out.println("Biggest: " + customer_names[placelarge] + " (" + String.format("%.2f", customer_totals[placelarge]) + ")");

        System.out.println("Smallest: " + customer_names[placesmall] + " (" + String.format("%.2f", customer_totals[placesmall]) + ")");

        System.out.println("Average: " + String.format("%.2f", average));
    }
}