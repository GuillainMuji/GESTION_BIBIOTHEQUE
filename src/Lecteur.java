public class Lecteur extends Utilisateur{
    public Lecteur() {
    }

    public Lecteur(String nom, String email) {
        super(nom, email);
    }

    public void emprunterLivre(Livre livre) {
        if (livre != null) {
            System.out.println(nom + " a emprunté le livre : " + livre.getTitre());
            Main.bibliothecaire.emprunterLivre(livre);
        } else {
            System.out.println("Ce livre n'est pas disponible !");
        }
    }
    public void retournerLivre(Livre livre){
        System.out.println(this.nom +" a retourné le livre " + livre.getTitre());
    }
}
