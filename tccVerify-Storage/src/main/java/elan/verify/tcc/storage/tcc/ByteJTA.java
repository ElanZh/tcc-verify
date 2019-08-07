package elan.verify.tcc.storage.tcc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 张一然
 * @date 2019年-08月-02号 上午11:37
 * @Description TCC 要用到的表
 * @see bytetcc-supports-0.5.3.jar!/bytetcc.sql
 */
@Entity
@Table(name = "bytejta")
@lombok.Data
public class ByteJTA {
    @Id
    @Column(length = 32, name = "xid")
    private String xid;
    @Column(length = 40, name = "gxid")
    private String gxid;
    @Column(length = 40, name = "bxid")
    private String bxid;
    @Column(length = 20, name = "ctime")
    private Integer ctime;
}
