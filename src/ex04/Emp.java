package ex04;

public class Emp {
	// 입력 data : empId, name, hiredate, sal, deptId
		private int empId;
		private String name;
		private String hiredate;
		private double sal;
		private int deptId;
		
		// 출력 data : empId, name, hiredate, sal, bonus, pay, deptName
		private double bonus;
		private double pay;
		private String deptName;
		private int    rank;
		
		// 생성자  -> private 변수 : 외부에서 못씀 -> 외부에서 쓸수있게 만들어줌
		public Emp() {}
		public Emp(int empId, String name, String hiredate, double sal, int deptId) {
			this.empId = empId;
			this.name = name;
			this.hiredate = hiredate;
			this.sal = sal;
			this.deptId = deptId;
		}
		
		// Getter Setter
		public int getEmpId() {
			return empId;
		}
		public void setEmpId(int empId) {
			this.empId = empId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getHiredate() {
			return hiredate;
		}
		public void setHiredate(String hiredate) {
			this.hiredate = hiredate;
		}
		public double getSal() {
			return sal;
		}
		public void setSal(double sal) {
			this.sal = sal;
		}
		public int getDeptId() {
			return deptId;
		}
		public void setDeptId(int deptId) {
			this.deptId = deptId;
		}
		public double getBonus() {
			return bonus;
		}
		public void setBonus(double bonus) {
			this.bonus = bonus;
		}
		public double getPay() {
			return pay;
		}
		public void setPay(double pay) {
			this.pay = pay;
		}
		public String getDeptName() {
			return deptName;
		}
		public void setDeptName(String deptName) {
			this.deptName = deptName;
		}
		public void setRank(int rank) {
			this.rank = rank;
		}
		public int getRank() {
			return rank;
		}

		// toString
		@Override
		public String toString() {
			return "Emp [empId=" + empId + ", name=" + name + ", hiredate=" + hiredate + ", sal=" + sal + ", deptId="
					+ deptId + ", bonus=" + bonus + ", pay=" + pay + ", deptName=" + deptName + ", rank=" + rank + "]";
		}
		
}
