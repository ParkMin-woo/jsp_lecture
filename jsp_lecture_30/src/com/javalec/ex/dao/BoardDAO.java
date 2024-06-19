package com.javalec.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.javalec.ex.ConnectionPool;
import com.javalec.ex.dto.BoardDTO;

public class BoardDAO {
	
	private static Connection conn;
	PreparedStatement pstm = null;
	Statement stm = null;
	ResultSet rs = null;

	private static BoardDAO instance = new BoardDAO();
	
	private BoardDAO() {
		
	}
	
	public static BoardDAO getInstance() {
		return instance;
	}

	public ArrayList<BoardDTO> getBoardList() {
		ArrayList<BoardDTO> allBoardList = new ArrayList<BoardDTO>();
		
		try {
			conn = ConnectionPool.getConnection();
			
			/*
			SELECT
				-- *
				b_id
				, b_name
				, b_title
				, b_content
				, b_regist_date
				, b_update_date
				, b_hit
				, b_group
				, b_step
				, b_indent
			FROM test_board
			ORDER BY b_group DESC , b_step ASC
			*/
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT");
			sql.append("	b_id");
			sql.append("	, b_name");
			sql.append("	, b_title");
			sql.append("	, b_content");
			sql.append("	, b_regist_date");
			sql.append("	, b_update_date");
			sql.append("	, b_hit");
			sql.append("	, b_group");
			sql.append("	, b_step");
			sql.append("	, b_indent ");
			sql.append("FROM test_board ");
			sql.append("ORDER BY b_group DESC , b_step ASC");
			
			System.out.println("getBoardList sql => " + sql.toString());
			
			pstm = conn.prepareStatement(sql.toString());
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setbId(rs.getInt("b_id"));
				boardDTO.setbName(rs.getString("b_name"));
				boardDTO.setbTitle(rs.getString("b_title"));
				boardDTO.setbContent(rs.getString("b_content"));
				boardDTO.setbRegistDate(rs.getTimestamp("b_regist_date"));
				boardDTO.setbUpdateDate(rs.getTimestamp("b_update_date"));
				boardDTO.setbHit(rs.getInt("b_hit"));
				boardDTO.setbGroup(rs.getInt("b_group"));
				boardDTO.setbStep(rs.getInt("b_step"));
				boardDTO.setbIndent(rs.getInt("b_indent"));
				allBoardList.add(boardDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stm != null) stm.close();
				if(conn != null) conn.close();
				if(pstm != null) pstm.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// System.out.println(e.toString());
				e.printStackTrace();
				System.out.println("연결 해제 오류 발생");
			}
		}
		
