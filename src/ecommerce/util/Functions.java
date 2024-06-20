package ecommerce.util;

import ecommerce.model.Product;

import java.util.ArrayList;

public class Functions {

    public static Product searchByName(String name, ArrayList<Product> products){
        Product result = products.stream().filter(product -> product.getName().equalsIgnoreCase(name))
                .findAny()
                .orElse(null);
        return result;
    }

    public static Product searchProductByID(int id, ArrayList<Product> products){
        Product result = products.stream().filter(product -> product.getId() == id)
                .findAny()
                .orElse(null);
        return result;
    }

    public static int generateId(){
        return (int) (Math.random() * 99999) +1;
    }
}
