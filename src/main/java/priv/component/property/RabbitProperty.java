package priv.component.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Rabbit 属性配置类
 *
 * @author Sunny Boy
 * @date 2022/9/13 18:44
 */
@Data
@ConfigurationProperties(prefix = "sd.rabbit-mq")
public class RabbitProperty {

	/**
	 * Rabbit 的host地址
	 */
	private String host;

	/**
	 * 端口
	 */
	private Integer port;

	/**
	 * 连接的用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;
}
