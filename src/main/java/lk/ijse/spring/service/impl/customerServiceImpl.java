package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.customerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.customerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class customerServiceImpl implements customerService {

    @Autowired
    CustomerRepo repo;

    @Autowired
    ModelMapper modelMapper;


    public void saveCustomer(customerDTO dto) {
        if(!repo.existsById(dto.getId())){
            Customer c= modelMapper.map(dto,Customer.class);
            repo.save(c);
        }else {
            throw new RuntimeException("customer already exists");
        }

    }


    public void updateCustomer(customerDTO dto) {

        if(repo.existsById(dto.getId())){
            Customer c= modelMapper.map(dto,Customer.class);
            repo.save(c);
        }else {
            throw new RuntimeException("no such customer update");
        }

    }


    public customerDTO searchCustomerDetail(String id) {
        Optional<Customer> byId = repo.findById(id);
        if(byId.isPresent()){
            return modelMapper.map(byId.get(),customerDTO.class);
        }else {
            throw new RuntimeException("invalid id");
        }

    }

    public void deleteCustomer(String id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
        }else {
            throw  new RuntimeException("no customer for this id");
        }

    }

    public List<customerDTO> getAllCustomers() {
        List<Customer> all = repo.findAll( );

        return modelMapper.map(all,new TypeToken<List<customerDTO>>(){}.getType());
    }
}
