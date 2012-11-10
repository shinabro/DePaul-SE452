package edu.depaul.cdm.se.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.sql.DataSource;

import users.IUser;
import users.UserPersistenceException;
import users.dao.JDBCDAO;
import users.dao.dataobject.User;

@ManagedBean(name="user")
@SessionScoped
public class UserBean implements Serializable {
		//resource injection
		@Resource(name="jdbc/TestDB")
		private DataSource ds;
	 
		//if resource injection is not support, you still can get it manually.
		/*public UserBean(){
			try {
				Context ctx = new InitialContext();
				ds = (DataSource)ctx.lookup("java:comp/env/jdbc/TestDB");
			} catch (NamingException e) {
				e.printStackTrace();
			}
	 
		}*/

		private String name;
		private Date birthDay;
		private String password;
		 
		public Date getBirthDay() {
			return birthDay;
		}

		public void setBirthDay(Date birthday) {
			this.birthDay = birthday;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}


		//connect to DB and get customer list
		public List<IUser> getUserList() throws UserPersistenceException{
	 
			// TODO:  Pass data resource
			JDBCDAO dao = new JDBCDAO();
			List<IUser>users = dao.getUsers();
			return users;
		}	
		
		public String addUser() throws UserPersistenceException {
			//get database connection
			User user = new User();
			user.setName(name);
			JDBCDAO dao = new JDBCDAO();
			dao.saveUser(user);
			
			return "showList";
		}
		
		public String delete(User user) throws UserPersistenceException {
			JDBCDAO dao = new JDBCDAO();
			dao.deleteUser(user);
			return null; 
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
}
