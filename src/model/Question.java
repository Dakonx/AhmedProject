package model;

public class Question {
	
	private int id;
	private String intitulé;
	private Reponse reponseCorrect;
	
	
	
	
	
	public Question(int id, String intitulé, Reponse reponse) {
		super();
		this.id = id;
		this.intitulé = intitulé;
		this.reponseCorrect = reponse;
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIntitulé() {
		return intitulé;
	}
	public void setIntitulé(String intitulé) {
		this.intitulé = intitulé;
	}
	public Reponse getReponseCorrect() {
		return reponseCorrect;
	}
	public void setReponseCorrect(Reponse reponseCorrect) {
		this.reponseCorrect = reponseCorrect;
	}
	
	
	
	

}
