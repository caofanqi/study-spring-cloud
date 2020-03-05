package cn.caofanqi.cloud;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>Description:  </p>
 *
 * @author 曹凡启
 * @since 2020/3/2 0:54
 */
public interface UserRepository  extends JpaRepository<User, Long> {
}
