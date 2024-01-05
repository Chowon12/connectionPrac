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
<<<<<<< HEAD
			
			return empList;
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

	public static boolean deleteEmpbyEmpno(int empno) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
			
		int result = 0;
			
		String sql = "DELETE FROM emp WHERE empno = ?";
	
		
		try {
			
	
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empno);
			
<<<<<<< HEAD
=======
				return empList;
	}

	public static Emp getEmpbyEmpno(int empno) throws SQLException {
		Emp emp = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM emp WHERE empno = ?";
		
		try {
			con = DBUtil.getConnection();

			//
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, empno);
			
>>>>>>> Create2
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				emp = new Emp(
<<<<<<< HEAD
							rset.getInt(1),
							rset.getString(2),
							rset.getString(3),
							rset.getInt(4),
							rset.getDate(5),
							rset.getFloat(6),
							rset.getInt(7),
							rset.getInt(8));
=======
						rset.getInt(1),
						rset.getString(2),
						rset.getString(3),
						rset.getInt(4),
						rset.getDate(5),
						rset.getFloat(6),
						rset.getInt(7),
						rset.getInt(8)
						);
						
						
			
>>>>>>> Create2
=======
			result = pstmt.executeUpdate();
			
			if(result !=0) {
				return true;
>>>>>>> Delete_2
			}

		} finally {
			DBUtil.close(pstmt, con);
		}
		
<<<<<<< HEAD
		return emp;
	
	}
<<<<<<< HEAD
=======

	
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

	public static boolean deleteEmpbyEmpno(int empno) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
			
		int result = 0;
			
		String sql = "DELETE FROM emp WHERE empno = ?";

		return false;
	}
	
	
	
	
	
	public static boolean insertEmp(Emp newEmp) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		int result = 0;
		
		String sql = "INSERT INTO emp(empno, ename, deptno) VALUES (?, ?, ?)";
		
		try {
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, newEmp.getEmpno());
			pstmt.setString(2, newEmp.getEname());
			pstmt.setInt(3, newEmp.getDeptno());
			
			result = pstmt.executeUpdate();
			
			if(result != 0) {
				return true;
			}
			
		}finally {
			DBUtil.close(pstmt, con);
		}
		return false;
	}

	



>>>>>>> Create2
	
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
=======
		return false;

	}

}





>>>>>>> Delete_2
