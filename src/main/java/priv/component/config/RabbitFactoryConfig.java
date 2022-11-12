package priv.component.config;

import com.rabbitmq.client.ShutdownSignalException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionListener;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import priv.component.property.RabbitProperty;

import java.util.Collections;

/**
 * RabbitMQ 配置
 *
 * @author Mingpeng Zhuang
 * @date 2022/9/13 18:42
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(RabbitProperty.class)
public class RabbitFactoryConfig {

	private final RabbitProperty property;

	@Bean
	public ConnectionFactory connectionFactory() {
		// 创建连接工厂,获取MQ的连接
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(property.getHost(), property.getPort());
		connectionFactory.setUsername(property.getUsername());
		connectionFactory.setPassword(property.getPassword());
		connectionFactory.setVirtualHost("/");

		connectionFactory.setConnectionListeners(Collections.singletonList(getConnectionListener()));
		return connectionFactory;
	}

	private ConnectionListener getConnectionListener() {
		return new ConnectionListener() {
			@Override
			public void onCreate(@NonNull Connection connection) {
				log.info("RabbitMQ 创建连接");
			}

			@Override
			public void onClose(@NonNull Connection connection) {
				log.info("RabbitMQ 关闭连接");
			}

			@Override
			public void onShutDown(@NonNull ShutdownSignalException signal) {
				log.error("RabbitMQ ShutDown! 详情: ", signal);
			}

			@Override
			public void onFailed(@NonNull Exception exception) {
				log.error("RabbitMQ Failed! 详情: ", exception);
			}
		};
	}

}
