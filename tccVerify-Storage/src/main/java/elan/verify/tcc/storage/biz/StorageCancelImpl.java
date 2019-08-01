package elan.verify.tcc.storage.biz;

import elan.verify.tcc.storage.tcc.IStorageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 张一然
 * @date 2019年-08月-01号 上午10:58
 * @Description TODO
 */
@Service("storageCancel")
public class StorageCancelImpl implements IStorageService {
    private final StorageRepo storageRepo;

    public StorageCancelImpl(StorageRepo storageRepo) {
        this.storageRepo = storageRepo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean subtractStorage(int storageId, int value) {
        return storageRepo.cancelForSubtract(storageId) == 1;
    }
}