		return allBoardList;
	}

	public int updateBoardHit(int bId) {
		int ri = 0;
		
		try {
			conn = ConnectionPool.getConnection();
			
			/*
			UPDATE test_board
			SET
				b_hit = b_hit + 1
			WHERE 1=1
			AND b_id = ?
			*/
			
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE test_board ");
			sql.append("SET");
			sql.append("	b_hit = b_hit + 1 ");
			sql.append("WHERE 1=1 ");
			sql.append("AND b_id = ?");
			
			System.out.println("updateBoardHit sql => " + sql.toString());
			
			pstm = conn.prepareStatement(sql.toString());
			pstm.setInt(1, bId);
			
			ri = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stm != null) stm.close();
				if(conn != null) conn.close();
				if(pstm != null) pstm.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// System.out.println(e.toString());
				e.printStackTrace();
				System.out.println("연결 해제 오류 발생");
			}
		}
		
		return ri;
	}

	public BoardDTO getBoardContent(int bId) {
		// TODO Auto-generated method stub
		BoardDTO boardDTO = new BoardDTO();
		
		try {
			conn = ConnectionPool.getConnection();
			
			/*
			SELECT
				-- *
				b_id
				, b_name
				, b_title
				, b_content
				, b_regist_date
				, b_update_date
				, b_hit
				, b_group
				, b_step
				, b_indent
			FROM test_board
			where 1=1
			and b_id = ?
			*/
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT");
			sql.append("	b_id");
			sql.append("	, b_name");
			sql.append("	, b_title");
			sql.append("	, b_content");
			sql.append("	, b_regist_date");
			sql.append("	, b_update_date");
			sql.append("	, b_hit ");
			sql.append("	, b_group");
			sql.append("	, b_step");
			sql.append("	, b_indent ");
			sql.append("FROM test_board ");
			sql.append("where 1=1 ");
			sql.append("and b_id = ?");
			
			System.out.println("getBoardContent sql => " + sql.toString());
			
			pstm = conn.prepareStatement(sql.toString());
			pstm.setInt(1, bId);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				boardDTO.setbId(rs.getInt("b_id"));
				boardDTO.setbName(rs.getString("b_name"));
				boardDTO.setbTitle(rs.getString("b_title"));
				boardDTO.setbContent(rs.getString("b_content"));
				/*
				boardDTO.setbRegistDate(rs.getDate("b_regist_date"));
				boardDTO.setbUpdateDate(rs.getDate("b_update_date"));
				*/
				boardDTO.setbRegistDate(rs.getTimestamp("b_regist_date"));
				boardDTO.setbUpdateDate(rs.getTimestamp("b_update_date"));
				boardDTO.setbHit(rs.getInt("b_hit"));
				boardDTO.setbGroup(rs.getInt("b_group"));
				boardDTO.setbStep(rs.getInt("b_step"));
				boardDTO.setbIndent(rs.getInt("b_indent"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stm != null) stm.close();
				if(conn != null) conn.close();
				if(pstm != null) pstm.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// System.out.println(e.toString());
				e.printStackTrace();
				System.out.println("연결 해제 오류 발생");
			}
		}
		
		return boardDTO;
	}

	public int insertBoardContent(String bName, String bTitle, String bContent) {
		int ri = 0;
		
		try {
			conn = ConnectionPool.getConnection();
			
			/*
			INSERT INTO test_board(b_id, b_name, b_title, b_content, b_group, b_step, b_indent)
			VALUES (
				(SELECT A.ID FROM (SELECT nvl(MAX(b_id), 0) + 1 AS ID FROM test_board) A)
				, ?
				, ?
				, ?
				, (SELECT A.ID FROM (SELECT nvl(MAX(b_id), 0) + 1 AS ID FROM test_board) A)
				, 0
				, 0
			)
			*/
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO test_board(b_id, b_name, b_title, b_content, b_group, b_step, b_indent) ");
			sql.append("VALUES (");
			sql.append("	(SELECT A.ID FROM (SELECT nvl(MAX(b_id), 0) + 1 AS ID FROM test_board) A)");
			sql.append("	, ?");
			sql.append("	, ?");
			sql.append("	, ?");
			sql.append("	, (SELECT A.ID FROM (SELECT nvl(MAX(b_id), 0) + 1 AS ID FROM test_board) A)");
			sql.append("	, 0");
			sql.append("	, 0 ");
			sql.append(")");
			
			System.out.println("insertBoardContent sql => " + sql.toString());
			
			// String sql = "INSERT INTO test_board(b_id, b_name, b_title, b_content, b_group, b_step, b_indent) VALUES ((SELECT A.ID FROM (SELECT nvl(MAX(b_id), 0) + 1 AS ID FROM test_board) A), ?, ?, ?, (SELECT A.ID FROM (SELECT nvl(MAX(b_id), 0) + 1 AS ID FROM test_board) A), 0, 0)";
			pstm = conn.prepareStatement(sql.toString());
			pstm.setString(1, bName);
			pstm.setString(2, bTitle);
			pstm.setString(3, bContent);
			
			ri = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stm != null) stm.close();
				if(conn != null) conn.close();
				if(pstm != null) pstm.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// System.out.println(e.toString());
				e.printStackTrace();
				System.out.println("연결 해제 오류 발생");
			}
		}
		
		
		return ri;
	}

	public int updateBoardContent(int bId, String bContent) {
		int ri = 0;
		
		try {
			conn = ConnectionPool.getConnection();
			
			/*
			UPDATE test_board
			SET
				b_content = ?
				, b_update_date = sysdate()
			WHERE 1=1
			AND b_id = ?
			*/
			
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE test_board ");
			sql.append("SET");
			sql.append("	b_content = ?");
			sql.append("	, b_update_date = sysdate() ");
			sql.append("WHERE 1=1 ");
			sql.append("AND b_id = ?");
			
			System.out.println("updateBoardContent sql => " + sql.toString());
			
			pstm = conn.prepareStatement(sql.toString());
			pstm.setString(1, bContent);
			pstm.setInt(2, bId);
			
			ri = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stm != null) stm.close();
				if(conn != null) conn.close();
				if(pstm != null) pstm.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// System.out.println(e.toString());
				e.printStackTrace();
				System.out.println("연결 해제 오류 발생");
			}
		}
		
		return ri;
	}

	public int removeBoardContent(int bId) {
		int ri = 0;
		
		try {
			conn = ConnectionPool.getConnection();
			
			/*
			DELETE FROM test_board
			WHERE 1=1
			AND b_id = ?
			*/
			
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE FROM test_board ");
			sql.append("WHERE 1=1 ");
			sql.append("AND b_id = ?");
			
			System.out.println("removeBoardContent sql => " + sql.toString());
			
			pstm = conn.prepareStatement(sql.toString());
			pstm.setInt(1, bId);
			
			ri = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stm != null) stm.close();
				if(conn != null) conn.close();
				if(pstm != null) pstm.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// System.out.println(e.toString());
				e.printStackTrace();
				System.out.println("연결 해제 오류 발생");
			}
		}
		
		return ri;
	}

	public int insertBoardReply(BoardDTO boardDTO) {
		int ri = 0;
		
		try {
			conn = ConnectionPool.getConnection();
			
			/*
			INSERT INTO test_board(b_id, b_name, b_title, b_content, b_group, b_step, b_indent)
			VALUES (
				?
				, ?
				, ?
				, ?
				, ?
				, ?
				, ?
			)
			*/
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO test_board(b_id, b_name, b_title, b_content, b_group, b_step, b_indent) ");
			sql.append("VALUES (");
			sql.append("	(SELECT A.ID FROM (SELECT nvl(MAX(b_id), 0) + 1 AS ID FROM test_board) A)");
			sql.append("	, ?");
			sql.append("	, ?");
			sql.append("	, ?");
			/*
			sql.append("	, (SELECT A.GROUP1 FROM (SELECT nvl(MAX(b_group), 0) AS GROUP1 FROM test_board WHERE b_id = ?) A)");
			sql.append("	, (SELECT A.step FROM (SELECT nvl(MAX(b_step), 0) + 1 AS step FROM test_board WHERE b_id = ?) A)");
			sql.append("	, (SELECT A.indent FROM (SELECT nvl(MAX(b_indent), 0) + 1 AS indent FROM test_board WHERE b_id = ?) A) ");
			*/
			sql.append("	, ?");
			sql.append("	, ?");
			sql.append("	, ? ");
			sql.append(")");
			
			System.out.println("insertBoardReply sql => " + sql.toString());
			
			// String sql = "INSERT INTO test_board(b_id, b_name, b_title, b_content, b_group, b_step, b_indent) VALUES ((SELECT A.ID FROM (SELECT nvl(MAX(b_id), 0) + 1 AS ID FROM test_board) A), ?, ?, ?, (SELECT A.ID FROM (SELECT nvl(MAX(b_id), 0) + 1 AS ID FROM test_board) A), 0, 0)";
			pstm = conn.prepareStatement(sql.toString());
			pstm.setString(1, boardDTO.getbName());
			pstm.setString(2, boardDTO.getbTitle());
			pstm.setString(3, boardDTO.getbContent());
			pstm.setInt(4, boardDTO.getbGroup());
			pstm.setInt(5, boardDTO.getbStep());
			pstm.setInt(6, boardDTO.getbIndent());
			
			ri = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stm != null) stm.close();
				if(conn != null) conn.close();
				if(pstm != null) pstm.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// System.out.println(e.toString());
				e.printStackTrace();
				System.out.println("연결 해제 오류 발생");
			}
		}
		
		
		return ri;
	}

	/*
	public HashMap<String, Integer> getStepAndIndentByBGroup(int bGroup) {
		// int maxBStep = 0;
		HashMap<String, Integer> resultMap = new HashMap<String, Integer>();
		
		try {
			conn = ConnectionPool.getConnection();
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT");
			sql.append("	max(b_step) AS max_b_step ");
			sql.append("	, min(b_indent) AS min_b_indent ");
			sql.append("FROM test_board ");
			sql.append("WHERE 1=1 ");
			sql.append("AND b_group = ?");
			
			System.out.println("getMinBStepByBGroup sql => " + sql.toString());
			
			pstm = conn.prepareStatement(sql.toString());
			pstm.setInt(1, bGroup);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				// maxBStep = rs.getInt("max_b_step");
				resultMap.put("maxBStep", rs.getInt("max_b_step"));
				resultMap.put("minBIndent", rs.getInt("min_b_indent"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stm != null) stm.close();
				if(conn != null) conn.close();
				if(pstm != null) pstm.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// System.out.println(e.toString());
				e.printStackTrace();
				System.out.println("연결 해제 오류 발생");
			}
		}
		
		// return maxBStep;
		return resultMap;
	}
	*/

	public int updateBStep(int bGroup) {
		int ri = 0;
		
		try {
			conn = ConnectionPool.getConnection();
			
			/*
			UPDATE test_board
			SET
				b_step = b_step + 1
				, b_update_date = sysdate()
			WHERE 1=1
			AND b_group = ?
			AND b_step >= 1
			*/
			
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE test_board ");
			sql.append("SET");
			sql.append("	b_step = b_step + 1");
			sql.append("	, b_update_date = sysdate() ");
			sql.append("WHERE 1=1 ");
			sql.append("AND b_group = ? ");
			sql.append("AND b_step >= 1 ");
			
			System.out.println("updateBStep sql => " + sql.toString());
			
			pstm = conn.prepareStatement(sql.toString());
			pstm.setInt(1, bGroup);
			
			ri = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stm != null) stm.close();
				if(conn != null) conn.close();
				if(pstm != null) pstm.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// System.out.println(e.toString());
				e.printStackTrace();
				System.out.println("연결 해제 오류 발생");
			}
		}
		
		return ri;
	}

	public int getReplyCnt(BoardDTO boardContent) {
		int replyCnt = 0;
		
		try {
			conn = ConnectionPool.getConnection();
			
			/*
			SELECT
				COUNT(*) AS reply_cnt
			FROM test_board
			WHERE 1=1
			AND b_group = ?
			AND b_step = ?
			AND b_indent >= ?
			*/
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT");
			sql.append("	COUNT(*) AS reply_cnt ");
			sql.append("FROM test_board ");
			sql.append("WHERE 1=1 ");
			sql.append("AND b_group = ? ");
			sql.append("AND b_step = ? ");
			sql.append("AND b_indent >= ? ");
			
			System.out.println("getReplyCnt sql => " + sql.toString());
			
			pstm = conn.prepareStatement(sql.toString());
			pstm.setInt(1, boardContent.getbGroup());
			pstm.setInt(2, boardContent.getbStep());
			pstm.setInt(3, boardContent.getbIndent());
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				replyCnt = rs.getInt("reply_cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stm != null) stm.close();
				if(conn != null) conn.close();
				if(pstm != null) pstm.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// System.out.println(e.toString());
				e.printStackTrace();
				System.out.println("연결 해제 오류 발생");
			}
		}
		
		// return maxBStep;
		return replyCnt;
	}

	public int getRemainCnt(BoardDTO boardContent) {
		int remainCnt = 0;
		
		try {
			conn = ConnectionPool.getConnection();
			
			/*
			SELECT
				COUNT(*) AS remain_cnt
			FROM test_board
			WHERE 1=1
			AND b_group = ?
			AND b_step >= ?
			AND b_indent >= ?
			*/
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT");
			sql.append("	COUNT(*) AS remain_cnt ");
			sql.append("FROM test_board ");
			sql.append("WHERE 1=1 ");
			sql.append("AND b_group = ? ");
			sql.append("AND b_step >= ? ");
			sql.append("AND b_indent >= ? ");
			
			System.out.println("getRemainCnt sql => " + sql.toString());
			
			pstm = conn.prepareStatement(sql.toString());
			pstm.setInt(1, boardContent.getbGroup());
			pstm.setInt(2, boardContent.getbStep());
			pstm.setInt(3, boardContent.getbIndent());
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				remainCnt = rs.getInt("remain_cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(stm != null) stm.close();
				if(conn != null) conn.close();
				if(pstm != null) pstm.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// System.out.println(e.toString());
				e.printStackTrace();
				System.out.println("연결 해제 오류 발생");
			}
		}
		
		// return maxBStep;
		return remainCnt;
	}
	
}
