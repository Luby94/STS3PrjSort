package ex01;

import java.util.Arrays;

class Student implements Comparable {
	private  int  sno;
	public   Student(int sno) {
		this.sno = sno;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + "]";
	}
	@Override
	public int compareTo(Object o) {
		Student s = (Student) o;
	//	return this.sno -  s.sno;  // asc
		return s.sno -  this.sno;  //desc
	}   

}

public class TestClassSort {

	public static void main(String[] args) {
		Student  []  studArr = new Student[] {
			new Student(15), new Student(7), new Student(12),	
			new Student(2), new Student(30), new Student(19),	
			new Student(3), new Student(20), new Student(15),	
			new Student(7), new Student(9),  new Student(1)			
		};
		
		dispArr( studArr );
		Arrays.sort( studArr );
		dispArr( studArr );

	}

	private static void dispArr(Student[] studArr) {
		for (Student student : studArr) {
			System.out.println(student);
		}
		System.out.println("===========================");
	}

}















