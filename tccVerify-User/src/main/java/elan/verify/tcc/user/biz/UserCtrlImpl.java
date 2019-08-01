package elan.verify.tcc.user.biz;

import elan.verify.tcc.user.tcc.IUserBalanceService;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@Compensable(
        interfaceClass = IUserBalanceService.class,
        cancellableKey = "userBalanceCancel"
)
public class UserCtrlImpl implements IUserBalanceService {

    private final UserRepo userRepo;

    @Autowired
    public UserCtrlImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @GetMapping("subtractBalance")
    public boolean subtractBalance(int userId, int value){
        return userRepo.updateForSubtract(userId, value) == 1;
    }
}
