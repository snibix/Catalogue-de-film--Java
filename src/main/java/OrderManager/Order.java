package OrderManager;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Order {
  private static int counter = 1;
  private int id;
  Client client;
  private Map<Product, Integer> products = new HashMap<>();
  private LocalDateTime date;

  public Order(Client client, LocalDateTime date, int total) {
    this.id = counter++;
    this.client = client;
    this.date = date;
    this.products = new HashMap<>();
  }

  public double getTotal() {
    return products.entrySet().stream()
        .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
        .sum();
  }

  public int getId() {
    return id;
  }

  public void addProduct(Product product, int quantity) {
    if (product.decrementStock(quantity)) {
      products.put(product, products.getOrDefault(product, 0) + quantity);
    } else {
      System.out.println("Stock insuffisant pour " + product.getName());
    }
  }

  public void removeProduct(Product product, int quantity) {
    if (products.containsKey(product)) {
      int currentQty = products.get(product);

      if (quantity >= currentQty) {
        products.remove(product);
        product.incrementStock(currentQty);
      } else {
        products.put(product, currentQty - quantity);
        product.incrementStock(quantity);
      }

      System.out.println("Produit retiré avec succès !");
    } else {
      System.out.println("Erreur : le produit n'est pas dans la commande.");
    }
  }

  @Override
  public String toString() {
    return "Commande #" + id + " | Client: " + client.getName() + " | Total: " + getTotal();
  }

}
