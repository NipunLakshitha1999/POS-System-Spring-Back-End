package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.orderDTO;
import lk.ijse.spring.entity.CustomerOrder;
import lk.ijse.spring.repo.OrderRepo;
import lk.ijse.spring.service.orderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class orderServiceImpl implements orderService {

    @Autowired
    OrderRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveOrder(orderDTO dto) {
        if(!repo.existsById(dto.getOrderID())){
            CustomerOrder order = mapper.map(dto, CustomerOrder.class);
            repo.save(order);
        }else{
            throw new RuntimeException("Order is already exist");
        }
    }

    @Override
    public List<orderDTO> getAllOrders() {
        List<CustomerOrder> all = repo.findAll( );
        return mapper.map(all,new TypeToken<List<orderDTO>>(){}.getType());
    }
}
