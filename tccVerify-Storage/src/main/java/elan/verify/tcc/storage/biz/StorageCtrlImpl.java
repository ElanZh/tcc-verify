package elan.verify.tcc.storage.biz;

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
public class StorageCtrlImpl{
    private final StorageRepo storageRepo;

    @Autowired
    public StorageCtrlImpl(StorageRepo storageRepo) {
        this.storageRepo = storageRepo;
    }

    @GetMapping("subtractStorage")
    @Transactional(rollbackFor = Exception.class)
    public boolean subtractStorage(int storageId, int value){
        return storageRepo.tryForSubtract(storageId, value) == 1;
    }

}
