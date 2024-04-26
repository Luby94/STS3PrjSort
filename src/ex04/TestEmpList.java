package ex04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

// 입력 n줄 -> 결과 n줄 -> 한번에 출력
// 입력data : 사번,이름,입사일,월급,부서번호
//         empId, name, hiredate, sal, deptId 
// 출력     : 사번,이름,입사일,월급,보너스,수령액,부서명
//         empId, name, hiredate, sal, bonus, pay, deptName
// 금액은 소수이하 두자리로 반올림
// 보너스   =  근무연수에 따라 월급의 0.5% 로 계산한다
// 수령액   =  월급 + 보너스
// 부서명   =  10:인사,20:자재,30:총무,40:연구개발,50:생산,60:서비스

// 모든기능은 class에 구현한다.
// 입력data
/*
사번,이름,입사일,월급,부서번호
400,나연,20110105,220.0,40
100,사나,20110101,300.0,10
600,쯔위,20150801,200.0,50
300,정연,20091003,250.0,30
500,미나,20180401,170.0,60
200,모모,20120301,270.0,20
700,태연,20220401,300.0,40
exit
*/

public class TestEmpList {

	// Scanner in 밑에 ArrayList<Emp> empList = new ArrayList<>();
	// 생성 후 while문 생성 후 여기로 옮기고 '= new~' 아래로 이동
	// private static 추가
	// AllayList : 실행할때 사이즈가 변하는 배열
	// 초기값 null
	private static ArrayList<Emp> empList = null;

	public static void main(String[] args) {

		empList = new ArrayList<Emp>();

		input();
		process();
		output();

	}

	private static void input() {

		Scanner in = new Scanner(System.in);
		System.out.println("사번,이름,입사일,월급,부서번호(종료:exit)");

		// 무한루프 : 종료조건 필수
		while (true) {
			// String line = in.nextLine();
			String line = in.nextLine().trim(); // 한줄 , 공백제거
			// if( line.equals("exit") )
			if (line.toLowerCase().equals("exit"))
				break; // 반복 중지

			String[] li = line.split(",");
			int empId = Integer.parseInt(li[0]);
			String name = li[1];
			String hiredate = li[2];
			double sal = Double.parseDouble(li[3]);
			int deptId = Integer.parseInt(li[4]);

			// Emp emp = new Emp( empId, name, hiredate, sal, deptId ); // 인자있는 생성자
			Emp emp = new Emp(); // 기본생성자 필요
			emp.setEmpId(empId); // 가져올땐 get, 설정할땐 set
			emp.setName(name);
			emp.setHiredate(hiredate);
			emp.setSal(sal);
			emp.setDeptId(deptId);

			empList.add(emp);
		}

	}

	private static void process() {
		// 금액은 소수이하 두자리로 반올림
		// 아래 계산들 반복 필요 -> for

		for (int i = 0; i < empList.size(); i++) {
			Emp emp = empList.get(i);
			// empList.size() : empList.add() 할때 size 커짐

			// 보너스 = 근무연수에 따라 월급의 0.5% 로 계산한다
			LocalDate now = LocalDate.now(); // 오늘날짜 가져오는 로직
			int thisYear = now.getYear(); // 2024
			int hireYear = Integer.parseInt(emp.getHiredate().substring(0, 3 + 1)); // 2011
			double bonus = emp.getSal() * (thisYear - hireYear) * 0.005;
			// emp.getSal() : 300.0
			// thisYear - hireYear : (2024-2011) = 13
			// bonus = 300.0 * 13 * 0.005 = 19.5
			emp.setBonus(bonus); // bonus 를 emp에 set 함

			// 수령액 = 월급 + 보너스
			double pay = emp.getSal() + bonus;
			emp.setPay(pay);

			// 부서명 = 10:인사,20:자재,30:총무,40:연구개발,50:생산,60:서비스
			String dname = "";
			HashMap<Integer, String> map = new HashMap<>();
			map.put(10, "인사"); // (key, value) -> get할 때 key가지고 빼냄
			map.put(20, "자재");
			map.put(30, "총무");
			map.put(40, "연구개발");
			map.put(50, "생산");
			map.put(60, "서비스");
			emp.setDeptName(map.get(emp.getDeptId()));

			/*
			// 석차1
			int rank = 1;
			int max = empList.size();
			for (int k = 0; k < max; k++) {
				Emp e = empList.get(k);
				for (int j = 0; j < max; j++) {
					if (empList.get(k).getPay() < empList.get(j).getPay()) {
						rank++;
					}
				}
				e.setRank(rank);
				rank = 1;
			}
			*/
			
			// 석차2
			double prevPay = 0;
			for (int jj = 0; jj < empList.size(); jj++) {
				// Emp ee = empList.get(jj);
				if( emp.getPay() == prevPay ) {
					emp.setRank( empList.get(jj - 1).getRank() );
				} else {
					emp.setRank( jj+1 );
				}
				prevPay = emp.getPay();
			}
			
			// 정렬 : ArrayList 석차 기준 desc:내림차순
			// 정렬 : 모든 배열 대상 -> 계산 완료된 배열
			Collections.sort(empList, (a, b) -> {
				return (int) (a.getPay() - b.getPay());
			});
			 
		}

	}

	private static void output() {
		String msg = "";
		String title = "사번,이름,입사일,월급,보너스,수령액,부서명,석차\n";
		for (int i = 0; i < empList.size(); i++) {
			// System.out.println( empList.get(i) );
			Emp emp = empList.get(i);
			String fmt = "%3d %2s %8s %6.2f %6.2f %7.2f %3s %4d\n";
			msg = msg + String.format(fmt, emp.getEmpId(), emp.getName(), emp.getHiredate(), emp.getSal(),
					emp.getBonus(), emp.getPay(), emp.getDeptName(), emp.getRank());
		}
		msg = title + msg;
		System.out.println(msg);
	}

}
