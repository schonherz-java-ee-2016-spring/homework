package hu.schonherz.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.training.classes.User;
import hu.schonherz.training.connection.ConnectionHandler;

public class UserDaoImpl implements UserDao {
	
	private Connection con;

	public UserDaoImpl() {
		try {
			con = ConnectionHandler.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<User> getAllUsers() {
		String sql = "SELECT id, name FROM public.\"User\";";
		List<User> users = new ArrayList<>();
		try (Statement stmt = con.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					users.add(new User(rs.getString("name"), rs.getInt("id")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User getUserById(int id) {
		String sql = "SELECT id, name FROM public.\"User\" WHERE id = ?;";
		User user = null;
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					user = new User(rs.getString("name"), rs.getInt("id"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void addUser(User user) {
		String name = user.getName();
		String sql = "INSERT INTO public.\"User\" (name) VALUES (?);";
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, name);
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				int userId = rs.getInt("id");
				user.setId(userId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void updateUser(User user) {
		String sql = "UPDATE public.\"User\" SET name = ? WHERE id = ? ;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, user.getName());
			stmt.setInt(2, user.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(User user) {
		String sql = "DELETE FROM public.\"User\" WHERE name = ? ;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, user.getName());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
