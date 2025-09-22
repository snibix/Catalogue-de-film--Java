package moviescatalog;

import java.util.ArrayList;
import java.util.List;

public class Client {
  private static int counter = 1;
  private int id;
  private String name;
  private String email;
  private int num;
  List<Order> order = new ArrayList<>();

  public Client(String name, String email, int num) {
    this.id = counter++;
    this.name = name;
    this.email = email;
    this.num = num;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return " | Nom: " + name +
        " | Email: " + email +
        " | Num: " + num;
  }

}
