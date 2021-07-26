package com.example.demoonetoone;

import com.example.demoonetoone.dao.AddressDao;
import com.example.demoonetoone.dao.CustomerDao;
import com.example.demoonetoone.entities.Address;
import com.example.demoonetoone.entities.Customer;
import com.example.demoonetoone.service.CustomerService;
import com.example.demoonetoone.util.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;


@SpringBootApplication
public class DemoOneToOneApplication implements CommandLineRunner{

    @Autowired
    private  CustomerService customerService;


    public static void main(String[] args) {
        SpringApplication.run(DemoOneToOneApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       customerService.saveData();


      /* Customer customer=customerService.findCustomerById(1);
        Address address=customer.getAddress();

        Address address1=customerService.findAddressById(2);
        Customer customer1=address1.getCustomer();




        System.out.println(String.format("%s lives in %s",customer.getName(),address.getStreetName()));
        System.out.println(String.format("%s lives in %s",customer1.getName(),address1.getStreetName()));
    */

        JPAUtil.checkData("select * from address");
        JPAUtil.checkData("select * from customer");
    }
}
