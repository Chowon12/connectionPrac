package emp.dao; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.util.DBUtil;
import dept.dto.Dept;
import emp.dto.Emp;

public class EmpDAO {
	// getEmpByEmpnoAndEname
	// Query : SELECT * FROM emp WHERE empno = ? AND ename = ?
	public static Emp getEmpByEmpnoAndEname(int empno, String ename) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		Emp emp = null;
		
		String sql = "SELECT * FROM emp WHERE empno = ? AND ename = ?";
		
		try {
			con = DBUtil.getConnection();
			
			//
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, empno);
			pstmt.setNString(2, ename);
			
			rset = pstmt.executeQuery();
		
				
					
			
			if(rset.next()) {
				// ?
				emp = new Emp(
						rset.getInt(1),
						rset.getString(2),
						rset.getString(3),
						rset.getInt(4),
						rset.getDate(5),
						rset.getFloat(6),
						rset.getInt(7),
						rset.getInt(8)
						
						);
						
			}
		}finally {
			DBUtil.close(rset, pstmt, con);
		}
		
		return emp;
	}
	public static Emp getEmpByEmpno(int empno) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		Emp emp = null;
		
		String sql = "SELECT * FROM emp WHERE empno = ?";
		
		try {
			con = DBUtil.getConnection();
			
			// 
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				emp = new Emp(
							rset.getInt(1),
							rset.getString(2),
							rset.getString(3),
							rset.getInt(4),
							rset.getDate(5),
							rset.getFloat(6),
							rset.getInt(7),
							rset.getInt(8));
			}
		}finally {
			DBUtil.close(rset, pstmt, con);
		}
		return emp;
}
	
//	public static ArrayList<Emp> getEmpList() {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		
//		ArrayList<Emp> empList = null;
//		String sql = "Select * From emp";
//		
//		try {
//			con = DBUtil.getConnection();
//			
//			pstmt = con.prepareStatement(sql);
//			
//			rset = pstmt.executeQuery();
//			
//			empList = new ArrayList<Emp>();
//			while(rset.next()) {
//				empList.add(new Emp(rset.getInt("empno"),
//									rset.getString("ename"),
//									rset.getNString("job"),
//									rset.getInt("mgr"),
//									rset.getDate("hiredate"),
//									rset.getFloat("sal"),
//									rset.getInt("comm"),
//									rset.getInt("deptno")));
//									
//				}finally {
//					DBUtil.close(rset, pstmt, con);
//				}
//		return empList
//	}
	
	
	
	
	
	
	
	
	
}
