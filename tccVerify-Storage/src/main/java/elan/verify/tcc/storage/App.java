package elan.verify.tcc.storage;

import lombok.extern.slf4j.Slf4j;
import org.bytesoft.bytetcc.supports.springcloud.config.SpringCloudConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "elan.verify.tcc.storage", exclude = { MongoAutoConfiguration.class })
@EnableDiscoveryClient
@Slf4j
@Import(SpringCloudConfiguration.class)
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        log.info("storage-启动成功");
    }

}
