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

  public String getName(){
    return name ;
  }

  public void setName (String name){
    this.name = name;
  }

  public String getEmail (){
    return email;
  }

  public void setEmail(String email){
    this.email = email;
  }
}
