package lk.ijse.spring.service;

import lk.ijse.spring.dto.orderDTO;

import java.util.List;

public interface orderService {
    void saveOrder(orderDTO dto);
    List<orderDTO> getAllOrders();
}
