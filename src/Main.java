import java.util.List;
import java.util.Scanner;

public class Main {
    static Bibliothecaire bibliothecaire;
    private static Lecteur lecteur;
    private static Scanner scanner = new Scanner(System.in);
    private static Admin admin = new Admin();

    public static void main(String[] args) {

        bibliothecaire = new Bibliothecaire("Marie", "marie@biblio.com");
        lecteur = new Lecteur("Paul", "paul@lecteur.com");

        // Menu principal
        while (true) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Se connecter en tant qu'Admin");
            System.out.println("2. Se connecter en tant que Bibliothécaire");
            System.out.println("3. Se connecter en tant que Lecteur");
            System.out.println("4. Quitter");
            System.out.print("Choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    menuAdmin();
                    break;
                case 2:
                    menuBibliothecaire();
                    break;
                case 3:
                    menuLecteur();
                    break;
                case 4:
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }
    private static void menuAdmin() {
        while (true) {
            System.out.println("\n--- MENU ADMIN ---");
            System.out.println("1. Créer un bibliothécaire");
            System.out.println("2. Créer un Lecteur");
            System.out.println("3. Lister les bibliothécaires");
            System.out.println("4. Retour au menu principal");
            System.out.print("Choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Nom du bibliothécaire : ");
                    String nomBiblio = scanner.nextLine();
                    System.out.print("Email : ");
                    String emailBiblio = scanner.nextLine();
                    admin.creerBibliothecaire(nomBiblio, emailBiblio);
                    break;
                case 2:
                    System.out.print("Nom du Lecteur : ");
                    String nomlecteur = scanner.nextLine();
                    System.out.print("Email : ");
                    String emailLecteur = scanner.nextLine();
                    admin.creerLecteur(nomlecteur, emailLecteur);
                    break;
                case 3:
                    admin.listerUtilisateurs();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Choix invalide !");
            }
        }
    }
    private static void menuBibliothecaire() {
        while (true) {
            System.out.println("\n--- MENU BIBLIOTHÉCAIRE ---");
            System.out.println("1. Ajouter un livre");
            System.out.println("2. Supprimer un livre");
            System.out.println("3. Rechercher un livre");
            System.out.println("4. Lister les livres");
            System.out.println("5. Retour au menu principal");
            System.out.print("Choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Titre du livre : ");
                    String titre = scanner.nextLine();
                    System.out.print("Auteur du livre : ");
                    String auteur = scanner.nextLine();
                    System.out.print("ISBN : ");
                    String isbn = scanner.nextLine();
                    System.out.print("Année de publication : ");
                    int annee = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nom de la catégorie : ");
                    String nomCategorie = scanner.nextLine();

                    Categorie categorie = new Categorie(nomCategorie);
                    Livre livre = new Livre(titre, auteur, isbn, annee, categorie);
                    bibliothecaire.ajouterLivre(livre);
                    break;
                case 2:
                    System.out.print("Titre du livre à supprimer : ");
                    String titreSup = scanner.nextLine();
                    Livre livreASupprimer = bibliothecaire.rechercherLivre(titreSup);
                    if (livreASupprimer != null) {
                        bibliothecaire.supprimerLivre(livreASupprimer);
                    } else {
                        System.out.println("Livre non trouvé !");
                    }
                    break;
                case 3:
                    /*System.out.print("Titre du livre à rechercher : ");
                    String titreRecherche = scanner.nextLine();
                    Livre livreTrouve = bibliothecaire.rechercherLivre(titreRecherche);
                    if (livreTrouve != null) {
                        System.out.println("Livre trouvé : " + livreTrouve.getTitre() + " de " + livreTrouve.getAuteur());
                    } else {
                        System.out.println("Livre non trouvé !");
                    }*/
                    rechercherLivre();
                    break;
                case 4:
                    bibliothecaire.listerLivres();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }

    private static void menuLecteur() {
        while (true) {
            System.out.println("\n--- MENU LECTEUR ---");
            System.out.println("1. Emprunter un livre");
            System.out.println("2. Retourner un livre");
            System.out.println("3. Rechercher un livre");
            System.out.println("4. Lister les livres disponibles");
            System.out.println("5. Retour au menu principal");
            System.out.print("Choix : ");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {

                case 1:
                    System.out.print("Titre du livre à emprunter : ");
                    String titreEmp = scanner.nextLine();
                    Livre livreAEmprunter = bibliothecaire.rechercherLivre(titreEmp);
                    if (livreAEmprunter != null) {
                        lecteur.emprunterLivre(livreAEmprunter);
                    } else {
                        System.out.println("Livre non disponible !");
                    }
                    break;

                case 2:
                    System.out.print("Titre du livre à retourner : ");
                    String titreRet = scanner.nextLine();
                    Livre livreARetourner = bibliothecaire.rechercherLivre(titreRet);
                    if (livreARetourner != null) {
                        lecteur.retournerLivre(livreARetourner);
                    } else {
                        System.out.println("Livre non trouvé !");
                    }
                    break;
                case 3:
                    /*System.out.print("Titre du livre à rechercher : ");
                    String titreRecherche = scanner.nextLine();
                    Livre livreTrouve = bibliothecaire.rechercherLivre(titreRecherche);
                    if (livreTrouve != null) {
                        System.out.println("Livre trouvé : " + livreTrouve.getTitre() + " de " + livreTrouve.getAuteur());
                    } else {
                        System.out.println("Livre non trouvé !");
                    }*/
                    rechercherLivre();
                    break;
                case 4:
                    bibliothecaire.listerLivres();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }
    }

    private static void rechercherLivre() {
        while (true) {
            System.out.println("Rechercher par :");
            System.out.println("1. Titre");
            System.out.println("2. Catégorie");
            System.out.println("3. Retour au menu principal");
            System.out.print("Choix : ");
            int typeRecherche = scanner.nextInt();
            scanner.nextLine();

            if (typeRecherche == 1) {
                System.out.print("Titre du livre à rechercher : ");
                String titreRecherche = scanner.nextLine();
                Livre livreTrouve = bibliothecaire.rechercherLivre(titreRecherche);
                if (livreTrouve != null) {
                    System.out.println("Livre trouvé : " + livreTrouve.getTitre() + " de " + livreTrouve.getAuteur());
                } else {
                    System.out.println("Livre non trouvé !");
                }
            } else if (typeRecherche == 2) {
                System.out.print("Catégorie à rechercher : ");
                String catRecherche = scanner.nextLine();
                List<Livre> livresTrouves = bibliothecaire.rechercherParCategorie(catRecherche);
                if (livresTrouves.isEmpty()) {
                    System.out.println("Aucun livre trouvé dans cette catégorie.");
                } else {
                    System.out.println("Livres trouvés :");
                    for (Livre l : livresTrouves) {
                        System.out.println("- " + l.getTitre() + " de " + l.getAuteur());
                    }
                }
            } else {
                System.out.println("Choix invalide.");
            }
}}}
