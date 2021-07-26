package com.example.demoonetoone.service;


import com.example.demoonetoone.dao.AddressDao;
import com.example.demoonetoone.dao.CustomerDao;
import com.example.demoonetoone.entities.Address;
import com.example.demoonetoone.entities.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    private final CustomerDao customerDao;
    private final AddressDao addressDao;

    public CustomerService(CustomerDao customerDao, AddressDao addressDao) {
        this.customerDao = customerDao;
        this.addressDao = addressDao;
    }

    @Transactional
    public void saveData(){
        Customer customer1=new Customer("Thaw Thaw",23);
        Customer customer2=new Customer("Thu Thu Thaw",25);

        Address address1=new Address("Dream Land","Yangon");
        Address address2=new Address("79 Park Avenue","India");

        //mapping
        address1.setCustomer(customer1);
        address2.setCustomer(customer2);
        customer1.setAddress(address1);
        customer2.setAddress(address2);

        customerDao.save(customer1);
        customerDao.save(customer2);
        //addressDao.save(address1);
       // addressDao.save(address2);




    }

    public Address findAddressById(int id){
        return addressDao.getById(id);
    }


    public Customer findCustomerById(int id){
        return customerDao.getById(id);
    }

}
