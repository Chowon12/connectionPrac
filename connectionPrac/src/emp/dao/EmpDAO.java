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
		// getEmpList
		// Query : SELECT * FROM emp;
		public static ArrayList<Emp> getEmpList() throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;

			ArrayList<Emp> empList = null;
			
			String sql = "SELECT * FROM emp";
			
			try {
				con = DBUtil.getConnection();
				
				pstmt = con.prepareStatement(sql);
				
				rset = pstmt.executeQuery();
				
				empList = new ArrayList<Emp>();
				while(rset.next()) {
					empList.add(new Emp(rset.getInt("empno"),
										  rset.getString("ename"),
										  rset.getInt("deptno")));
				}
			}finally {
				DBUtil.close(rset, pstmt, con);
			}
			
			return empList;
		}
		
	
	// getEmpByEmpnoAndEname
	// Query : SELECT * FROM emp WHERE empno = ? AND ename = ?
	public static Emp getEmpByEmpno(int empno) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		Emp emp = null;
		
		String sql = "SELECT * FROM emp WHERE empno = ?";
		
		try {
			con = DBUtil.getConnection();
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
	
	// deleteDept
		// Query : DELETE FROM emp WHERE empno = ?
		public static boolean deleteDeptByDeptno(int empno) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;

			int result = 0;
			
			String sql = "DELETE FROM emp WHERE empno = ?";
			
			try {
				con = DBUtil.getConnection();
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, empno);
				
				result = pstmt.executeUpdate();
				
				if(result  !=0) {
					return true;
				}
				
				result = pstmt.executeUpdate();
				
				if(result !=0) {
					return true;
				}
			}finally {
				DBUtil.close(pstmt, con);
			}
			
			return false;
		}

}