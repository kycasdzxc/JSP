package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Attach;
import utils.DBConn;

public class AttachDao {
	private static AttachDao attachDao = new AttachDao();
	
	public static AttachDao getInstacne() {
		return attachDao;
	}
	
	private AttachDao() {}

	public List<Attach> list(Long bno) {
		List<Attach> list = new ArrayList<>();
		try {
			Connection conn = DBConn.getConnection();
			
			// 문장 생성
			String sql = "SELECT /*+ INDEX(TBL_ATTACH IDX_ATTACH_UUID_BNO) */ * FROM TBL_ATTACH WHERE BNO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, bno);
			
			// 결과집합 생성
			ResultSet rs = pstmt.executeQuery();
			
			// 결과집합 순회 후 데이터 바인딩
			while(rs.next()) {
				int idx = 1;
				Attach attach = new Attach(
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getString(idx++),
						rs.getBoolean(idx++),
						rs.getInt(idx++),
						bno
						);
				list.add(attach);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void insert(Attach attach) {
		try {
			Connection conn = DBConn.getConnection();
			
			String sql = "INSERT INTO TBL_ATTACH "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int idx = 1;
			pstmt.setString(idx++, attach.getUuid());
			pstmt.setString(idx++, attach.getOrigin());
			pstmt.setString(idx++, attach.getPath());
			pstmt.setBoolean(idx++, attach.isImage());
			pstmt.setInt(idx++, attach.getOrd());
			pstmt.setLong(idx++, attach.getBno());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remove(Long bno) {
		try {
			Connection conn = DBConn.getConnection();
			
			// 문장 생성
			String sql = "DELETE TBL_ATTACH\r\n" + 
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
}
