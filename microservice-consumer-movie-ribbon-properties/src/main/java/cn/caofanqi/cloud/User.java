package cn.caofanqi.cloud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * <p>Description: 用户实体 </p>
 *
 * @author 曹凡启
 * @since 2020/3/2 0:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    private String username;

    private String name;

    private Integer age;

    private BigDecimal balance;

}
