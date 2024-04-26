package ex02;

import java.util.Arrays;
import java.util.Comparator;

// 람다식 쓰는 연습

class Member {
	private int mno;

	// Getter
	public int getMno() {
		return mno;
	}

	// 생성자
	public Member(int mno) {
		this.mno = mno;
	}

	// toString
	@Override
	public String toString() {
		return "Member [mno=" + mno + "]";
	}

}

public class TestMemberSort {

	public static void main(String[] args) {

		Member[] mArr = new Member[] { new Member(128), new Member(27),
				new Member(18), new Member(9), new Member(55),
				new Member(7) };

		// 익명클래스(= 인터페이스를 사용한 클래스)로 정렬하는 방법
		Comparator<Member> compAsc = new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				return o1.getMno() - o2.getMno(); // 오름정렬
			}

		};

		Comparator<Member> compDesc = new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				return o2.getMno() - o1.getMno();
			}

		};

		// 정렬 전
		System.out.println(Arrays.toString(mArr));

		// 오름정렬
		Arrays.sort(mArr, compAsc);
		System.out.println(Arrays.toString(mArr));

		// 내림정렬
		Arrays.sort(mArr, compDesc);
		System.out.println(Arrays.toString(mArr));

		System.out.println("================================");
		// -----------------------------------------------------

		System.out.println(Arrays.toString(mArr));
		Arrays.sort( mArr, new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				return o1.getMno() - o2.getMno();
			}
			
		});
		System.out.println(Arrays.toString(mArr));

		System.out.println("================================");
		// -----------------------------------------------------

		// 람다식 - jdk 1.8 이상만 가능
		System.out.println(Arrays.toString(mArr));
		Arrays.sort( mArr, (a, b) -> {
			return b.getMno() - a.getMno();
		});
		System.out.println(Arrays.toString(mArr));
		
	}

}
