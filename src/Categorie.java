    public class Categorie extends Livre {
        private String nom;

        public Categorie(String nomCategorie) {
        }

        public Categorie(String titre, String auteur, String ISBN, int annePublication, Categorie categorie, String nom) {
            super(titre, auteur, ISBN, annePublication, categorie);
            this.nom = nom;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }
    }
