package priv.component.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import priv.component.constant.ExchangeConstant;
import priv.component.constant.QueueConstant;
import priv.component.constant.enums.RoutingKeyEnum;

/**
 * RabbitMQ 死信交换器和队列配置
 *
 * @author Sunny Boy
 * @date 2022/9/15 09:36
 */
@Configuration
public class RabbitDlxConfig {

	/**
	 * 死信交换器
	 */
	@Bean
	public DirectExchange dlxDirectExchange() {
		return ExchangeBuilder.directExchange(ExchangeConstant.DLX_EXCHANGE).build();
	}

	/**
	 * 死信队列
	 */
	@Bean
	public Queue dlxPublicQueue() {
		return QueueBuilder.durable(QueueConstant.DLX_PUBLIC_QUEUE).build();
	}

	/**
	 * 绑定死信交换器和死信队列
	 */
	@Bean
	public Binding dlxPublicBiding() {
		return BindingBuilder.bind(dlxPublicQueue()).to(dlxDirectExchange()).with(RoutingKeyEnum.DLX_PUBLIC_KEY.getCode());
	}
}
