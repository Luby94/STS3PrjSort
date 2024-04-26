package ex04;

import java.util.ArrayList;

public class TestRank2 {

	public static void main(String[] args) {

		ArrayList<Student> sList = new ArrayList<Student>();
		
		// 입력
		sList.add(new Student(1, 100));
		sList.add(new Student(2, 95));
		sList.add(new Student(9, 75));
		sList.add(new Student(3, 85));
		sList.add(new Student(6, 90));
		sList.add(new Student(8, 90));
		sList.add(new Student(4, 80));
		
		// 석차구하기
		int rank = 1;  // s.setRank () 안에 넣을 변수
		int max = sList.size();
		for (int i = 0; i < max; i++) {
			Student s = sList.get(i);
			for (int j = 0; j < max; j++) {
				if( sList.get(i).getScore() < sList.get(j).getScore() ) {
					rank++;
				}
			}
			s.setRank( rank );
			rank = 1;  // 다시 rank 값은 1로 시작해야함
		}
		
		// 출력
		for (Student student : sList) {
			System.out.println( student );
		}		

	}

}
