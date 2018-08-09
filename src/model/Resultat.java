package model;

public class Resultat extends Reponse {
	
	private int idParcour;




	public Resultat(int id, String reponse, int idParcour) {
		super(id, reponse);
		this.idParcour = idParcour;
	}

	public int getIdParcour() {
		return idParcour;
	}

	public void setIdParcour(int idParcour) {
		this.idParcour = idParcour;
	}
	
	

	
	
}
