import ecommerce.model.Bike;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;

        Bike bike = new Bike(21,"bike","uma bike aleatoria de teste",
                "bike", 200,true,0.1,"Caloi");
        bike.view();

        while (true) {
            System.out.print("""
                    *********************************************************
                                        
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
                    System.out.println("Cadastar Produto");
                }

                case 2 ->{
                    System.out.println("Listar Produtos");
                }

                case 3 ->{
                    System.out.println("Filtrar Produto");
                }

                case 4 ->{
                    System.out.println("Atualizar Produto");
                }

                case 5 ->{
                    System.out.println("Deletar Produto");
                }

            }
        }
    }
}