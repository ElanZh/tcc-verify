package elan.verify.tcc.order;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.bytesoft.bytejta.supports.jdbc.LocalXADataSource;
import org.bytesoft.bytetcc.supports.springcloud.config.SpringCloudConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@SpringBootApplication(scanBasePackages = "elan.verify.tcc.order", exclude = { MongoAutoConfiguration.class })
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrixDashboard
@Slf4j
@Import(SpringCloudConfiguration.class)
@Configuration
public class App {
    @Autowired
    private HikariDataSource hikariDataSource;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        log.info("order-启动成功");
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        LocalXADataSource dataSource = new LocalXADataSource();
        dataSource.setDataSource(hikariDataSource);
        return dataSource;
    }

}
