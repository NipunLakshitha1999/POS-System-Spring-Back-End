package lk.ijse.spring.controller;

import lk.ijse.spring.dto.customerDTO;
import lk.ijse.spring.service.customerService;
import lk.ijse.spring.util.StandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {



    @Autowired
    customerService customerService;

//    @PostMapping
//    public String addCustomer(@RequestBody customerDTO dto){
//        //meka invalide//
//        //conttroller eke idn dao layer eka access krnna ba
//        Customer c=new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getSalary());
//        repo.save(c);
//        return "done";
//
//    }

//    @PostMapping
//    public String addCustomer(@RequestBody customerDTO dto){
//       Customer c= modelMapper.map(dto,Customer.class);
//        repo.save(c);
//        return "done";
//
//    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addCustomer(@RequestBody customerDTO dto){
        customerService.saveCustomer(dto);
        return new ResponseEntity(new StandedResponse(200,"success",null), HttpStatus.OK);

    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteCustomer(@RequestParam String id){
        customerService.deleteCustomer(id);
        return new ResponseEntity(new StandedResponse(200,"success",null),HttpStatus.OK);

    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateCustomer(@RequestBody customerDTO dto){
        customerService.updateCustomer(dto);
        return new ResponseEntity(new StandedResponse(200,"success",null),HttpStatus.OK);

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchCustomer(@PathVariable String id){
        customerDTO customerDTO = customerService.searchCustomerDetail(id);
        return new ResponseEntity(new StandedResponse(200,"success",customerDTO),HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity getAllCustomer(){
        List<customerDTO> allCustomers = customerService.getAllCustomers( );
        return new ResponseEntity(new StandedResponse(200,"success",allCustomers),HttpStatus.OK);
    }




}
