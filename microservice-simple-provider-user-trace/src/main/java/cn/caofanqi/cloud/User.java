package cn.caofanqi.cloud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * <p>Description: 用户实体 </p>
 *
 * @author 曹凡启
 * @since 2020/3/2 0:51
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String username;
    @Column
    private String name;
    @Column
    private Integer age;
    @Column
    private BigDecimal balance;

}
