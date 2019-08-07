package elan.verify.tcc.user;

import elan.verify.tcc.user.biz.User;
import elan.verify.tcc.user.biz.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class InitStack implements ApplicationRunner {
    private final UserRepo userRepo;

    @Autowired
    public InitStack(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.warn("执行初始化操作！");
        // 初始化设置用户余额200
        User u;
        if (userRepo.count() == 0) {
            log.warn("插入新user");
            u = new User();
            u.setBalance(200);
        } else {
            log.warn("修改已有user余额");
            u = userRepo.findAll(PageRequest.of(0, 1)).getContent().get(0);
            u.setBalance(200);
        }
        userRepo.save(u);
        log.warn("初始化完毕！");
    }
}
