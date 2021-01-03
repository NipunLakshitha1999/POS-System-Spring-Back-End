package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.itemDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.service.itemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class itemServiceImpl implements itemService {

    @Autowired
    ItemRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveItem(itemDTO dto) {
        if(!repo.existsById(dto.getId())){
            Item item = mapper.map(dto, Item.class);
            repo.save(item);
        }else {
            throw new RuntimeException("Item is Already exists");
        }

    }

    @Override
    public void updateItem(itemDTO dto) {

        if(repo.existsById(dto.getId())){
            Item item = mapper.map(dto, Item.class);
            repo.save(item);
        }else {
            throw new RuntimeException("this item is invalid");
        }
    }

    @Override
    public itemDTO searchItemDetail(String id) {
        Optional<Item> item = repo.findById(id);
        if(item.isPresent()){
            return mapper.map(item.get(),itemDTO.class);
        }else{
            throw new RuntimeException("invalid id");
        }
    }

    @Override
    public void deleteItem(String id) {

        if(repo.existsById(id)){
            repo.deleteById(id);
        }else{
            throw new RuntimeException("invalid ID");
        }

    }

    @Override
    public List<itemDTO> getAllItem() {
        List<Item> all = repo.findAll( );

        return mapper.map(all,new TypeToken<List<itemDTO>>(){}.getType());
    }
}
