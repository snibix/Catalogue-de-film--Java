package moviescatalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
    List<Product> products = new ArrayList<>();
    List<Client> clients = new ArrayList<>();

  public void addProduct(Product product){
    products.add(product);
  }

  public void deleteProduct(Product product){
    Product findProduct = null ;

    for (Product prod : products){
      if(prod.name.equals(product.name)){
        System.out.println("Produit trouver");
        findProduct = prod ;
      }
    }

    if(findProduct != null)products.remove(findProduct);
    
  }

  public void modifyProduct(Product product){
    Scanner sc = new Scanner(System.in);
    Product findProd = null ;
    for (Product prod : products){
      if(prod.name.equals(product.name)){
        findProd = prod ;
      }
    }
    if(findProd != null){
      boolean quitter = false;
      while (!quitter) {
    
      
      System.out.println("Que souhaitez vous modifier sur le produit ?");
      System.out.println("1 - Modifier le nom");
      System.out.println("2 - Modifier le prix");
      System.out.println("3 - Modifier le stock");
      System.out.println("4 - Quitter");

      int result = sc.nextInt();
      sc.nextLine();

      switch (result) {
        case 1:
          System.out.println("Nouveau Nom du produit");
          String newName = sc.nextLine();
          findProd.setName(newName);
          break;

        case 2:
          System.out.println("Nouveau prix du produit");
          int newPrice = sc.nextInt();
          sc.nextLine();
          findProd.setPrice(newPrice);
        break;

        case 3:
          System.out.println("Nouveau Stock du produit");
          int newStock = sc.nextInt();
          sc.nextLine();
          findProd.setStock(newStock);
          break;

        case 4:
          quitter = true;
          break;
      
        default:
        System.out.println("Choix invalide, réessayez.");
          break;
      }
      
    };
  }
  sc.close();
}

  public void addClient (Client client){
    clients.add(client);
  }

  public void delete (Client client){

   Client findClient = null;

  for (Client customer : clients){
    if(customer.name.equalsIgnoreCase(client.name)){
      findClient = customer;
    }
  }

  if(findClient != null) clients.remove(findClient);
  }

  public void modifyClient (Client client){
    Scanner sc = new Scanner(System.in);
    Client findClient = null;

    for (Client cl : clients ){
      if (cl.name.equalsIgnoreCase(client.name)) {
        findClient = cl;
      }
    }

    if(findClient != null){
      boolean quitter = false ;

      while (!quitter) {
        System.out.println("1 - Modifier le nom ?");
        System.out.println("2 - Modifiier l'adresse email");
        System.out.println("3 - Quitter");

        int result = sc.nextInt();

        switch (result) {
          case 1:
            System.out.println("Entrez votre nouveau nom ");
            String newName = sc.nextLine();
            findClient.setName(newName);
            break;

          case 2:
             System.out.println("Entrez votre nouveau email");
             String newEmail = sc.nextLine();

             findClient.setEmail(newEmail);
            break;
        
          case 3:
             quitter = true ;
            break;

            default:
            System.out.println("Choix invalide, réessayez.");
              break;
        }
      }
    }
    sc.close();
  }
}
