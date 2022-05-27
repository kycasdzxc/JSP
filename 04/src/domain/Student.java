package domain;

public class Student {
	private Long studno;
	private String name;
	private Long deptno;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(Long studno, String name, Long deptno) {
		super();
		this.studno = studno;
		this.name = name;
		this.deptno = deptno;
	}

		public Long getStudno() {
		return studno;
	}
	public void setStudno(Long studno) {
		this.studno = studno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getDeptno() {
		return deptno;
	}
	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}
	
	public String getTest() {
		return "핫하!";
	}
}
