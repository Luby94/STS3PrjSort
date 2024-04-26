package ex01;

import java.util.Arrays;
import java.util.Comparator;

class Member {
	private   int  mno;

	public Member(int mno) {
		this.mno = mno;
	}
	
    // Getter
	public int getMno() {
		return mno;
	}

	@Override
	public String toString() {
		return "Member [mno=" + mno + "]";
	}
	
}

public class TestMemberSort {

	public static void main(String[] args) {

		// 익명클래스(Anonymous class) 사용
		// 인터페이스를 이용한 익명 class
		Comparator<Member>  compAsc = new Comparator<>() {
			@Override
			public int compare(Member o1, Member o2) {			
				return o1.getMno() - o2.getMno();
			}			
		};
		
		Comparator<Member>  compDesc = new Comparator<>() {
			@Override
			public int compare(Member o1, Member o2) {			
				return o2.getMno() - o1.getMno();
			}			
		};
		
		/*
		Member []  mArr = new Member[6];
		mArr[0]  = new Member(123);
		mArr[1]  = new Member(7);
		mArr[2]  = new Member(13);
		mArr[3]  = new Member(3);
		mArr[4]  = new Member(13);
		mArr[5]  = new Member(26);
		*/
		
		Member []  mArr = new Member[] {
			new Member(123), new Member(7), new Member(13),
			new Member(3), new Member(13), new Member(26)  
		};
		
		System.out.println( Arrays.toString( mArr ) );
		Arrays.sort( mArr, compAsc );   // 오름차순
		System.out.println( Arrays.toString( mArr ) );
				
		// desc
		// Arrays.sort( mArr, compDesc );
		/*
		Arrays.sort(mArr, new Comparator<>() {

			@Override
			public int compare(Member o1, Member o2) {				
				return o2.getMno() - o1.getMno();
			}
			
		});
		*/
		Arrays.sort(mArr, (o1, o2) -> {
			return o2.getMno() - o1.getMno();					
		});
		
		System.out.println( Arrays.toString( mArr ) );

	}

}







