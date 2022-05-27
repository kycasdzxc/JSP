package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import member.vo.MemberVo;
import utils.DBConn;

public class MemberDao {
	/**
	 * singleton
	 */
	private final static MemberDao dao = new MemberDao();
	public static MemberDao getInstance() {
		return dao;
	}
	public MemberDao() {}
	/**
	 * 
	 */
	private Statement stmt;
	private PreparedStatement pstmt;
	private Connection conn;
	
	public List<MemberVo> list() {
		List<MemberVo> list = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			String query = "SELECT * FROM T_MEMBER";
//			stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(query);
			
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int idx = 1;
				MemberVo vo = new MemberVo(
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getDate(idx++)
						);
				list.add(vo);
			}
			rs.close();
//			stmt.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		new MemberDao().list().forEach(System.out::println);
	}
	
	public void register(MemberVo memberVo) {
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO T_MEMBER"
					+ " VALUES(?, ?, ?, ?, SYSDATE)");
			
			int idx = 1;
			pstmt.setString(idx++, memberVo.getId());
			pstmt.setString(idx++, memberVo.getPwd());
			pstmt.setString(idx++, memberVo.getName());
			pstmt.setString(idx++, memberVo.getEmail());

			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void remove(String id) {
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement("DELETE T_MEMBER WHERE ID = ?");
			
			int idx = 1;
			pstmt.setString(idx++, id);

			pstmt.executeUpdate();
			
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MemberVo login(String id, String pwd) {
		MemberVo memberVo = null;
		
		try {
			conn = DBConn.getConnection();
			String query = "SELECT * FROM T_MEMBER WHERE ID = ? AND PWD = ?";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int idx = 1;
				memberVo = new MemberVo(
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getDate(idx++)
						);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberVo;
	}	
}