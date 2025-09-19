package moviescatalog;

import java.util.ArrayList;
import java.util.List;

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
}
