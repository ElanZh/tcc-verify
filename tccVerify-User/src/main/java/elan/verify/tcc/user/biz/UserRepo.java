package elan.verify.tcc.user.biz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    @Modifying
    @Query(value = "update User u set u.balance = u.balance - ?2 where u.id = ?1 and u.balance >= ?2")
    @javax.transaction.Transactional
    int updateForSubtract(int userId, int value);

    @Modifying
    @Query("update User u set u.balance = u.balance + ?2 where u.id = ?1")
    @javax.transaction.Transactional
    int updateForAdd(int userId, int value);

}
