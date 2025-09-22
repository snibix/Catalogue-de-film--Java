package moviescatalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
  List<Product> products = new ArrayList<>();
  List<Client> clients = new ArrayList<>();

  public Product finProductById(int id) {
    for (Product p : products) {
      if (p.getId() == id) {
        return p;
      }
    }
    return null;
  }

  public Product findProductByName(String name) {
    for (Product prod : products) {
      if (prod.getName().equalsIgnoreCase(name)) {
        return prod;
      }
    }
    return null;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void addProduct(Product product) {
    products.add(product);
  }

  public void deleteProduct(int id, Scanner sc) {
    Product findProduct = null;

    for (Product prod : products) {
      if (prod.getId() == id) {
        System.out.println("Produit trouver");
        findProduct = prod;
        break;
      }
    }

    if (findProduct != null) {
      products.remove(findProduct);
      System.out.println("Produit supprimé avec succès !");
    } else {
      System.out.println("Produit introuvable.");
    }

  }

  public void modifyProduct(int id, Scanner sc) {

    Product findProd = null;
    for (Product prod : products) {
      if (prod.getId() == id) {
        findProd = prod;
        break;
      }
    }
    if (findProd != null) {
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

      }
      ;
    }
    sc.close();
  }

  public Client findClientByName(String name) {
    for (Client c : clients) {
      if (c.getName().equalsIgnoreCase(name)) {
        return c;
      }
    }
    return null;
  }

  public void addClient(Client client) {
    clients.add(client);
  }

  public void deleteClient(int id) {

    Client findClient = null;

    for (Client c : clients) {
      if (c.getId() == id) {
        System.out.println("Client trouver");
        findClient = c;
        break;
      }
    }

    if (findClient != null) {
      clients.remove(findClient);
      System.out.println("Client supprimé avec succès !");
    } else {
      System.out.println("Client introuvable.");
    }
  }

  public void modifyClient(int id, Scanner sc) {
    Client findClient = null;
    for (Client cl : clients) {
      if (cl.getId() == id) {
        findClient = cl;
        break;
      }
    }

    if (findClient != null) {
      boolean quitter = false;
      while (!quitter) {
        System.out.println("1 - Modifier le nom");
        System.out.println("2 - Modifier l'email");
        System.out.println("3 - Modifier le téléphone");
        System.out.println("0 - Quitter");

        int result = sc.nextInt();
        sc.nextLine(); // vider le buffer

        switch (result) {
          case 1 -> {
            System.out.print("Nouveau nom : ");
            findClient.setName(sc.nextLine());
          }
          case 2 -> {
            System.out.print("Nouvel email : ");
            findClient.setEmail(sc.nextLine());
          }
          case 3 -> {
            System.out.print("Nouveau téléphone : ");
            findClient.setNum(sc.nextInt());
            sc.nextLine();
          }
          case 0 -> quitter = true;
          default -> System.out.println("Choix invalide !");
        }
      }
    } else {
      System.out.println("Client introuvable.");
    }
  }

}
