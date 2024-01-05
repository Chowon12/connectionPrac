package all.dao; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import all.dto.All;
import common.util.DBUtil;
import dept.dto.Dept;
import emp.dto.Emp;

public class AllDAO {
		// getEmpList
		// Query : SELECT * FROM emp;
		public static ArrayList<All> getAllList() throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;

			ArrayList<All> allList = null;
			
			String sql = "SELECT e.empno, e.ename, e.deptno, d.dname, d.loc FROM emp e, dept d WHERE e.deptno = d.deptno";
			
			try {
				con = DBUtil.getConnection();
				
				pstmt = con.prepareStatement(sql);
				
				rset = pstmt.executeQuery();
				
				allList = new ArrayList<All>();
				while(rset.next()) {
					allList.add(new All(rset.getInt("empno"),
										  rset.getString("ename"),
										  rset.getInt("deptno"),
										  rset.getString("dname"),
										  rset.getString("loc")));
				}
			}finally {
				DBUtil.close(rset, pstmt, con);
			}
			
			return allList;
		}
		
		public static All getAllByEmpno(int empno) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;

			All all = null;
			
			String sql = "SELECT e.empno, e.ename, e.deptno, d.dname, d.loc FROM emp e, dept d WHERE e.deptno = d.deptno AND empno = ?";
			
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, empno);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					all = new All(
								rset.getInt(1),
								rset.getString(2),
								rset.getInt(3),
								rset.getString(4),
								rset.getString(5));
				}
			}finally {
				DBUtil.close(rset, pstmt, con);
			}
			
			return all;
		}
}