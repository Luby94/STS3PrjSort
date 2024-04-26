package ex01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestArrayListSort {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(5);
		list.add(34);
		list.add(28);
		list.add(16);
		
		disp_list( list );  // display_list : 출력
		// sort asc
		// Collections.sort(list);
		// sort desc
		
		// Collections.sort( list, Collections.reverseOrder() );
		// 익명 클래스 : Anonymous -> interface 뒤에 {} 붙여서 class인것처럼 구현
		// Set<String> set = new HashSet<>();
		Comparator<Integer> comp1 = new Comparator<>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
			
		};

		Comparator<Integer> comp2 = new Comparator<>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
			
		};
		
		Collections.sort(list, comp2);
		
		/*
		Collections.sort( list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
				// return o1 - o2;
			}
			
		} );
		*/
	    
		disp_list( list );
	    
	    
	    
	    //------------------------------
	    
	    ArrayList<String> names = new ArrayList<>();
	    names.add("이순신");
	    names.add("김유신");
	    names.add("강감찬");
	    names.add("킹세종");
	    names.add("을지문덕");
	    
	    disp_name(names);
	    Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {			
				return  o2.compareTo(o1);
			}	    	
	    });
	    disp_name(names);
	    
	}

	private static void disp_name(ArrayList<String> names) {
		for (String name : names) {
			System.out.print(name + " ");
		}
		System.out.println();
	}

	private static void disp_list(ArrayList<Integer> list) {
		// foreach
		for (Integer num : list) {
			// System.out.printf( num + " " );
			System.out.printf( "%2d ", num );
		}
		System.out.println();	
	}

}









