package elan.verify.tcc.biz.order;

import elan.verify.tcc.biz.tcc.IBizService;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 张一然
 * @date 2019年-07月-02号 上午11:08
 */
@RestController
@RequestMapping("orderBiz")
@Compensable(
        interfaceClass = IBizService.class,
        simplified = true
)
public class OrderBizCtrl {
    private final OrderFeign orderFeign;
    private final StorageFeign storageFeign;

    @Autowired
    public OrderBizCtrl(OrderFeign orderFeign, StorageFeign storageFeign) {
        this.orderFeign = orderFeign;
        this.storageFeign = storageFeign;
    }

    @GetMapping("createOrder")
    @Transactional(rollbackFor = Exception.class)
    public boolean createOrder(int userId) {
        // 减扣库存
        if (!storageFeign.subtractStorage(1, 1)) {
            throw new RuntimeException("减扣库存失败，下单失败");
        }
        // 创建订单
        if (!orderFeign.createOrder(userId)) {
            throw new RuntimeException("创建订单失败");
        }
        return true;
    }
}
