package customer;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	
	Customer(){
		
	}
	Customer(String name ,String email){
		this.name=name;
		this.email=email;
		
	}
 private String  name;
 private String email;
 private @Id long id;

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
 
 
}
