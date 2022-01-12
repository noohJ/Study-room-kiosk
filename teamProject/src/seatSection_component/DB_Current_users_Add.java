package seatSection_component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import teamProject.DBConnector;

public class DB_Current_users_Add {
	//entry_time에는 입실시간(현재시간)을 넣어서 퇴실할 때 빼준다.
	public static void c_user_add(String seat_number, String id) {
		// current_users의 pk를 넣기 위해 총 row를 구하는 것
		boolean empty;
		String sql1 = "SELECT COUNT(*) FROM current_users";
		int user_num = 0;
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql1);
			ResultSet rs = pstmt.executeQuery();
		){
			int rowcount = 0;
			if(rs.next()) user_num = rs.getInt(1) + 1;			
			
			rs.close();
			pstmt.close();
			conn.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// current_users의 phone을 넣기위한 것
		String sql2 = "SELECT * FROM members WHERE member_id = '"+id+"'";
		String user_phone = "";
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql2);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				user_phone = rs.getString("member_phone");
			}
			rs.close();
			pstmt.close();
			conn.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// current_users DB에 추가하기
		String sql = "INSERT INTO current_users VALUES('"+user_num+"','"+user_phone+"',"
				+ "'"+seat_number+"',SYSDATE)";
		try(
			// DBConnector 클래스에서 DB를 가져오기 위한 기본정보를 가져옴.
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			int insert = pstmt.executeUpdate();
			System.out.println("성공적으로 추가되었습니다.");
			empty = true;
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			empty = false;
			JOptionPane.showMessageDialog(null, id+"님은 자리가 있습니다!");
		}
		if(empty) {
			String sql3 = "UPDATE seats SET seat_condition = 'using_seat' WHERE seat_number ='"+seat_number+"'";		
			try (
					Connection conn = DBConnector.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql3);
					){
				int update = pstmt.executeUpdate();
				System.out.printf("%d행이 변경되었습니다.", update);
				
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
	}
}
