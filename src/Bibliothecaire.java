import java.util.ArrayList;
import java.util.List;

public class Bibliothecaire extends Utilisateur {
    private static List<Livre> livres;

    public Bibliothecaire(String nom, String email) {
        super(nom, email);
        this.livres = new ArrayList<>();
    }

    public void ajouterLivre(Livre livre) {
        livres.add(livre);
        System.out.println("Livre ajouté : " + livre.getTitre() + " a été ajouté");
    }

    public void supprimerLivre(Livre livre) {
        if (livres.remove(livre)) {
            System.out.println("Livre supprimé : " + livre.getTitre());
        } else {
            System.out.println("Livre non trouvé !");
        }
    }

    public void emprunterLivre(Livre livre) {
        if (livres.remove(livre)) {
            System.out.println("livre a été emprunter: " + livre.getTitre());
        } else {
            System.out.println("Livre non trouvé !");
        }
    }

    public void listerLivres() {
        if (livres.isEmpty()) {
            System.out.println("Aucun livre disponible.");
        } else {
            System.out.println("\n--- LISTE DES LIVRES ---");
            for (Livre livre : livres) {
                System.out.println("Titre : " + livre.getTitre() + "\n" +
                        "Auteur : " + livre.getAuteur() + "\n" +
                        "Catégorie : " + livre.getCategorie().getNom() + "\n" +
                        "_______________________________________________________");

            }
        }
    }

    public List<Livre> getLivres() { return livres; }

    public Livre rechercherLivre(String titre) {
        for (Livre livre : livres) {
            if (livre.getTitre().equalsIgnoreCase(titre)) {
                return livre;
            }
        }
        return null;
    }

    public List<Livre> rechercherParCategorie(String categorie) {
        List<Livre> resultats = new ArrayList<>();
        for (Livre livre : livres) {
            if (livre instanceof Categorie) {
                Categorie catLivre = (Categorie) livre;
                if (catLivre.getNom().equalsIgnoreCase(categorie)) {
                    resultats.add(catLivre);
                }
            }
        }
        return resultats;
    }
}
