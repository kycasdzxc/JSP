package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Reply;
import utils.DBConn;

public class ReplyDao {
	private static ReplyDao replyDao = new ReplyDao();
	
	public static ReplyDao getInstacne() {
		return replyDao;
	}
	
	private ReplyDao() {}
	
	public List<Reply> list(Long bno) {
		List<Reply> list = new ArrayList<Reply>();
		try {
			Connection conn = DBConn.getConnection();
			
			// 문장 생성
			String sql = "SELECT /*+ INDEX_DESC(TBL_REPLY IDX_REPLY_RNO_BNO) */ * FROM TBL_REPLY WHERE BNO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1,  bno);
			// 결과집합 생성
			ResultSet rs = pstmt.executeQuery();
			
			// 결과집합 순회 후 데이터 바인딩
			while(rs.next()) {
				int idx = 1;
				Reply reply = new Reply(rs.getLong(idx++), rs.getString(idx++),
						rs.getString(idx++), rs.getLong(idx++), rs.getString(idx++));
				list.add(reply);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void register(Reply reply) {
		try {
			Connection conn = DBConn.getConnection();
			
			// 문장 생성
			String sql = "INSERT INTO TBL_REPLY (RNO, CONTENT, BNO, WRITER)"
					+ " VALUES (SEQ_REPLY.NEXTVAL, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 파라미터 바인딩
			pstmt.setString(1, reply.getContent());
			pstmt.setLong(2, reply.getBno());
			pstmt.setString(3, reply.getWriter());
			
			// 문장 실행(반영)
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remove(Long rno) {
		try {
			Connection conn = DBConn.getConnection();
			
			// 문장 생성
			String sql = "DELETE TBL_REPLY\r\n" + 
					"WHERE RNO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 파라미터 바인딩
			pstmt.setLong(1, rno);
			
			// 문장 실행(반영)
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removeAll(Long bno) {
		try {
			Connection conn = DBConn.getConnection();
			
			// 문장 생성
			String sql = "DELETE TBL_REPLY\r\n" + 
					"WHERE BNO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 파라미터 바인딩
			pstmt.setLong(1, bno);
			
			// 문장 실행(반영)
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modify(Reply reply) {
		try {
			Connection conn = DBConn.getConnection();
			
			// 문장 생성
			String sql = "UPDATE TBL_REPLY SET\r\n" + 
					"CONTENT = ?,\r\n" + 
					"REGDATE = SYSDATE\r\n" + 
					"WHERE RNO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 파라미터 바인딩
			pstmt.setString(1, reply.getContent());
			pstmt.setLong(2, reply.getRno());
			
			// 문장 실행(반영)
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modifyNullByWriter(String writer) {
		try {
			Connection conn = DBConn.getConnection();
			
			// 문장 생성
			String sql = "UPDATE TBL_REPLY SET\r\n" + 
					"WRITER = NULL \r\n" + 
					"WHERE WRITER = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 파라미터 바인딩
			pstmt.setString(1, writer);
			
			// 문장 실행(반영)
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Reply get(Long rno) {
		Reply reply = null;
		try {
			Connection conn = DBConn.getConnection();
			
			// 문장 생성
			String sql = "SELECT * FROM TBL_REPLY WHERE RNO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1,  rno);
			// 결과집합 생성
			ResultSet rs = pstmt.executeQuery();
			
			// 결과집합 순회 후 데이터 바인딩
			while(rs.next()) {
				int idx = 1;
				reply = new Reply(rs.getLong(idx++), rs.getString(idx++),
						rs.getString(idx++), rs.getLong(idx++), rs.getString(idx++));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reply;
	}
}