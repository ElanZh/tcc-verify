package elan.verify.tcc.user.biz;

import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.Hmily;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 张一然
 * @date 2019年-08月-01号 下午1:55
 * @Description TODO
 */
@Service("userBalanceCancel")
@Slf4j
public class UserBalanceService {

    private final UserRepo userRepo;

    public UserBalanceService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Transactional(rollbackFor = Exception.class)
    @Hmily(confirmMethod = "confirmSubtract", cancelMethod = "cancelSubtract")
    public boolean subtractBalance(int userId, int value) {
        log.warn("try用户余额减扣：user=" + userId + ", value=" + value);
        return userRepo.updateForTrySubtract(userId, value) == 1;
    }

    public boolean confirmSubtract(int userId, int value){
        log.warn("confirm用户余额减扣：user=" + userId + ", value=" + value);
        return userRepo.updateForConfirmSubtract(userId, value) == 1;
    }

    public boolean cancelSubtract(int userId, int value){
        log.warn("cancel用户余额减扣：user=" + userId + ", value=" + value);
        return userRepo.updateForCancelSubtract(userId, value) == 1;
    }
}
