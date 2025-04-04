public class Livre {
    private String titre;
    private  String auteur;
    private String ISBN;
    private int annePublication;

    private Categorie categorie;


    public Livre() {
    }

    public Livre(String titre, String auteur, String ISBN, int annePublication, Categorie categorie) {
        this.titre = titre;
        this.auteur = auteur;
        this.ISBN = ISBN;
        this.annePublication = annePublication;
        this.categorie = categorie;
    }


    public void emprunter(){
        System.out.println("Le lire \"" + this.titre + "\" a été emprunté" );
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getAnnePublication() {
        return annePublication;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setAnnePublication(int annePublication) {
        this.annePublication = annePublication;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
