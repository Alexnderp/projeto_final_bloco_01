package ecommerce.model;

public class Bike extends Product{
    private boolean onSale;
    private double discount;
    private String brand;

    public Bike(int id, String name, String description, String tags, double price, boolean onSale, double discount, String brand) {
        super(id, name, description, tags, price);
        this.onSale = onSale;
        this.discount = discount;
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    @Override
    public void view() {

        if(onSale){
            setPrice(getPrice() - (getPrice() * discount));
        }
        System.out.printf("""
                ***********************************
                                %s
                ***********************************
                ID: %d
                            Marca:
                                %s
                            Descrição:
                                %s
                
                            Preço: %.2f
                
                            Tag: %s
                
                ***********************************
                """, getName(), getId(),brand, getDescription(), (getPrice() - (getPrice() * discount)), getTags());
    }
}
