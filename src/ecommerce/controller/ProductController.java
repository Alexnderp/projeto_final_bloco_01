package ecommerce.controller;

import ecommerce.model.Product;
import ecommerce.repository.ProductRepository;
import ecommerce.util.Functions;

import java.util.ArrayList;

public class ProductController implements ProductRepository {

    private ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public void findByName(String name) {
        Product product = Functions.searchByName(name, products);
        if(product != null){
            product.view();
        } else {
            System.out.printf("\nO produto %s não foi encontrado!", name);
        }
    }

    @Override
    public void listAll() {
        products.forEach(Product::view);
    }

    @Override
    public void register(Product product) {
        products.add(product);
    }

    @Override
    public void update(Product product) {
        Product result = Functions.searchProductByID(product.getId(),products);

        if (result != null){
            products.set(products.indexOf(result), product);
            System.out.printf("\nO produto %s foi atualizado com sucesso!", product.getName());
        } else {
            System.out.printf("\nO ID  %d não foi encontrado!",product.getId());
        }
    }

    @Override
    public void delete(int id) {
        Product product = Functions.searchProductByID(id,products);
        if(product != null){
            if (products.remove(product)){
                System.out.printf("\nO produto %s foi deletado com sucesso!", product.getName());
            } else {
                System.out.printf("\nO ID %d não foi encontrado!",id);
            }
        }

    }
}
