package testData;

import util.Reader;

public class User {
	
		private String username;
		private String password;
		
		public User(String fileName) {
			this.username = Reader.json(fileName).get("username").toString();
			this.password = Reader.json(fileName).get("password").toString();
		}
		
		public void setUsername(String username) {
			this.username = username;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getUsername() {
			return this.username;
		}
		public String getPassword() {
			return this.password;
		}
	}



