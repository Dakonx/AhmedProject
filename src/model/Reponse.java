package model;

public class Reponse {
	
	private int id;
	private String text;
	
	
	
	
	
	public Reponse(int id, String reponse) {
		super();
		this.id = id;
		this.text = reponse;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReponse() {
		return text;
	}
	public void setReponse(String reponse) {
		this.text = reponse;
	}
	
	


}