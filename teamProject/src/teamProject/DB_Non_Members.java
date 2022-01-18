package teamProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DB_Non_Members {
	
	public static boolean nmb_phone_arr(String keyword) {
		String sql = "SELECT * FROM non_members";
		ArrayList<String> non_member_phones = new ArrayList<>();
		try(
			// DBConnector 클래스에서 DB를 가져오기 위한 기본정보를 가져옴.
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				// 논멤버의 핸드폰 번호를 non_member_phones 리스트에 담음.
				non_member_phones.add(rs.getString("non_member_phone"));
			}
			for(int i = 0; i < non_member_phones.size(); i++) {
				if(non_member_phones.get(i).equals(keyword)) return false;
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	// 논멤버의 아이디를 키워드로 받았을 때 그 멤버의 바우쳐코드를 리턴
	public static int nmb_vc_type(String keyword) {
		String sql = "SELECT * FROM non_members WHERE non_member_phone = '"+keyword+"'";
		int temp = 0;
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				temp = rs.getInt("voucher_code");
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	// 논멤버의 아이디를 키워드로 받으면 논멤버의 남은 시간을 리턴
	public static String nmb_ed_arr(String keyword) {
		String sql = "SELECT * FROM non_members WHERE non_member_phone = '"+keyword+"'";
		String temp = "";
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				temp = rs.getString("end_date");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	// 기한 혹은 시간이 다된 논멤버의 바우쳐코드를 널로 바꿔줌
	public static void nmb_vc_del(String keyword) {
		String sql1 = "UPDATE non_members SET voucher_code = null, "
				+ "end_date = null WHERE non_member_phone = '"+keyword+"'";		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql1);
		){
			int update = pstmt.executeUpdate();
			System.out.printf("[UPDATE non_members SET] %d행이 변경되었습니다.\n", update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
