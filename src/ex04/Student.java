package ex04;

public class Student {
	// Fields
	private int num;
	private int score;
	private int rank;

	// Constructor -> private 변수 외부에서 쓸 수 있도록
	public Student() {
	}

	public Student(int num, int score) {
		super();
		this.num = num;
		this.score = score;
	}

	// Getter Setter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	// toString
	@Override
	public String toString() {
		return "Student [num=" + num + ", score=" + score + ", rank=" + rank + "]";
	}
}
