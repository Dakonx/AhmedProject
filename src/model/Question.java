package model;

public class Question {
	
	private int id;
	private String intitul�;
	private Reponse reponseCorrect;
	
	
	
	
	
	public Question(int id, String intitul�, Reponse reponse) {
		super();
		this.id = id;
		this.intitul� = intitul�;
		this.reponseCorrect = reponse;
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIntitul�() {
		return intitul�;
	}
	public void setIntitul�(String intitul�) {
		this.intitul� = intitul�;
	}
	public Reponse getReponseCorrect() {
		return reponseCorrect;
	}
	public void setReponseCorrect(Reponse reponseCorrect) {
		this.reponseCorrect = reponseCorrect;
	}
	
	
	
	

}
