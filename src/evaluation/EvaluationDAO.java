package evaluation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DatabaseUtil;

public class EvaluationDAO {
	public int write (Evaluation evaluation) {
		String sql = "INSERT INTO evaluation VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, evaluation.getUserID());
			pstmt.setString(2, evaluation.getLectureName());
			pstmt.setString(3, evaluation.getProfessorName());
			pstmt.setInt(4, evaluation.getLectureYear());
			pstmt.setString(5, evaluation.getSemesterDivide());
			pstmt.setString(6, evaluation.getLectureDivide());
			pstmt.setString(7, evaluation.getEvaluationTitle());
			pstmt.setString(8, evaluation.getEvaluationContent());
			pstmt.setString(9, evaluation.getTotalScore());
			pstmt.setString(10, evaluation.getCreditScore());
			pstmt.setString(11, evaluation.getComfortableScore());
			pstmt.setString(12, evaluation.getLectureSrcore());
			return pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try { if(conn != null) conn.close(); }
			catch (Exception e) { e.printStackTrace(); }
			try { if(pstmt != null) pstmt.close(); }
			catch (Exception e) { e.printStackTrace(); }
			try { if(rs != null) rs.close(); }
			catch (Exception e) { e.printStackTrace(); }
		}
		return -1; //데이터 베이스 오류
	}
}
