package elan.verify.tcc.user.biz;

import javax.persistence.*;

@Entity
@Table(name = "T_USER")
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "SQ_USER")
    private Integer id;

    /** 余额 */
    @Column(nullable = false)
    private Integer balance = 0;

    /** 冻结余额 */
    @Column(nullable = false)
    private Integer freezeBalance = 0;
}
