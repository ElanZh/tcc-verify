package elan.verify.tcc.user;

import lombok.extern.slf4j.Slf4j;
import org.bytesoft.bytetcc.supports.springcloud.config.SpringCloudConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "elan.verify.tcc.user", exclude = { MongoAutoConfiguration.class })
@EnableDiscoveryClient
@Slf4j
@Import(SpringCloudConfiguration.class)
//@Configuration
public class App {
//    @Autowired
//    private HikariDataSource hikariDataSource;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        log.info("user-启动成功");
    }
//
//    @Bean(name = "dataSource")
//    public DataSource getDataSource() {
//        log.warn(hikariDataSource.getJdbcUrl());
//        LocalXADataSource dataSource = new LocalXADataSource();
//        dataSource.setDataSource(hikariDataSource);
//        return dataSource;
//    }
}
