package ecommerce.model;

public abstract class Product {
    private int id;
    private String name, description, tags;
    private double price;

    public Product(int id, String name, String description, String tags, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tags = tags;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void view(){
        System.out.printf("""
                ***********************************
                                %s
                ***********************************
                ID: %d
                            Descrição:
                                %s
                
                            Preço: %.2f
                
                            Tag: %s
                
                ***********************************
                """, name, id, description, price, tags);
    }
}
