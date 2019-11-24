package com.lti.DTO;

import java.util.Date;

import com.lti.entity.Customer;
import com.lti.enums.Gender;

public class CustomerDTO {

	
	private Integer customerId;
	private String firstName;
	private String lastName;
	private Gender gender;
	private Date dateOfBirth;
		public CustomerDTO(Customer c) {
			this.customerId = c.getCustomerId();
			this.firstName = c.getFirstName();
			this.lastName = c.getLastName();
			this.gender = c.getGender();
			this.dateOfBirth = c.getDateOfBirth();
	}
		
		
		public CustomerDTO() {
			super();
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + customerId;
			result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + ((gender == null) ? 0 : gender.hashCode());
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CustomerDTO other = (CustomerDTO) obj;
			if (customerId != other.customerId)
				return false;
			if (dateOfBirth == null) {
				if (other.dateOfBirth != null)
					return false;
			} else if (!dateOfBirth.equals(other.dateOfBirth))
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (gender == null) {
				if (other.gender != null)
					return false;
			} else if (!gender.equals(other.gender))
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			return true;
		}


		public int getCustomerId() {
			return customerId;
		}
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
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
		public Gender getGender() {
			return gender;
		}
		public void setGender(Gender gender) {
			this.gender = gender;
		}
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		
	

}