package elan.verify.tcc.user.biz;

import elan.verify.tcc.user.tcc.IUserBalanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 张一然
 * @date 2019年-08月-01号 下午1:55
 * @Description TODO
 */
@Service("userBalanceCancel")
@Slf4j
public class UserBalanceCancelImpl implements IUserBalanceService {

    private final UserRepo userRepo;

    public UserBalanceCancelImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean subtractBalance(int userId, int value) {
        log.warn("开始取消用户余额减扣：user=" + userId + ", value=" + value);
        return userRepo.updateForAdd(userId, value) == 1;
    }
}
