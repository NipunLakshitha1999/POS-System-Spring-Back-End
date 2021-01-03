package lk.ijse.spring.service.impl;

import lk.ijse.spring.config.webAppConfig;
import lk.ijse.spring.config.webRootConfig;
import lk.ijse.spring.dto.customerDTO;
import lk.ijse.spring.service.customerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

//test eka hda gnne test krnna oni class eke nma gwta gihi alt+enter
//transctional eka dmma db ekta data yn nha hby eya test krla bnlwa data commite krnna puluwnda barid kyla blnwa
@Transactional
@WebAppConfiguration
@ContextConfiguration(classes = {webRootConfig.class, webAppConfig.class})
@RunWith(SpringRunner.class)
public class customerServiceImplTest {

    @Autowired
    customerService customerService;

    @Test
    public void saveCustomer() {
        customerDTO c1=new customerDTO("C005","nimal","panadura",2000);
        customerService.saveCustomer(c1);
    }

    @Test
    public void updateCustomer() {
        customerDTO c005 = customerService.searchCustomerDetail("C005");
        Assert.assertNotNull(c005);
        c005.setName("lakshitha");
        customerService.updateCustomer(c005);
    }

    @Test
    public void searchCustomerDetail() {
        customerDTO c001 = customerService.searchCustomerDetail("C001");
        Assert.assertNotNull(c001);
        System.out.println(c001);


        //check invalid id for exception
        Assert.assertThrows(RuntimeException.class,()->{
           customerService.searchCustomerDetail("C002");
        });
    }

    @Test
    public void deleteCustomer() {
        customerService.deleteCustomer("C002");
    }

    @Test
    public void getAllCustomers() {
        customerService.getAllCustomers();
    }
}
