package elan.verify.tcc.order.biz;

import elan.verify.tcc.order.tcc.IOrderService;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张一然
 * @date 2019年-07月-01号 下午7:56
 * orderctrl
 */
@RestController
@RequestMapping("order")
@Compensable(
        interfaceClass = IOrderService.class,
        simplified = true
)
public class OrderCtrlImpl implements IOrderService{
    private final UserFeign userFeign;
    private final OrderRepo orderRepo;

    @Autowired
    public OrderCtrlImpl(UserFeign userFeign, OrderRepo orderRepo) {
        this.userFeign = userFeign;
        this.orderRepo = orderRepo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @GetMapping("create")
    public boolean create(int userId){
        // 总价定死150
        final int amount = 150;
        // 减扣用 户余额
        if (!userFeign.subtractBalance(userId, amount)) {
            return false;
        }

        // 创建订单
        Order o = new Order();
        o.setUserId(userId);
        o.setAmount(amount);
        orderRepo.save(o);
        return true;
    }
}
