package Ex3;

public class Student {
	
	private String name;
	private String hb;
	private String dept;
	private String gwamok;
	
	Student() {}
	Student(String name, String hb, String dept, String gwamok) {
		this.name = name;
		this.hb = hb;
		this.dept = dept;
		this.gwamok = gwamok;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHb() {
		return hb;
	}
	public void setHb(String hb) {
		this.hb = hb;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getGwamok() {
		return gwamok;
	}
	public void setGwamok(String gwamok) {
		this.gwamok = gwamok;
	}
	@Override
	public String toString() {
		return "이름" + name + ", 학번:" + hb + ", 학과:" + dept + ", 과목:" + gwamok;
	}
	
	
	

}
