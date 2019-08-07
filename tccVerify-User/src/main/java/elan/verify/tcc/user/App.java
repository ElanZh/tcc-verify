package elan.verify.tcc.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "elan.verify.tcc.user.biz", entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "jtaTransactionManager")
@SpringBootApplication(scanBasePackages = "elan.verify.tcc.user", exclude = { MongoAutoConfiguration.class }) // 使用文件存储时, 不需要配置mongodb
@EntityScan(basePackages = {"elan.verify.tcc.user.tcc","elan.verify.tcc.user.biz"})
@EnableDiscoveryClient
@Slf4j
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        log.info("user-启动成功");
    }
}
