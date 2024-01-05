package all.dto; 

import java.sql.Date;

// VO : Value Object : DB로부터 읽기전용객체 
public class All {
	private int empno;
	private String ename;
	private Integer deptno;
	private String dname;
	private String loc;
	
	public All() {}
	public All(int empno, String ename, Integer deptno, String dname, String loc) {
		this.empno = empno;
		this.ename = ename;
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	

	@Override
	public String toString() {
		return "All [empno=" + empno + ", ename=" + ename + ", deptno=" + deptno + ", dname=" + dname + ", loc=" + loc
				+ "]";
	}
}
