package lk.ijse.spring.controller;

import lk.ijse.spring.dto.itemDTO;
import lk.ijse.spring.service.itemService;
import lk.ijse.spring.util.StandedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    itemService itemService;


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addItem(@RequestBody itemDTO dto){
        itemService.saveItem(dto);

        return new ResponseEntity(new StandedResponse(200,"Success",null), HttpStatus.OK);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateItem(@RequestBody itemDTO dto){
        itemService.updateItem(dto);

        return new ResponseEntity(new StandedResponse(200,"Success",null), HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteItem(@RequestParam String id){
        itemService.deleteItem(id);

        return new ResponseEntity(new StandedResponse(200,"Success",null), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchItemByID(@PathVariable String id){
        itemDTO itemDTO = itemService.searchItemDetail(id);
        System.out.println(itemDTO.toString());
        return new ResponseEntity(new StandedResponse(200,"Success",itemDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllItem(){
        List<itemDTO> allItem = itemService.getAllItem( );

        return new ResponseEntity(new StandedResponse(200,"Success",allItem), HttpStatus.OK);
    }
}
