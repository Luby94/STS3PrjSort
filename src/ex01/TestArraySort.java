package ex01;

import java.util.Arrays;
import java.util.Collections;

public class TestArraySort {

	public static void main(String[] args) {
		
		// 정렬 : Sorting
		// 오름차순 ascending  1 2 3 4, 가나다 순, 사전순, 투수방어율
		// 내림차순 descending 9 8 7 6, zyx 순, 성적순, 홈런수, 두수 승수
		
		// int [] arr1 = { 1, 5, 3, 2, 4 };
		// int      []  arr1 = new int [] { 1, 5, 3, 2, 4 };
		Integer  []  arr1 = new Integer [] { 1, 5, 3, 2, 4 };
		Integer  []  arr2 = { 10, 50, 32, 64, 72 };
		Double   []  arr3 = { 12.5, 3.8, 2.145, 16.8 };

		System.out.println("1.");
		System.out.println( Arrays.toString( arr1 ) );
		
		// 순서대로 출력 : 작은값 앞으로 큰값 뒤로 - 정렬(sort) : ascending	(오름차순)	
		Arrays.sort( arr1 );  // 아무 옵션 없으면 오름차순
		
		// Arrays.sort( arr1, (a,b) -> { return a - b; }  );	// error : int
		System.out.println( "asc: " + Arrays.toString( arr1 ) );
		Arrays.sort( arr1, (a, b) -> b - a );  // int -> Integer로 변환 후 가능
		System.out.println( "desc: " + Arrays.toString( arr1 ) );
		
		System.out.println("=============1. end==================\n");
		
		System.out.println("2.");
		System.out.println( Arrays.toString(arr2) );
		
		// (a,b) -> { return b - a; }  : 람다식 : java 1.8 부터 가능
		// int func(int a, int b) {
		//      retrun b - a;
	    // }
		//Arrays.sort( arr2 );
		Arrays.sort( arr2, (a,b) -> { return b - a; }  );	// 동작 : Integer(객체타입만 가능)
		System.out.println( "desc: " + Arrays.toString(arr2) );
		Arrays.sort( arr2, (a,b) -> { return a - b; }  );	// 동작 : Integer(객체타입만 가능)
		System.out.println( "asc: " + Arrays.toString(arr2) );
		System.out.println("=============2. end=================\n");
		
		System.out.println("3.");
		// 순서대로 출력 : 큰값이 앞으로 작은값 뒤로 - 정렬(sort) - descending (내림차순)
		System.out.println( Arrays.toString(arr3) );
		
		Arrays.sort( arr3, Collections.reverseOrder() );	// desc
		
		System.out.println( "desc: " + Arrays.toString(arr3) );
		
		Arrays.sort( arr3 );
		
		System.out.println( "asc: " + Arrays.toString(arr3) );
		
		System.out.println("=============3. end=================\n");
		
		//-------------------------------------------------
		// java 1.8  람다식 - 
		String [] names = {"아이유", "유진", "카리나", "윈터", "가을", "이서"};
		
		System.out.println( "원본: " + Arrays.toString( names ) );
		Arrays.sort( names );  // 오름차순		
		//Arrays.sort( names, (a, b) -> { return a - b;  } );  // String 문자열이라서 - 안됨
		Arrays.sort( names, (a, b) -> { return a.compareTo(b);  } );  // 오름차순
		System.out.println( "asc: " + Arrays.toString( names ) );
		Arrays.sort( names, (a, b) -> { return b.compareTo(a);  } );  // 내림차순
		System.out.println( "desc: " + Arrays.toString( names ) );
		
	}

}








