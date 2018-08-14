package model;

import java.util.List;

public class Quizz {
	
	private int id;
	private Competence sujet;
	private List<Question> question;
	

	
	public Quizz(int id, Competence sujet, List<Question> question) {
		super();
		this.id = id;
		this.sujet = sujet;
		this.question = question;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Competence getSujet() {
		return sujet;
	}
	public void setSujet(Competence sujet) {
		this.sujet = sujet;
	}
	public List<Question> getQuestion() {
		return question;
	}
	public void setQuestion(List<Question> question) {
		this.question = question;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this.getId()==((Quizz)obj).getId()) return true;
		else return false;
	
	}
	

}
