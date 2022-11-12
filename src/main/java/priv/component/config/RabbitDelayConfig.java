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
 * RabbitMQ 延时器交换机和队列配置
 *
 * @author Sunny Boy
 * @date 2022/11/8 16:00
 */
@Configuration
public class RabbitDelayConfig {

	/**
	 * 定时器交换机
	 * <pre>
	 *     为 RabbitMQ 安装延时器插件，地址：<a href="https://github.com/rabbitmq/rabbitmq-delayed-message-exchange">延时器官方地址</a>
	 *     ⚠️注意：注意版本的对应
	 * </pre>
	 *
	 * @return 交换机
	 */
	@Bean
	public CustomExchange delayExchange() {
		Map<String, Object> map = Map.of("x-delayed-type", "direct");
		/*
		 * 1.交换机
		 * 2.类型
		 * 3.是否持久化
		 * 4.是否自动删除
		 * 5其他参数
		 */
		return new CustomExchange(ExchangeConstant.DELAY_EXCHANGE, "x-delayed-message", true, false, map);
	}

	/**
	 * 延时器消息队列，并指定死信队列
	 *
	 * @return 队列
	 */
	@Bean
	public Queue delayQueue() {
		Map<String, Object> params = new ConcurrentHashMap<>(4);
		// 指定死信交换器
		params.put("x-dead-letter-exchange", ExchangeConstant.DLX_EXCHANGE);
		// 指定死信队列
		params.put("x-dead-letter-routing-key", RoutingKeyEnum.DLX_PUBLIC_KEY.getCode());
		return QueueBuilder.durable(QueueConstant.DELAY_QUEUE).withArguments(params).build();
	}

	@Bean
	public Binding bindingDelayQueue() {
		return BindingBuilder.bind(delayQueue()).to(delayExchange()).with(RoutingKeyEnum.DELAY_KEY.getCode()).noargs();
	}

}
