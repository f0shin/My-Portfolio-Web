package com.portfolio.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.portfolio.model.Contact;
import com.portfolio.utils.DBConnection;

public class ContactRepository {

	public List<Contact> findAll() {

		List<Contact> contacts = new ArrayList<>();
		String sql = "SELECT * FROM contacts ORDER BY created_at DESC";

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				Contact contact = new Contact(
						rs.getString("id"), 
						rs.getString("name"), 
						rs.getString("email"),
						rs.getString("message"), 
						rs.getTimestamp("created_at"),
						rs.getInt("completed"));
				
				contacts.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return contacts;

	}

	public void save(Contact contact) {
		if (contact.getName() == null || contact.getEmail() == null	|| contact.getMessage() == null) {
			throw new IllegalArgumentException("입력값 중 하나가 NULL입니다!");
		}

		String sql = "INSERT INTO contacts (id, name, email, message, created_at, completed) VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection conn = DBConnection.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, contact.getId());
			pstmt.setString(2, contact.getName());
			pstmt.setString(3, contact.getEmail());
			pstmt.setString(4, contact.getMessage());
			pstmt.setTimestamp(5, contact.getCreatedAt());
			pstmt.setInt(6, contact.getCompleted());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void modifyCompleted(String contactId, int i) {
		
		String sql = "UPDATE contacts SET completed = 1 WHERE id = ?";

		try (Connection conn = DBConnection.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, contactId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
