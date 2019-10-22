package elan.verify.tcc.user.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author 张一然
 * @date 2019/10/11 13:38
 * @Description
 */
@Configuration
public class TCCConfig {

//    @Autowired
//    private Environment env;
//    @Bean
//    public HmilyTransactionBootstrap hmilyTransactionBootstrap(HmilyInitService hmilyInitService){
//        HmilyTransactionBootstrap hmilyTransactionBootstrap = new HmilyTransactionBootstrap(hmilyInitService);
//        hmilyTransactionBootstrap.setSerializer(env.getProperty("org.dromara.hmily.serializer"));
//        hmilyTransactionBootstrap.setRecoverDelayTime(Integer.parseInt(env.getProperty("org.dromara.hmily.recoverDelayTime")));
//        hmilyTransactionBootstrap.setRetryMax(Integer.parseInt(env.getProperty("org.dromara.hmily.retryMax")));
//        hmilyTransactionBootstrap.setScheduledDelay(Integer.parseInt(env.getProperty("org.dromara.hmily.scheduledDelay")));
//        hmilyTransactionBootstrap.setScheduledThreadMax(Integer.parseInt(env.getProperty("org.dromara.hmily.scheduledThreadMax")));
//        hmilyTransactionBootstrap.setRepositorySupport(env.getProperty("org.dromara.hmily.repositorySupport"));
//        hmilyTransactionBootstrap.setStarted(Boolean.parseBoolean(env.getProperty("org.dromara.hmily.started")));
//        HmilyDbConfig hmilyDbConfig = new HmilyDbConfig();
//        hmilyDbConfig.setDriverClassName(env.getProperty("org.dromara.hmily.hmilyDbConfig.driverClassName"));
//        hmilyDbConfig.setUrl(env.getProperty("org.dromara.hmily.hmilyDbConfig.url"));
//        hmilyDbConfig.setUsername(env.getProperty("org.dromara.hmily.hmilyDbConfig.username"));
//        hmilyDbConfig.setPassword(env.getProperty("org.dromara.hmily.hmilyDbConfig.password"));
//        hmilyTransactionBootstrap.setHmilyDbConfig(hmilyDbConfig);
//        return hmilyTransactionBootstrap;
//    }
}
