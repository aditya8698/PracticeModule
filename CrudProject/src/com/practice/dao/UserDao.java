package com.practice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.practice.dbutility.DbConnection;
import com.practice.model.User;

public class UserDao {

	DbConnection db = new DbConnection();
	Connection con = db.getConnection();
	ResultSet rs = null;
	int a = 0;
	
	public int insertUser(User u) {
		String INSERT_SQL = "insert into user (name,city)values (?,?)";
		try {
			PreparedStatement st = con.prepareStatement(INSERT_SQL);
			st.setString(1, u.getName());
			st.setString(2, u.getCity());
			a = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public ResultSet getUser() {
		String GET_SQL = "select * from user";
		try {
			PreparedStatement st = con.prepareStatement(GET_SQL);
			rs = st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public int updateUser(User u) {
		String UPDATE_SQL = "update user set name=?,city=? where id=?";
		PreparedStatement st;
		try {
			st = con.prepareStatement(UPDATE_SQL);
			st.setString(3, u.getId());
			st.setString(1, u.getName());
			st.setString(2, u.getCity());
			int a = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return a;
	}
	
	public ResultSet beforeUpdate(User u){
		String FETCH_SQL = "select * from user where id=?";
		PreparedStatement st;
		try {
			st = con.prepareStatement(FETCH_SQL);
			st.setInt(1, Integer.parseInt(u.getId()));
			rs = st.executeQuery();
			while(rs.next()){
				u.setName(rs.getString("name"));
				u.setCity(rs.getString("city"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public int deleteUser(String id) {
		int b=0;
		String DELETE_SQL = "delete from user where id=?";
		PreparedStatement st;
		try {
			st = con.prepareStatement(DELETE_SQL);
			st.setInt(1, Integer.parseInt(id));
			b = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

}
