package com.cg.drycleaning.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.drycleaning.beans.Address;
import com.cg.drycleaning.beans.Customer;
import com.cg.drycleaning.service.ICustomerService;

@SpringBootTest
public class CustomerServiceTest {
	
	@Autowired
	private ICustomerService iCustomerService;
	
	@Test
	public void addCustomerTest() {
		Customer customer=new Customer();
		Address address=new Address("2-104", "S Street", "VKP", "Guntur", "AP", 522020);
		customer.setUserId("ram123");
		customer.setName("Ram Babu");
		customer.setEmail("rb.alokam@gmail.com");
		customer.setContactNo("9493939132");
		customer.setAddress(address);
		assertEquals("Ram Babu",iCustomerService.addCustomer(customer).getName());
	}
	@Test
	public void updateCustomerTest() {
		Customer customer=new Customer();
		Address address=new Address("2-104", "S Street", "VKP", "Guntur", "AP", 522020);
		customer.setUserId("ram123");
		customer.setName("Ram Babu Alokam");
		customer.setEmail("rb.alokam@gmail.com");
		customer.setContactNo("9493939132");
		customer.setAddress(address);
		iCustomerService.addCustomer(customer);
		assertEquals("Ram Babu Alokam", iCustomerService.updateCustomer("ram123", customer).getName());
	}
	@Test
	public void getCustomerTest() {
		Customer customer=new Customer();
		Address address=new Address("2-104", "S Street", "VKP", "Guntur", "AP", 522020);
		customer.setUserId("ram123");
		customer.setName("Ram Babu");
		customer.setEmail("rb.alokam@gmail.com");
		customer.setContactNo("9493939132");
		customer.setAddress(address);
		iCustomerService.addCustomer(customer);
		assertEquals("ram123", iCustomerService.getCustomer("ram123").getUserId());
	}
	@Test
	public void removeCustomerTest() {
		Customer customer=new Customer();
		Address address=new Address("2-104", "S Street", "VKP", "Guntur", "AP", 522020);
		customer.setUserId("Ram123");
		customer.setName("Ram Babu");
		customer.setEmail("rb.alokam@gmail.com");
		customer.setContactNo("9493939132");
		customer.setAddress(address);
		iCustomerService.addCustomer(customer);
		assertEquals("9493939132", iCustomerService.removeCustomer("Ram123").getContactNo());
	}
	@Test
	public void getAllCustomersTest() {
		Customer customer=new Customer();
		Address address=new Address("2-104", "S Street", "VKP", "Guntur", "AP", 522020);
		customer.setUserId("Ram123");
		customer.setName("Ram Babu");
		customer.setEmail("rb.alokam@gmail.com");
		customer.setContactNo("9493939132");
		customer.setAddress(address);
		Customer customer2=new Customer();
		Address address2=new Address("2-104", "S Street", "VKP", "Guntur", "AP", 522020);
		customer2.setUserId("santu");
		customer2.setName("santosh");
		customer2.setEmail("rb.alokam@gmail.com");
		customer2.setContactNo("9493939132");
		customer2.setAddress(address2);
		iCustomerService.addCustomer(customer2);
		iCustomerService.addCustomer(customer);
		assertEquals(8, iCustomerService.getAllCustomers().size());
		System.out.println(iCustomerService.getAllCustomers().size());
	}

}
