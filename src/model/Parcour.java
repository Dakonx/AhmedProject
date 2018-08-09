package model;

public class Parcour {
	
	private int id;
	private Quizz quizz;
	private int score;
	private float temps; 
	
	
	public Parcour(int id, Quizz quizz, int score, float temps) {

		this.quizz = quizz;
		this.score = score;
		this.id = id;
		this.temps = temps;
	}


	public Quizz getQuizz() {
		return quizz;
	}


	public void setQuizz(Quizz quizz) {
		this.quizz = quizz;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public float getTemps() {
		return temps;
	}


	public void setTemps(float temps) {
		this.temps = temps;
	}
	
	
	


	
	
	
	
	

}
