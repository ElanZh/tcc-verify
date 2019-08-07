package elan.verify.tcc.user.tcc;

/**
 * @author 张一然
 * @date 2019年-08月-01号 下午1:53
 */

public interface IUserBalanceService {
    boolean subtractBalance(int userId, int value);
}
