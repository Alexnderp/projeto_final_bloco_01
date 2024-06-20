package ecommerce.util;

import ecommerce.model.Product;

import java.util.ArrayList;

public class Functions {

    public static ArrayList<Product> searchByName(String name, ArrayList<Product> products){
        ArrayList<Product> results = new ArrayList<>();

        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                results.add(product);
            }
        }
        return results;

    }

    public static Product searchProductByID(int id, ArrayList<Product> products){
        Product result = products.stream().filter(product -> product.getId() == id)
                .findAny()
                .orElse(null);
        return result;
    }

    public static ArrayList<Product> searchByTag(String tag, ArrayList<Product> products){
        ArrayList<Product> results = new ArrayList<>();

        for (Product product : products) {
            if (product.getTags().equalsIgnoreCase(tag)) {
                results.add(product);
            }
        }
        return results;
    }

    public static int generateId(){
        return (int) (Math.random() * 99999) +1;
    }
}
