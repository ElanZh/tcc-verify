package elan.verify.tcc.order.biz;

import elan.verify.tcc.order.feign.UserFeign;
import org.dromara.hmily.common.exception.HmilyRuntimeException;
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
public class OrderCtrl {
    private final UserFeign userFeign;
    private final OrderRepo orderRepo;

    public OrderCtrl(UserFeign userFeign, OrderRepo orderRepo) {
        this.userFeign = userFeign;
        this.orderRepo = orderRepo;
    }

    @Transactional(rollbackFor = Exception.class)
    @GetMapping("create")
    public boolean create(int userId){
        // 总价定死150
        final int amount = 150;
        // 减扣用 户余额
        Boolean b = userFeign.subtractBalance(userId, amount);
        if (!b) {
            return false;
        }

        // 创建订单
        Order o = new Order();
        o.setUserId(userId);
        o.setAmount(amount);
        orderRepo.save(o);
        /* 下面直接模拟 RPC之后的异常 */
        throw new HmilyRuntimeException("中断");

//        return true;
    }
}
