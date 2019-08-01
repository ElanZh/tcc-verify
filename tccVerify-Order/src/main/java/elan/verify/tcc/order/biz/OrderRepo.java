package elan.verify.tcc.order.biz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 张一然
 * @date 2019年-07月-02号 上午9:50
 */
@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
    int deleteAllByIdIsNotNull();
}
