package ex04;

import java.util.ArrayList;
import java.util.Collections;

public class TestRank {

	public static void main(String[] args) {

		// 입력
		ArrayList<Student> sList = new ArrayList<Student>();

		sList.add(new Student(1, 100));
		sList.add(new Student(2, 95));
		sList.add(new Student(9, 75));
		sList.add(new Student(3, 85));
		sList.add(new Student(6, 90));
		sList.add(new Student(8, 90));
		sList.add(new Student(4, 80));

		// 석차구하기
		// 1. 점수 순으로 내림차순 정렬
		Collections.sort(sList, (Student o1, Student o2) -> {
			// 람다식 안에 Student type을 안써도 실행되지만 써주는게 맞음
			return o2.getScore() - o1.getScore();
		});
		// 2. 석차 rank 부여
		int prevScore = 0;
		for (int i = 0; i < sList.size(); i++) {
			// ArrayList : .length 아니라 .size()
			// sList.get(i) = 번호 점수 석차 1줄(1, 100, ? <- set하기)
			Student s = sList.get(i);
			if (s.getScore() == prevScore) { // 이전 학생의 점수와 비교 -> 같으면
				s.setRank(sList.get(i - 1).getRank());
			} else { // 이전 학생의 점수와 비교 -> 다르면
				s.setRank(i + 1);
				prevScore = s.getScore(); // 이전 점수에 현재 점수를 대입하여 다시 위로
			}
		}

		// 출력 - 반복가능
		// foreach - ctrl+space 위에서 4번째
		for (Student student : sList) {
			// System.out.println( student ); // 실행 시 heap메모리 위치값
			System.out.println(student); // toString 추가 후 실행
		}

	}

}
