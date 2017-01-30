package com.s3s.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.s3s.models.Customer;

/**
 * customer dao implementation
 * 
 * @author Biwan Chhetri
 * @since Nov 17, 2016
 */
public class CustomerDao implements ICustomerDao {

	private static final String ADD_CUSTOMER = "insert into customer(firstName, lastName, address, email, age)"
			+ "values(?,?,?,?,?)";
	private static final String DELETE_BY_ID = "DELETE FROM customer WHERE customer.id =";

	private static PreparedStatement preparedStatement;

	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/s3sdatabase";
		String user = "root";
		String password = "test";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("no driver found or loaded.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("no connection found.");
		}
		return conn;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean add(Customer customer) {
		boolean result = false;
		try {
			PreparedStatement psmt = getPreparedStatement();
			psmt.setString(1, customer.getFirstName());
			psmt.setString(2, customer.getLastName());
			psmt.setString(3, customer.getAddress());
			psmt.setString(4, customer.getEmail());
			psmt.setInt(5, customer.getAge());
			psmt.execute(); // running
			result = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static PreparedStatement getPreparedStatement() throws SQLException {
		if (preparedStatement == null) {
			preparedStatement = getConnection().prepareStatement(ADD_CUSTOMER);
		}
		return preparedStatement;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer getById(int id) {

		Connection conn = getConnection();
		String query = "select * from customer where id=" + id;
		Customer customer = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setFirstName(rs.getString("firstName"));
				customer.setLastName(rs.getString("lastName"));
				customer.setAddress(rs.getString("address"));
				customer.setEmail(rs.getString("email"));
				break;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	@Override
	public boolean update(Customer customer) {

		boolean status = false;
		Connection connection = getConnection();
		String query = "UPDATE customer SET firstName=?, lastName=?, address=?, email=?, age=? WHERE customer.id = ?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setString(3, customer.getAddress());
			ps.setString(4, customer.getEmail());
			ps.setInt(5, customer.getAge());
			ps.setInt(6, customer.getId());

			ps.executeUpdate();
			status = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return status;
	}

	@Override
	public List<Customer> getAll() {

		List<Customer> customers = new ArrayList<Customer>();
		Connection connection = getConnection();
		Customer customer = null;

		try {
			String sql = "{call getAllCustomer()}";
			CallableStatement cs = connection.prepareCall(sql);
			ResultSet rs = cs.executeQuery();
			while (rs.next()) {
				customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setFirstName(rs.getString("firstName"));
				customer.setLastName(rs.getString("lastName"));
				customer.setAddress(rs.getString("address"));
				customer.setEmail(rs.getString("email"));
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	@Override
	public boolean delete(int id) {
		boolean status = false;
		Connection connection = getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(DELETE_BY_ID + id);
			ps.executeUpdate();
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}
		return status;
	}

	@Override
	public boolean addAllCustomer(List<Customer> customers) {
		boolean result = false;
		try {
			
			Statement stmt = getConnection().createStatement();
			List<String> allQuery = getAllBatchQuery(customers);
			for (String query : allQuery) {
				stmt.addBatch(query);
			}
			stmt.executeBatch();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private List<String> getAllBatchQuery(List<Customer> customers) {
		List<String> queryList = new ArrayList<String>();
		for (Customer customer : customers) {
			String sql = "insert into customer(firstName,lastName,email,address,age) values(" + 
		            "\'" + customer.getFirstName() + "\'," +
                    "\'" + customer.getLastName() + "\'," + 
		            "\'" + customer.getEmail() + "\'," +
                    "\'" + customer.getAddress() + "\'," +
		            "\'" + customer.getAge()+ "\'" + 
                    ")";
			queryList.add(sql);
		}
		return queryList;
	}

	public static void main(String[] args) {

		ICustomerDao customerDao = new CustomerDao();
		
		Customer c1 = new Customer();
		c1.setFirstName("name1");
		c1.setLastName("lastName1");
		c1.setAddress("address1");
		c1.setEmail("email1@gmail.com");
		c1.setAge(85);
		
		Customer c2 = new Customer();
		c2.setFirstName("name2");
		c2.setLastName("lastName2");
		c2.setAddress("address2");
		c2.setEmail("email2@gmail.com");
		c2.setAge(66);
		
		Customer c3 = new Customer();
		c3.setFirstName("name3");
		c3.setLastName("lastName3");
		c3.setAddress("address3");
		c3.setEmail("email3@gmail.com");
		c3.setAge(44);
		
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		
		System.out.println(customerDao.addAllCustomer(customers));
	}

}
