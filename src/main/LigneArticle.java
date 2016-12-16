package main;

public class LigneArticle {

    private Article article;
    private int quantite;
    private float sousTotal;

    /** Constructeur pour cree une ligne d'un article 
     * @param a article
     * @param qte quantite
     */
    public LigneArticle(Article a, int qte) {
        this.article = a;
        this.quantite = qte;
        this.sousTotal = this.article.getPrix() * qte;
    }

    public Article getArticle() {
        return article;
    }

    public int getQuantite() {
        return quantite;
    }

    public float getSousTotal() {
        return sousTotal;
    }

}
