package elan.verify.tcc.storage.biz;

import elan.verify.tcc.storage.tcc.IStorageService;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 张一然
 * @date 2019年-07月-01号 下午7:28
 */
@RestController
@RequestMapping("storage")
@Compensable(
        interfaceClass = IStorageService.class,
        confirmableKey = "storageConfirm",
        cancellableKey = "storageCancel"
)
public class StorageCtrlImpl implements IStorageService{
    private final StorageRepo storageRepo;

    @Autowired
    public StorageCtrlImpl(StorageRepo storageRepo) {
        this.storageRepo = storageRepo;
    }

    @Override
    @GetMapping("subtractStorage")
    @Transactional(rollbackFor = Exception.class)
    public boolean subtractStorage(int storageId, int value){
        return storageRepo.tryForSubtract(storageId, value) == 1;
    }

}
