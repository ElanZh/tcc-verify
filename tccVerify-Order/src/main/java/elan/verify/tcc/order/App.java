package elan.verify.tcc.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients
@EnableTransactionManagement
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = {"org.dromara.hmily.*","elan.verify.tcc.order.*"})
@Slf4j
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        log.info("order-启动成功");
    }

}
