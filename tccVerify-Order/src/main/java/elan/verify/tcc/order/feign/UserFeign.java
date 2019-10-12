package elan.verify.tcc.order.feign;

import org.dromara.hmily.annotation.Hmily;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 张一然
 * @date 2019/10/10 14:44
 * @Description
 */
@FeignClient(value = "tccVerify-user")
public interface UserFeign {

    /**
     * @description
     * @param userId
     * @param value
     * @return boolean
     * @author 张一然
     * @date 2019/7/2 下午1:55
     */
    @Hmily
    @RequestMapping(method = RequestMethod.GET, value = "user/subtractBalance")
    Boolean subtractBalance(@RequestParam("userId") int userId, @RequestParam("value") int value);
}
