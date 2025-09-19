package moviescatalog;

import java.util.ArrayList;
import java.util.List;

public class Order {
  Client client;
  List<Product> products = new ArrayList<>() ;
  int date ;
  int total;

  public Order (Client client ,int date , int total){

    this.client = client;
    this.date = date;
    this.total = total;
  }
}
