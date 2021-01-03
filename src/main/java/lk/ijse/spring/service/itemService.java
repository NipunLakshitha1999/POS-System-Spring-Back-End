package lk.ijse.spring.service;

import lk.ijse.spring.dto.customerDTO;
import lk.ijse.spring.dto.itemDTO;

import java.util.List;

public interface itemService {

    void saveItem(itemDTO dto);

    void updateItem(itemDTO dto);

    itemDTO searchItemDetail(String id);

    void deleteItem(String id);

    List<itemDTO> getAllItem();
}
