package ecommerce.repository;

import ecommerce.model.Product;

public interface ProductRepository {
    public void findByName(String name);
    public void findById(int id);
    public void listAll();
    public void register(Product product);
    public void update(Product product);
    public void delete(int number);
}
