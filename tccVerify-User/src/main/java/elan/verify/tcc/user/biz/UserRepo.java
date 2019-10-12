package elan.verify.tcc.user.biz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    /**
     * try阶段减扣余额
     */
    @Modifying
    @javax.transaction.Transactional
    @Query("update User u set u.balance = u.balance - ?2, u.freezeBalance = u.freezeBalance + ?2 where u.id = ?1 and u.balance >= ?2")
    int updateForTrySubtract(int userId, int value);

    /**
     * confirm阶段减扣余额
     */
    @Modifying
    @javax.transaction.Transactional
    @Query("update User u set u.freezeBalance = u.freezeBalance - ?2 where u.id = ?1 and u.freezeBalance >= ?2")
    int updateForConfirmSubtract(int userId, int value);

    /**
     * cancel阶段减扣余额
     */
    @Modifying
    @javax.transaction.Transactional
    @Query("update User u set u.balance = u.balance + ?2, u.freezeBalance = u.freezeBalance - ?2 where u.id = ?1 and u.freezeBalance >= ?2")
    int updateForCancelSubtract(int userId, int value);

    @Modifying
    @javax.transaction.Transactional
    @Query("update User u set u.balance = u.balance + ?2 where u.id = ?1")
    int updateForAdd(int userId, int value);

}
