package seatSection_component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

import javax.swing.JOptionPane;

import teamProject.DBConnector;

public class DB_Current_users_Add {
	
	public static boolean c_user_add(String seat_number, String id) {
		// current_users�� pk�� �ֱ� ���� �� row�� ���ϴ� ��
		boolean empty;		
		
		// current_users�� phone�� �ֱ����� ��
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
		
		// current_users DB�� �߰��ϱ�
		int user_num = Integer.parseInt(seat_number);
		String sql = "INSERT INTO current_users VALUES('"+user_num+"','"+user_phone+"',"
				+ "'"+seat_number+"', TO_CHAR(SYSDATE, 'HH24:MI'))";
		try(
			// DBConnector Ŭ�������� DB�� �������� ���� �⺻������ ������.
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		){
			int insert = pstmt.executeUpdate();
			System.out.println("���������� �߰��Ǿ����ϴ�.");
			empty = true;
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			empty = false;
			JOptionPane.showMessageDialog(null, id+"���� �ڸ��� �ֽ��ϴ�!");
		}
		if(empty) {
			String sql3 = "UPDATE seats SET seat_condition = 'using_seat' WHERE seat_number ='"+seat_number+"'";		
			try (
				Connection conn = DBConnector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql3);
			){
				int update = pstmt.executeUpdate();
				System.out.printf("%d���� ����Ǿ����ϴ�.", update);
				
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return empty;
	}
	
	public static void c_user_del(String id) {
		// current_users�� phone�� �ֱ����� ��
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// current_users�� seat_number�� �������� ���� ��
		String sql4 = "SELECT * FROM current_users WHERE user_phone = '"+user_phone+"'";
		int seat_number = 0;
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql4);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				seat_number = rs.getInt("seat_number");
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// ��� �� seat_condition�� �ٽ� empty_seat�� �ٲ���
		String sql3 = "UPDATE seats SET seat_condition = 'empty_seat' WHERE seat_number = "+seat_number+"";		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql3);
		){
			int update = pstmt.executeUpdate();
			System.out.printf("%d���� ����Ǿ����ϴ�.", update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// current_users�� ���� �ð�(end_date)�� ������
		String sql5 = "SELECT * FROM current_users WHERE user_phone = ?";
		String chk_in = "";
		int usage_time = 0;
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql5);
		){
			pstmt.setString(1, user_phone);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				chk_in = rs.getString("entry_time");
			}
			
			LocalTime str1 = LocalTime.now();
			int hour_a = str1.getHour() * 60;
			int min_a = str1.getMinute();
			int after = hour_a + min_a;
			System.out.println(after);
			
			String hour_b = ""+chk_in.charAt(0) + chk_in.charAt(1);
			String min_b = ""+chk_in.charAt(3) + chk_in.charAt(4);
			int before = Integer.parseInt(hour_b)*60 + Integer.parseInt(min_b);
			System.out.println(before);
			
			if(after > before) {
				usage_time = after - before;
			} else {
				usage_time = 1440 + after - before;
			}
			
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		// user�� ���� �ð�(end_date)�� ������
		String sql6 = "SELECT * FROM members WHERE member_id = '"+id+"'";
		String end_date = "";
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql6);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				end_date = rs.getString("end_date");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		int end_date_int = Integer.parseInt(end_date) - usage_time;		
		end_date = Integer.toString(end_date_int);
		
		// ����ð� - ��ǽð� ���� ���� ���� �ִ� DB �����ð����� ������
		String sql7 = "UPDATE members SET end_date = ? WHERE member_id = ?";		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql7);
		){
			pstmt.setString(1, end_date);
			pstmt.setString(2, id);
			int update = pstmt.executeUpdate();
			System.out.printf("[UPDATE members SET end_date]%d���� ����Ǿ����ϴ�.\n", update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// ��ǹ�ư�� ���� �ʿ������ current_users DB�� ������
		String sql1 = "DELETE FROM current_users WHERE user_phone = ?";
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql1);
		){
			pstmt.setString(1, user_phone);
			
			int delete = pstmt.executeUpdate();			
			System.out.printf("%d���� ����Ǿ����ϴ�.", delete);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void c_season_user_del(String id) {
		// current_users�� phone�� �ֱ����� ��
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// current_users�� seat_number�� �������� ���� ��
		String sql4 = "SELECT * FROM current_users WHERE user_phone = '"+user_phone+"'";
		int seat_number = 0;
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql4);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				seat_number = rs.getInt("seat_number");
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// ��� �� seat_condition�� �ٽ� empty_seat�� �ٲ���
		String sql3 = "UPDATE seats SET seat_condition = 'empty_seat' WHERE seat_number = "+seat_number+"";		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql3);
		){
			int update = pstmt.executeUpdate();
			System.out.printf("[UPDATE seats SET seat_condition]%d���� ����Ǿ����ϴ�.\n", update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// ��ǹ�ư�� ���� �ʿ������ current_users DB�� ������
		String sql1 = "DELETE FROM current_users WHERE user_phone = ?";
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql1);
		){
			pstmt.setString(1, user_phone);
			
			int delete = pstmt.executeUpdate();			
			System.out.printf("[DELETE FROM current_users]%d���� ����Ǿ����ϴ�.\n", delete);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	
	//������ �¼���ȣ ����
	public static String c_user_seat(String id) {
		// current_users�� phone�� �ֱ����� ��
		String sql1 = "SELECT * FROM members WHERE member_id = '"+id+"'";
		String user_phone = "";
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql1);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				user_phone = rs.getString("member_phone");
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql2 = "SELECT * FROM current_users WHERE user_phone = '"+user_phone+"'";
		String seat_num = "";
		int seat_number = 0;
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql2);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				seat_number = rs.getInt("seat_number");
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		seat_num = Integer.toString(seat_number);
		return seat_num;
	}
	
	//�ڸ��̵� �� ������ �ڸ��� ����
	public static void c_user_change_seat(String s_num, String id) {
		// current_users�� phone�� �ֱ����� ��
		String sql1 = "SELECT * FROM members WHERE member_id = '"+id+"'";
		String user_phone = "";
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql1);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				user_phone = rs.getString("member_phone");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// current_users�� seat_number�� �������� ���� ��
		String sql2 = "SELECT * FROM current_users WHERE user_phone = '"+user_phone+"'";
		int seat_number = 0;
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql2);
			ResultSet rs = pstmt.executeQuery();
		){
			while(rs.next()) {
				seat_number = rs.getInt("seat_number");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// �ڸ��̵� �� ���� seat_condition�� �ٽ� empty_seat�� �ٲ���
		String sql3 = "UPDATE seats SET seat_condition = 'empty_seat' WHERE seat_number = "+seat_number+"";		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql3);
		){
			int update = pstmt.executeUpdate();
			System.out.printf("[UPDATE seats SET seat_condition] %d���� ����Ǿ����ϴ�.\n", update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// �̵��� �ڸ��� seat_condition�� �ٽ� using_seat�� �ٲ���
		String sql4 = "UPDATE seats SET seat_condition = 'using_seat' WHERE seat_number = ?";		
		try (
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql4);
		){
			pstmt.setInt(1, Integer.parseInt(s_num));
			int update = pstmt.executeUpdate();
			System.out.printf("[UPDATE seats SET seat_condition] %d���� ����Ǿ����ϴ�.\n", update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// ������ �ڸ� seat_number�� ������Ʈ
		String sql5 = "UPDATE current_users SET seat_number = ? WHERE user_phone = ?";
		try(
			Connection conn = DBConnector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql5);
		){
			pstmt.setInt(1, Integer.parseInt(s_num));
			pstmt.setString(2, user_phone);
			
			int update = pstmt.executeUpdate();			
			System.out.printf("[UPDATE current_users SET seat_number]%d���� ����Ǿ����ϴ�.\n", update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}