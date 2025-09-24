package OrderManager;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        Product p1 = new Product("Livre", 25, 250);
        Product p2 = new Product("Veste", 50, 500);
        Product p3 = new Product("Tapis", 30, 100);

        Client cl1 = new Client("john", "john@gmail.com", 123456);
        Client cl2 = new Client("Bernard", "Bernard@gmail.com", 789456);

        Order order1 = new Order(cl1, null, 0);
        Order order2 = new Order(cl2, null, 0);
        store.addProduct(p1);
        store.addProduct(p2);
        store.addProduct(p3);

        store.addClient(cl1);
        store.addClient(cl2);

        store.addOrder(order1);
        store.addOrder(order2);

        Scanner sc = new Scanner(System.in);
        int choix;

        do {
            System.out.println("--- Menu Principal ---");
            System.out.println("1 - Gérer les Produits");
            System.out.println("2 - Gérer les Clients");
            System.out.println("3 - Gérer les Commandes");
            System.out.println("0 - Quitter");
            System.out.println("Votre choix: ");

            choix = sc.nextInt();

            sc.nextLine();
            switch (choix) {
                case 1 -> menuProduits(store, sc);
                case 2 -> menuClients(store, sc);
                case 3 -> menuCommandes(store, sc);
                case 0 -> System.out.println("Au revoir !");
                default -> System.out.println("Choix invalide !");
            }
        } while (choix != 0);

        sc.close();

    }

    private static void menuProduits(Store store, Scanner sc) {
        int choix;

        do {
            System.out.println("\n--- Gestion Produits ---");
            System.out.println("1. Voir les produits");
            System.out.println("2. Ajouter un produit");
            System.out.println("3. Modifier un produit");
            System.out.println("4. Supprimer un produit");
            System.out.println("0. Retour");
            System.out.print("Votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {

                case 1 -> {
                    for (Product prod : store.getProducts()) {
                        System.out.println(prod);
                    }
                }

                case 2 -> {
                    System.out.print("Nom du produit : ");
                    String name = sc.nextLine();
                    System.out.print("Prix : ");
                    int price = sc.nextInt();
                    System.out.print("Stock : ");
                    int stock = sc.nextInt();
                    sc.nextLine();
                    store.addProduct(new Product(name, price, stock));
                    System.out.println("Produit ajouté !");
                }

                case 3 -> {
                    System.out.println("Nom du produit a modifier : ");
                    String name = sc.nextLine();

                    Product p = store.findProductByName(name);

                    if (p != null)
                        store.modifyProduct(p.getId(), sc);
                    else
                        System.out.println("Produit introuvable");
                }

                case 4 -> {
                    System.out.println("Nom du produit a supprimer : ");
                    String name = sc.nextLine();

                    Product p = store.findProductByName(name);

                    if (p != null)
                        store.deleteProduct(p.getId(), sc);
                    else
                        System.out.println("Produit introuvable");
                }
                case 0 -> System.out.println("Retour au menu principal");
                default -> System.out.println("Choix invalide !");
            }

        } while (choix != 0);
    }

    private static void menuClients(Store store, Scanner sc) {
        int choix;
        do {
            System.out.println("\n--- Gestion Clients ---");
            System.out.println("1. Voir les clients");
            System.out.println("2. Ajouter un client");
            System.out.println("3. Modifier un client");
            System.out.println("4. Supprimer un client");
            System.out.println("0. Retour");
            System.out.print("Votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1 -> {
                    for (Client cl : store.getClients()) {
                        System.out.println(cl);
                    }
                }
                case 2 -> {
                    System.out.print("Nom du client : ");
                    String name = sc.nextLine();
                    System.out.print("Email : ");
                    String email = sc.nextLine();
                    System.out.print("Téléphone : ");
                    int phone = sc.nextInt();
                    sc.nextLine();
                    store.addClient(new Client(name, email, phone));
                    System.out.println("Client ajouté !");
                }

                case 3 -> {
                    System.out.print("Nom du client à modifier : ");
                    String name = sc.nextLine();

                    Client c = store.findClientByName(name);

                    if (c != null)
                        store.modifyClient(c.getId(), sc);
                    else
                        System.out.println("Produit introuvable");
                }

                case 4 -> {
                    System.out.print("Nom du client à supprimer : ");
                    String name = sc.nextLine();

                    Client c = store.findClientByName(name);

                    if (c != null)
                        store.deleteClient(c.getId());
                    else
                        System.out.println("Client introuvable");
                }

                case 0 -> System.out.println("Retour au menu principal");
                default -> System.out.println("Choix invalide !");
            }
        } while (choix != 0);
    }

    private static void menuCommandes(Store store, Scanner sc) {
        int choix;
        do {
            System.out.println("\n--- Gestion Commandes ---");
            System.out.println("1. Voir toutes les commandes");
            System.out.println("2. Créer une nouvelle commande");
            System.out.println("3. Ajouter un produit à une commande");
            System.out.println("4. Retirer un produit d’une commande");
            System.out.println("5. Afficher les détails d’une commande");
            System.out.println("0. Retour");
            System.out.print("Votre choix : ");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1 -> { // Voir toutes les commandes
                    for (Order order : store.getOrders()) {
                        System.out.println(order);
                    }
                }
                case 2 -> { // Créer une nouvelle commande
                    System.out.print("Nom du client : ");
                    String clientName = sc.nextLine();
                    Client client = store.findClientByName(clientName);
                    if (client != null) {
                        Order order = new Order(client, LocalDateTime.now(), 0);
                        store.addOrder(order);
                        System.out.println("Commande créée pour " + client.getName());
                    } else {
                        System.out.println("Client introuvable !");
                    }
                }
                case 3 -> { // Ajouter un produit à une commande
                    System.out.print("ID de la commande : ");
                    int orderId = sc.nextInt();
                    sc.nextLine();
                    Order order = store.findOrderById(orderId);
                    if (order != null) {
                        System.out.print("Nom du produit à ajouter : ");
                        String productName = sc.nextLine();
                        Product product = store.findProductByName(productName);
                        if (product != null) {
                            System.out.print("Quantité : ");
                            int quantity = sc.nextInt();
                            sc.nextLine();
                            order.addProduct(product, quantity);
                        } else {
                            System.out.println("Produit introuvable !");
                        }
                    } else {
                        System.out.println("Commande introuvable !");
                    }
                }
                case 4 -> { // Retirer un produit d’une commande
                    System.out.print("ID de la commande : ");
                    int orderId = sc.nextInt();
                    sc.nextLine();
                    Order order = store.findOrderById(orderId);
                    if (order != null) {
                        System.out.print("Nom du produit à retirer : ");
                        String productName = sc.nextLine();
                        Product product = store.findProductByName(productName);
                        if (product != null) {
                            System.out.print("Quantité : ");
                            int quantity = sc.nextInt();
                            sc.nextLine();
                            order.removeProduct(product, quantity);
                        } else {
                            System.out.println("Produit introuvable !");
                        }
                    } else {
                        System.out.println("Commande introuvable !");
                    }
                }
                case 5 -> {
                    System.out.print("ID de la commande : ");
                    int orderId = sc.nextInt();
                    sc.nextLine();
                    Order order = store.findOrderById(orderId);
                    if (order != null) {
                        order.toString();
                    } else {
                        System.out.println("Commande introuvable !");
                    }
                }
                case 0 -> System.out.println("Retour au menu principal");
                default -> System.out.println("Choix invalide !");
            }

        } while (choix != 0);
    }
}
