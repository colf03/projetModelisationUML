package main;


public class LigneArticle {
	
	private Article article;
	private int quantite ;
	private float sousTotal;

	public LigneArticle (Article a, int qte) {
		this.article=a ;	
		this.quantite=qte;
		this.sousTotal=this.article.getPrix()*qte;
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
