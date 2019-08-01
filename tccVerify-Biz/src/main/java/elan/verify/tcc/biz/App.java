package elan.verify.tcc.biz;

import lombok.extern.slf4j.Slf4j;
import org.bytesoft.bytetcc.supports.springcloud.config.SpringCloudConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "elan.verify.tcc.biz", exclude = { MongoAutoConfiguration.class })
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrixDashboard
@Import(SpringCloudConfiguration.class)
@Slf4j
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        log.info("biz-启动成功");
    }

}
