package elan.verify.tcc.order.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author 张一然
 * @date 2019/10/11 16:52
 * @Description
 */
@Component
@Slf4j
public class UserFeignFallBack implements UserFeign {
    @Override
    public Boolean subtractBalance(int userId, int value) {
        log.warn("执行 UserFeignFallBack.subtractBalance");
        return false;
    }
}
