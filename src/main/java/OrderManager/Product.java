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

  @Override
  public String toString() {
    return " | Nom: " + name +
        " | Prix: " + price +
        " | Stock: " + stock;
  }
}
