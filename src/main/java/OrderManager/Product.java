package OrderManager;

public class Product {
  private static int counter = 1;
  private int id;
  private String name;
  private int price;
  private int stock;

  public Product(String name, int price, int stock) {
    this.id = counter++;
    this.name = name;
    this.price = price;
    this.stock = stock;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public int getId() {
    return id;
  }

  public boolean decrementStock(int quantity) {
    if (quantity <= stock) {
      this.stock = stock - quantity;
      System.out.println("Nouveau " + stock);
      return true;
    } else {
      System.out.println("Stock insufissant ");
      return false;
    }
  }

  public void incrementStock(int quantity) {
    this.stock += quantity;
    System.out.println("Stock mis à jour ! ");
  }

  @Override
  public String toString() {
    return " | Nom: " + name +
        " | Prix: " + price +
        " | Stock: " + stock;
  }
}
