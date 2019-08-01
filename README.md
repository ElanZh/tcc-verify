# TCC-verify

TCC分布式事务验证项目

> 模拟这个案例：
> <br/> 1.用户下单，减扣库存
> <br/> 2.减扣库存完成，减扣用户余额
> <br/> 3.减扣用户余额完成，创建订单

---

## 使用 ByteTCC框架

[点击此处进入源码仓](https://github.com/liuyangming/ByteTCC)

[集成使用文档](https://github.com/liuyangming/ByteTCC/wiki/User-Guide-0.5.x)

[二次开发文档](https://github.com/liuyangming/ByteTCC/wiki/Developer-Guide)

---

### 使用约束

#### *共同约束*
* 针对一个特定的可补偿型服务接口，业务系统提供的Try、Confirm、Cancel三个实现类，其Try实现类必须定义@Compensable注解，而Confirm、Cancel实现类则不能定义Compensable注解；
* 可补偿型服务的Try/Confirm/Cancel实现类/实现方法必须定义Transactional注解，且propagation必须是Required, RequiresNew, Mandatory中的一种（即业务代码必须参与事务，从0.3.0开始强制要求）；
* 业务系统尽量不要使用随机端口；
* 在每个参与tcc事务的数据库中创建bytejta表（ddl见bytetcc-supports.jar/bytetcc.sql）；
* JDK版本：8.0及以上版本；

#### *使用Spring Cloud的约束*

* 服务提供方Controler必须添加@Compensable注解；
* 不允许对Feign/Ribbon/RestTemplate等HTTP请求自行进行封装，但允许拦截；
* 如果需要定制instanceId, 格式必须为${ip}:${自行指定}:${port}；
* 0.5.x版本仅支持Spring Boot 2.x、Spring Cloud 2.x* 