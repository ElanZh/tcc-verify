package elan.verify.tcc.storage.biz;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 张一然
 * @date 2019年-08月-01号 上午10:57
 * @Description TODO
 */
@Service("storageConfirm")
public class StorageConfirmImpl{
    private final StorageRepo storageRepo;

    public StorageConfirmImpl(StorageRepo storageRepo) {
        this.storageRepo = storageRepo;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean subtractStorage(int storageId, int value) {
        return storageRepo.confirmForSubtract(storageId) == 1;
    }
}
