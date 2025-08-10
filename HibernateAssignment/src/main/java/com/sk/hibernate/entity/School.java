package com.sk.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
  // <-- changed from "User"
public class School {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
	    private int id;

	    
	    private String firstName;
	    
	    
	    private String lastName;
	    
	    
	    private String userName;

	    
	    private String email;
	    
	    
	    @Enumerated(EnumType.STRING)
	    @Column(name = "Gender")
	    private Gender gender;

		

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		
		public Gender getGender() {
			return gender;
		}

		public void setGender(Gender gender) {
			this.gender = gender;
		}

		public School() {
			super();
		}


		@Override
		public String toString() {
			return "School [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
					+ ", email=" + email + ", gender=" + gender + "]";
		}

		public School(String firstName, String lastName, String userName, String email) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.userName = userName;
			this.email = email;
			this.gender = gender;
		}

		

		
	    
	    
	    
}
