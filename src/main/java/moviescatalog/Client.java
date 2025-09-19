package moviescatalog;

import java.util.ArrayList;
import java.util.List;

public class Client {
  
  String name;
  String email;
  int phone ;
  List<Order> order = new ArrayList<>() ;
  
  public Client(String name,String email,int phone ){
    this.name = name;
    this.email = email;
    this.phone = phone ;
  }
}
