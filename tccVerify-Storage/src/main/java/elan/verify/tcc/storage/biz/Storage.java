package elan.verify.tcc.storage.biz;

import javax.persistence.*;

/**
 * @author 张一然
 * @date 2019年-07月-01号 下午7:30
 */
@Entity
@Table(name = "T_STORAGE")
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class Storage {
    @Id
    @GeneratedValue(generator = "SQ_STORAGE")
    private Integer id;

    private Integer stock;

    @Enumerated(EnumType.STRING)
    private StorageStatus status;

    private Integer subtractQuantity;

    public enum StorageStatus {
        /**
         * 可用
         */
        ENABLE,
        /**
         * 正在减扣
         */
        SUBTRACTING,
        /**
         * 正在增加
         */
        ADDING
    }
}
