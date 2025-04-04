public class ScienceFiction extends Livre{
    private String univers;

    public ScienceFiction(){}

    public ScienceFiction(String titre, String auteur, String ISBN, int annePublication, Categorie categorie, String univers) {
        super(titre, auteur, ISBN, annePublication, categorie);
        this.univers = univers;
    }
}
