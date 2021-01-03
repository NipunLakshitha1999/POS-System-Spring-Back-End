package lk.ijse.spring.controller;


import lk.ijse.spring.dto.orderDTO;
import lk.ijse.spring.service.orderService;
import lk.ijse.spring.util.StandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin
public class OrderController {

    @Autowired
    orderService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveOrder(@RequestBody orderDTO dto){
        service.saveOrder(dto);
        return new ResponseEntity(new StandedResponse(200,"Success",null), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllOrderDetails(){
        List<orderDTO> allOrders = service.getAllOrders( );

        return new ResponseEntity(new StandedResponse(200,"Success",allOrders), HttpStatus.OK);
    }
}
