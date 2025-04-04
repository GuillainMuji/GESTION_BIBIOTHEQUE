import java.util.ArrayList;
import java.util.List;

public class Admin {
    private List<Bibliothecaire> bibliothecaires;
    private List<Lecteur> lecteurs;

    public Admin() {
        this.bibliothecaires = new ArrayList<>();
        this.lecteurs = new ArrayList<>();
    }

    public void creerBibliothecaire(String nom, String email) {
        Bibliothecaire biblio = new Bibliothecaire(nom, email);
        bibliothecaires.add(biblio);
        System.out.println("Bibliothécaire créé : " + nom);
    }

    public void creerLecteur(String nom, String email) {
        Lecteur lecteur = new Lecteur(nom, email);
        lecteurs.add(lecteur);
        System.out.println("Lecteur créé : " + nom);
    }

    public Bibliothecaire getBibliothecaire(String nom) {
        for (Bibliothecaire b : bibliothecaires) {
            if (b.getNom().equalsIgnoreCase(nom)) {
                return b;
            }
        }
        return null;
    }

    public Lecteur getLecteur(String nom) {
        for (Lecteur l : lecteurs) {
            if (l.getNom().equalsIgnoreCase(nom)) {
                return l;
            }
        }
        return null;
    }

    public void listerUtilisateurs() {
        System.out.println("\n--- Bibliothécaires ---");
        for (Bibliothecaire b : bibliothecaires) {
            System.out.println("- " + b.getNom() + " (" + b.getEmail() + ")");
        }

        System.out.println("\n--- Lecteurs ---");
        for (Lecteur l : lecteurs) {
            System.out.println("- " + l.getNom() + " (" + l.getEmail() + ")");
        }
    }
}
