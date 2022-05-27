package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Student;
import utils.DBConn;

public class StudentDao {
	public List<Student> list() {
		List<Student> list = new ArrayList<Student>();
		
		// sql과 관련된 메서드는 checked exception 메서드
		try {
			Connection conn = DBConn.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT STUDNO, NAME, DEPTNO FROM STUDENT");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int idx = 1;
				list.add(new Student(rs.getLong(idx++), rs.getString(idx++), rs.getLong(idx++)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		return list;
	}
}
