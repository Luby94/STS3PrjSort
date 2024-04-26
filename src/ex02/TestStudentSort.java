package ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// .compareTo() 함수 사용하기 위해 Comparable 인터페이스를 구현
class Student implements Comparable {
	private int    sno;
	private String name;
	
	
	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(int sno, String name) {
		this.sno   =  sno;
		this.name  =  name;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Object o) {
		Student s = (Student) o;  // o.sno 즉 Object 안에 sno변수 없기에 하는 작업
		return this.sno - s.sno;
	}
	
}

public class TestStudentSort {

	public static void main(String[] args) {
		
		Student [] stud = new Student[5];  // stud 담길 빈공간 5개 생성
		                                   // type : []
		                                   // new : Student 클래스 생성
		stud[0] = new Student( 1, "카리나" );
		stud[1] = new Student( 5, "윈터" );
		stud[2] = new Student( 4, "안유진" );
		stud[3] = new Student( 2, "장원영" );
		stud[4] = new Student( 6, "미나" );
		
		disp( stud );  // public 함수 -> Method (외부에 노출)
		               // private 함수 -> 외부에서 못씀
		// 번호 오름차순 정렬 -> 번호, 이름 둘 중 뭐로 오름차순 할 것인가 : 번호
		Arrays.sort( stud );
		disp(stud);
		
		//----------------------------------------------------------
		System.out.println("================ArrayList배열================");
		
		ArrayList<Student> sList = new ArrayList<>();
		sList.add( new Student( 10, "나나" ) );
		sList.add( new Student( 20, "가나" ) );
		sList.add( new Student( 16, "사나" ) );
		sList.add( new Student( 13, "다나" ) );
		sList.add( new Student( 11, "하나" ) );
		sList.add( new Student( 15, "자나" ) );
		
		dispList( sList );
		System.out.println("------------------------");
		// Collections.sort( sList );
		Collections.sort( sList, new Comparator<Student> () {

			@Override
			public int compare(Student o1, Student o2) {
				// return o2.getSno() - o1.getSno();
				return o2.getName().compareTo( o1.getName() );
			}

		});
		dispList( sList );

	}

	private static void dispList(ArrayList<Student> sList) {
		
		for (Student stud : sList) {
			System.out.println( stud + " " );
		}
		System.out.println();
	}

	private static void disp(Student[] stud) {
		
		for (int i = 0; i < stud.length; i++) {
			System.out.print( stud[i] + " " );
		}
		System.out.println();
		
	}

}
