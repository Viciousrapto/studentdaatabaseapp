
package studentdatabaseapp;

import java.util.Scanner;

import java.sql.ResultSet;
import java.sql.SQLException;

public class studentManagement {
	public static void userManagement() throws SQLException {
		Scanner r = new Scanner(System.in);
		boolean canIKeepRunning = true;
		while (canIKeepRunning == true) {
			System.out.println("******WELCOME TO STUDENT DATABASE APP****");
			System.out.println("\n");
			System.out.println("What would you like to do:");

			System.out.println("1.Add Student");
			System.out.println("2.Edit  Student");
			System.out.println("3.Search  Student");
			System.out.println("4.Delete  Student");
			System.out.println("5.Quit");

			int option = r.nextInt();
			if (option == 1) {
				addUser();
			} else if (option == 2) {
				System.out.println("Enter the name of  Student to edit:");
				r.nextLine();
				String en = r.nextLine();
				editUser(en);
			} else if (option == 3) {
				System.out.println("Enter the name of  Student to search:");
				r.nextLine();
				String sn = r.nextLine();
				searchUser(sn);
			} else if (option == 4) {
				System.out.println("Enter the name of  Student to delete:");
				r.nextLine();
				String dn = r.nextLine();
				deleteUser(dn);
			} else if (option == 5) {
				System.out.println("Program finished!!");
				canIKeepRunning = false;

			}
		}
	}

	public static void addUser() {

		Scanner r = new Scanner(System.in);
		Student s = new Student();

		System.out.println("Enter Studentname:");
		s.userName = r.nextLine();

		System.out.println("Enter login name:");
		s.login = r.nextLine();

		System.out.println("Enter password:");
		s.passwords = r.nextLine();

		System.out.println("Enter cofirm password:");
		s.password2 = r.nextLine();

		System.out.println("Enter Student role:");
		s.userRole = r.nextLine();

		String query = "INSERT INTO Student(StudentName , login , passwords , password2 , userRole) VALUES  ('"
				+ s.StudentName + "', '" + s.login + "', '" + s.passwords + "','" + s.password2 + "','" + s.userRole
				+ "' ";
		DBUtils.executeQuery(query);
	}

	public static void searchUser(String userName) throws SQLException {
		String query = "select * from Users where userName= '" + userName + "'";

		ResultSet rs = DBUtils.executeQueryGetResult(query);
		try {
			while (rs.next()) {
				if (rs.getString("username").equalsIgnoreCase(userName)) {
					System.out.println("Username:" + rs.getString("userName"));
					System.out.println("Login name:" + rs.getString("login"));
					System.out.println("Password:" + rs.getString("passwords"));
					System.out.println("Confirm password:" + rs.getString("userRole"));
					return;
				}

			}
		} catch (Exception e) {
			System.out.println("User not found!!");

		}

	}

	public static void deleteUser(String userName) {
		String query = "delete from Users where userName = '" + userName + "' ";
		DBUtils.executeQuery(query);
	}

	public static void editUser(String name) throws SQLException {
		String query = "select * from Users where username ='" + name + "'";
		ResultSet rs = DBUtils.executeQueryGetResult(query);

		try {
			while (rs.next()) {
				try {
					if (rs.getString("username").equalsIgnoreCase(name)) {
						Student s = new Student();
						Scanner r = new Scanner(System.in);

						System.out.println("New Student name:");
						s.userName = r.nextLine();

						System.out.println("New login name:");
						s.login = r.nextLine();

						System.out.println("New password:");
						s.passwords = r.nextLine();

						System.out.println("New cofirm password:");
						s.password2 = r.nextLine();

						System.out.println("New Student role:");
						s.userRole = r.nextLine();

						String updateQuery = "update Student set" + "StudentName='" + s.userName + "', login='"
								+ s.login + "',passwords='" + s.passwords + "',StudentRole='" + s.userRole + "' ";
						DBUtils.executeQuery(updateQuery);
						System.out.println("Student information updated!!");
						return;
					}
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		} catch (SQLException e) {

			System.out.println("User not found!!");
		}

	}

	public static boolean validateUserAndPasswords(String login, String Passwords) {
		String query = "select * from Users where login='" + login + "' and Passwords='" + Passwords + "' ";
		ResultSet resultset = DBUtils.executeQueryGetResult(query);
		try {
			if (resultset.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
