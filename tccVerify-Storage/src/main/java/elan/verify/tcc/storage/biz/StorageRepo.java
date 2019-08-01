package elan.verify.tcc.storage.biz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StorageRepo extends JpaRepository<Storage, Integer> {
    @Transactional
    @Modifying
    @Query("update Storage s set s.subtractQuantity = ?2, s.status = s.StorageStatus.SUBTRACTING " +
            "where s.id = ?1 and s.stock >= ?2 and s.status=s.StorageStatus.ENABLE")
    int tryForSubtract(int id, int value);

    @Transactional
    @Modifying
    @Query("update Storage s set s.stock = s.stock - s.subtractQuantity, s.subtractQuantity = 0, s.status = s.StorageStatus.ENABLE " +
            "where s.id = ?1 and s.status = s.StorageStatus.SUBTRACTING")
    int confirmForSubtract(int id);

    @Transactional
    @Modifying
    @Query("update Storage s set s.status = s.StorageStatus.ENABLE, s.subtractQuantity = 0 " +
            "where s.id = ?1 and s.status = s.StorageStatus.SUBTRACTING")
    int cancelForSubtract(int id);
}
