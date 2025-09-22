package moviescatalog;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Scanner sc = new Scanner(System.in);
        int choix;

        do {
            System.out.println("--- Menu Principal ---");
            System.out.println("1 - Gérer les Produits");
            System.out.println("2 - Gérer les Clients");
            System.out.println("0 - Quitter");
            System.out.println("Votre choix: ");

            choix = sc.nextInt();

            sc.nextLine();
            switch (choix) {
                case 1 -> menuProduits(store, sc);
                case 2 -> menuClients(store, sc);
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

}
