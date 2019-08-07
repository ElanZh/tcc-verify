package elan.verify.tcc.user.tcc;

import lombok.extern.slf4j.Slf4j;
import org.bytesoft.bytetcc.supports.springcloud.config.SpringCloudSecondaryConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author 张一然
 * @date 2019年-08月-05号 下午2:22
 * 按请求粒度负载均衡(使用MongoDB存储事务日志):需引入 SpringCloudConfiguration; <br />
 * 按事务粒度负载均衡(使用文件系统存储事务日志):需引入 SpringCloudSecondaryConfiguration;
 */
@Import(SpringCloudSecondaryConfiguration.class)
@Configuration
@Slf4j
public class TCCConfig{
    @Autowired private DataSource dataSource;

    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.transaction.coordinator_class", "jta");
        properties.setProperty("hibernate.transaction.jta.platform"
                , "org.bytesoft.bytetcc.supports.jpa.hibernate.HibernateJtaPlatform");

        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setJpaProperties(properties);
        entityManager.setDataSource(dataSource);
        return entityManager;
    }

}
