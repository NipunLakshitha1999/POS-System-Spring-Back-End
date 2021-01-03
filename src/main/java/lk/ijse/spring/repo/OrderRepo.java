package lk.ijse.spring.repo;

import lk.ijse.spring.entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<CustomerOrder,String> {
}
