package customer;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
private CustomerRepository repo;
	
public CustomerController(CustomerRepository repo) {
	this.repo=repo;
}
	@GetMapping("/sm")
	
	//to make accessible this via routing we should add getmapping and end point will be customer as 
	//i mentioned here 
	
	
	List<Customer>  all(){
		return repo.findAll();
	}
 @PostMapping("/sm")
 
	Customer save(@RequestBody Customer newCustomer){
	 return repo.save(newCustomer);  
 }
 @GetMapping("/sm/{id}")
Customer get(@PathVariable Long id){
	 return repo.findById(id)
			 .orElseThrow(()-> new CustomerNotFoundException(id));
 }
 
 @PutMapping("/sm/{id}")
 Optional<Customer> update(@PathVariable Long id,@RequestBody Customer newCustomer){
	return  repo.findById(id).map(Customer->{
		 Customer.setEmail(newCustomer.getEmail());
		 return Customer;
	 });
 }
 
 @DeleteMapping("/sm/{id}")
 void  delete(@PathVariable Long id){
	 repo.deleteById(id);
	 
 }

}
