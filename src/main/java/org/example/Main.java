package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Main {

    public static ArrayList<Product> getInventory(){
        ArrayList<Product> arrOfProducts = new ArrayList<>();

        // Adding products manually to the inventory
        arrOfProducts.add(new Product(1010, "Electric Saw", 39.99));
        arrOfProducts.add(new Product(2020, "Wrench", 15.49));
        arrOfProducts.add(new Product(3030, "Measuring Tape", 5.99));
        arrOfProducts.add(new Product(4040, "Pliers", 8.99));
        arrOfProducts.add(new Product(5050, "Hammer (Heavy Duty)", 24.99));
        return arrOfProducts;
    }

    public static void main(String[] args) {
        ArrayList<Product> arrOfProducts = getInventory();
//    System.out.println(arrOfProducts);


        try{
            Scanner scanner=new Scanner(new File("inventory.csv"));
//            System.out.println(scanner.nextLine());
            while(scanner.hasNextLine()){

                String line = scanner.nextLine();
//              System.out.println(line);

                String[] parts = line.split("\\|");
//              System.out.println("Parts: " + Arrays.toString(parts));
//              System.out.println(parts[1]);

                //Since we stored  them in string forms we should change it to it real values/  Parse the values
                int id = Integer.parseInt(parts[0].trim()); // Read ID
                String name = parts[1].trim(); // Read Name
                double price = Double.parseDouble(parts[2].trim());

                arrOfProducts.add(new Product(id,name,price));

                for (Product product : arrOfProducts) {
                    System.out.println(product);
                }

            }
        }catch(Exception e){
            System.out.println("Error"+ e);
        }
    }
}