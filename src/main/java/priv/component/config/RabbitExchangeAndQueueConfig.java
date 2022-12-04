package priv.component.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import priv.component.constant.ExchangeConstant;
import priv.component.constant.QueueConstant;
import priv.component.constant.enums.RoutingKeyEnum;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * RabbitMQ 交换机和队列配置
 *
 * @author Sunny Boy
 * @date 2022/9/13 19:04
 */
@Configuration
public class RabbitExchangeAndQueueConfig {

	@Bean
	public DirectExchange publicExchange() {
		return ExchangeBuilder.directExchange(ExchangeConstant.PUBLIC_EXCHANGE).build();
	}

	/**
	 * sd-app 消息发送队列，并指定死信队列
	 *
	 * @return 队列
	 */
	@Bean
	public Queue sdAppQueue() {
		Map<String, Object> params = new ConcurrentHashMap<>(4);
		// 指定死信交换器
		params.put("x-dead-letter-exchange", ExchangeConstant.DLX_EXCHANGE);
		// 指定死信队列
		params.put("x-dead-letter-routing-key", RoutingKeyEnum.DLX_PUBLIC_KEY.getCode());
		return QueueBuilder.durable(QueueConstant.SD_APP_QUEUE).withArguments(params).build();
	}

	/**
	 * sd-mqtt 消息发送队列，并指定死信队列
	 *
	 * @return 队列
	 */
	@Bean
	public Queue sdMqttQueue() {
		Map<String, Object> params = new ConcurrentHashMap<>(4);
		// 指定死信交换器
		params.put("x-dead-letter-exchange", ExchangeConstant.DLX_EXCHANGE);
		// 指定死信队列
		params.put("x-dead-letter-routing-key", RoutingKeyEnum.DLX_PUBLIC_KEY.getCode());
		return QueueBuilder.durable(QueueConstant.SD_MQTT_QUEUE).withArguments(params).build();
	}

	@Bean
	public Binding bindingAppQueue() {
		return BindingBuilder.bind(sdAppQueue()).to(publicExchange()).with(RoutingKeyEnum.SD_APP_KEY.getCode());
	}

	@Bean
	public Binding bindingMqttQueue() {
		return BindingBuilder.bind(sdMqttQueue()).to(publicExchange()).with(RoutingKeyEnum.SD_MQTT_KEY.getCode());
	}

}
