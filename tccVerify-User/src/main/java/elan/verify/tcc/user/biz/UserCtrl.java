package elan.verify.tcc.user.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserCtrl {

    private final UserBalanceService userBalanceService;

    @Autowired
    public UserCtrl(UserBalanceService userBalanceService) {
        this.userBalanceService = userBalanceService;
    }

    @GetMapping("subtractBalance")
    public boolean subtractBalance(int userId, int value){
        return userBalanceService.subtractBalance(userId, value);
    }
}
