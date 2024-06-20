import ecommerce.controller.ProductController;
import ecommerce.model.Bike;
import ecommerce.util.Functions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductController products = new ProductController();
        int id;
        String name, description, tags, brand;
        boolean onSale;
        double price, discount;
        int option;


        while (true) {
            System.out.print("""
                    \n*********************************************************
                                        
                                        E-Commerce API
                                        
                    *********************************************************
                                        
                                   1 - Cadastrar Produto
                                   2 - Listar Todos as Produtos
                                   3 - Filtrar Produto Pelo Nome
                                   4 - Atualizar Produto
                                   5 - Apagar Produto
                                   6 - Sair
                                   
                    *********************************************************
                    Entre com a opção desejada:
                                        
                                        
                    """);
            try {
                option = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nDigite uma opção válida!");
                sc.nextLine();
                option = 0;
            }

            if (option == 6) {
                System.out.println("Obrigado pela visita, Volte sempre");
                sc.close();
                System.exit(0);
            }

            switch (option) {
                case 1 ->{
                    System.out.println("Informe o nome do Produto: ");
                    sc.skip("\\R?");
                    name = sc.nextLine();
                    System.out.println("Informe a descrição do produto: ");
                    description = sc.nextLine();
                    System.out.println("Informe a tag do produto: ");
                    tags = sc.nextLine();
                    System.out.println("informe a marca do produto: ");
                    brand = sc.nextLine();
                    System.out.println("Informe o preço do produto: ");
                    sc.skip("\\R?");
                    price = sc.nextDouble();
                    System.out.println("O produto está em promoção?");
                    onSale = sc.nextBoolean();

                    if(onSale){
                        System.out.println("Informe o desconto que será aplicado:");
                        discount = sc.nextDouble();
                        products.register(new Bike(Functions.generateId(),name,description,tags,price,onSale,discount,brand));

                    } else {
                        discount = 0;
                        products.register(new Bike(Functions.generateId(),name,description,tags,price,onSale,discount,brand));

                    }


                }

                case 2 ->{
                    System.out.println("Produtos Cadastrados: ");
                    products.listAll();
                }

                case 3 ->{
                    System.out.println("Informe o nome do produto: ");
                    sc.skip("\\R?");
                    name = sc.nextLine();
                    products.findByName(name);
                }

                case 4 ->{
                    System.out.println("Informe o ID do produto: ");
                    id = sc.nextInt();

                    var product = Functions.searchProductByID(id,products.getProducts());
                    if (product != null){
                        System.out.println("Informe o nome do Produto: ");
                        sc.skip("\\R?");
                        name = sc.nextLine();
                        System.out.println("Informe a descrição do produto: ");
                        description = sc.nextLine();
                        System.out.println("Informe a tag do produto: ");
                        tags = sc.nextLine();
                        System.out.println("informe a marca do produto: ");
                        brand = sc.nextLine();
                        System.out.println("Informe o preço do produto: ");
                        sc.skip("\\R?");
                        price = sc.nextDouble();
                        System.out.println("O produto está em promoção?");
                        onSale = sc.nextBoolean();

                        if(onSale){
                            System.out.println("Informe o desconto que será aplicado:");
                            discount = sc.nextDouble();
                            products.update(new Bike(id,name,description,tags,price,onSale,discount,brand));
                        } else {
                            discount = 0;
                            products.update(new Bike(id,name,description,tags,price,onSale,discount,brand));
                        }
                    } else {
                        System.out.printf("O ID %d não foi encontrado", id);
                    }
                }

                case 5 ->{
                    System.out.println("Informe o ID do produto: ");
                    id = sc.nextInt();
                    products.delete(id);
                }

                default -> System.out.println("Opção inválida!");

            }
        }
    }
}