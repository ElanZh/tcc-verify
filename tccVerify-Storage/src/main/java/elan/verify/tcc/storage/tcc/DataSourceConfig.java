package elan.verify.tcc.storage.tcc;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.bytesoft.bytejta.supports.jdbc.LocalXADataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author 张一然
 * @date 2019年-08月-05号 下午2:22
 */
@Configuration
@Slf4j
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String jdbc;

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        log.warn("准备装载数据源："+jdbc);
        LocalXADataSource dataSource = new LocalXADataSource();
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(jdbc);
        dataSource.setDataSource(hikariDataSource);
        return dataSource;
    }

    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Autowired DataSource dataSource) {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.transaction.coordinator_class", "jta");
        properties.setProperty("hibernate.transaction.jta.platform" //
                , "org.bytesoft.bytetcc.supports.jpa.hibernate.HibernateJtaPlatform");

        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setJpaProperties(properties);
        entityManager.setDataSource(dataSource);
        return entityManager;
    }
}
