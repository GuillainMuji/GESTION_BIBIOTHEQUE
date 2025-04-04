public class Biographie extends Livre{
    private String sujet;

    public Biographie(){}

    public Biographie(String titre, String auteur, String ISBN, int annePublication, Categorie categorie, String sujet) {
        super(titre, auteur, ISBN, annePublication, categorie);
        this.sujet = sujet;
    }
}
