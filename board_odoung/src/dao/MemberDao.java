package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.Member;
import utils.DBConn;

public class MemberDao {
	private static MemberDao memberDao = new MemberDao();
	public static MemberDao getInstance() {
		return memberDao;
	}
	private MemberDao() {}
	
	public void register(Member member) {
		try {
			Connection conn = DBConn.getConnection();
			
			String sql = "{call PROC_INSERT_MEMBER(?,?,?,?,?,?,?,?,?,?,?,?)}";

//			PreparedStatement pstmt = conn.prepareStatement(sql);
			CallableStatement cstmt = conn.prepareCall(sql);
			
			// 파라미터 바인딩
			int idx = 1;
			cstmt.setString(idx++, member.getId());
			cstmt.setString(idx++, member.getPw());
			cstmt.setString(idx++, member.getName());
			cstmt.setString(idx++, member.getSi());
			cstmt.setString(idx++, member.getSgg());
			cstmt.setString(idx++, member.getEmd());
			cstmt.setString(idx++, member.getRoadAddr());
			cstmt.setString(idx++, member.getAddrDetail());
			cstmt.setString(idx++, member.getZipNo());
			cstmt.setString(idx++, member.getRoadFullAddr());
			cstmt.setString(idx++, member.getJibunAddr());
			cstmt.setString(idx++, member.getEmail());
			
			// 문장 실행(반영)
			cstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modify(Member member) {
		try {
			Connection conn = DBConn.getConnection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE TBL_MEMBER SET \r\n");
			if(member.getPw() != null && !member.getPw().equals("")) {
				sb.append("PW = ?, \r\n");
			}
			sb.append("NAME = ?, \r\n");
			sb.append("SI = ?, \r\n");
			sb.append("SGG = ?, \r\n");
			sb.append("EMD = ?, \r\n");
			sb.append("ROADADDR = ?, \r\n");
			sb.append("ADDRDETAIL = ?, \r\n");
			sb.append("ZIPNO = ?, \r\n");
			sb.append("ROADFULLADDR = ?, \r\n");
			sb.append("JIBUNADDR = ? \r\n");
			sb.append("WHERE ID = ?");
			
			String sql = sb.toString();
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 파라미터 바인딩
			int idx = 1;
			if(member.getPw() != null && !member.getPw().equals("")) {
				pstmt.setString(idx++, member.getPw());
			}
			pstmt.setString(idx++, member.getName());
			pstmt.setString(idx++, member.getSi());
			pstmt.setString(idx++, member.getSgg());
			pstmt.setString(idx++, member.getEmd());
			pstmt.setString(idx++, member.getRoadAddr());
			pstmt.setString(idx++, member.getAddrDetail());
			pstmt.setString(idx++, member.getZipNo());
			pstmt.setString(idx++, member.getRoadFullAddr());
			pstmt.setString(idx++, member.getJibunAddr());
			pstmt.setString(idx++, member.getId());
			
			// 문장 실행(반영)
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remove(String id) {
		try {
			//클래스 로드
			Connection conn = DBConn.getConnection();
			
			// 문장 생성
//			String sql = "DELETE TBL_MEMBER \r\n" + 
//					"WHERE ID = ?";
			String sql = "{CALL QUIT_PROC(?)}";
			PreparedStatement pstmt = conn.prepareCall(sql);
			
			// 파라미터 바인딩
			pstmt.setString(1, id);
			
			// 문장 실행(반영)
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Member login(String id, String pw) {
		Member member = null;
		try {
			//클래스 로드
			Connection conn = DBConn.getConnection();
			
			// 문장 생성
			String sql = "SELECT * FROM TBL_MEMBER\r\n" + 
					"WHERE ID = ? AND PW = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int idx = 1;
			pstmt.setString(idx++, id.trim());
			pstmt.setString(idx++, pw.trim());
			
			// 결과집합 생성
			ResultSet rs = pstmt.executeQuery();
			
			// 결과집합 순회 후 데이터 바인딩
			while(rs.next()) {
				int idx2 = 1;
				member = new Member(rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
	public Member get(String id) {
		Member member = null;
		try {
			Connection conn = DBConn.getConnection();
			
			String sql = "SELECT * FROM TBL_MEMBER\r\n" + 
					"WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int idx = 1;
			pstmt.setString(idx++, id.trim().toLowerCase());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int idx2 = 1;
				member = new Member(
						rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++),
						rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++),
						rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++),
						rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++),
						rs.getString(idx2++), rs.getString(idx2++)
						);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
	public Member findBy(String email) {
		Member member = null;
		try {
			Connection conn = DBConn.getConnection();
			
			String sql = "SELECT * FROM TBL_MEMBER\r\n" + 
					"WHERE EMAIL = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int idx = 1;
			pstmt.setString(idx++, email.trim().toLowerCase());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int idx2 = 1;
				member = new Member(rs.getString(idx2++), rs.getString(idx2++), rs.getString(idx2++));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
	public void updateAuthToken(Member member) {
		try {
			//클래스 로드
			Connection conn = DBConn.getConnection();
			
			// 문장 생성
			String sql = "UPDATE TBL_MEMBER SET\r\n" + 
					"AUTH_TOKEN = ?\r\n" + 
					"WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 파라미터 바인딩
			pstmt.setString(1, member.getAuthToken());
			pstmt.setString(2, member.getId());
			
			// 문장 실행(반영)
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateAuth(Member member) {
		try {
			//클래스 로드
			Connection conn = DBConn.getConnection();
			
			// 문장 생성
			String sql = "UPDATE TBL_MEMBER SET\r\n" + 
					"AUTH = ?\r\n" + 
					"WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 파라미터 바인딩
			pstmt.setString(1, member.getAuth());
			pstmt.setString(2, member.getId());
			
			// 문장 실행(반영)
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}