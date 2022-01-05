package project_lsk;

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
}
