package priv.component.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import priv.component.constant.ExchangeConstant;
import priv.component.constant.enums.RoutingKeyEnum;
import priv.component.service.MsgSender;

import java.nio.charset.StandardCharsets;

/**
 * Direct 发送消息，默认消息发送器
 *
 * @author Mingpeng Zhuang
 * @date 2022/9/14 09:13
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DirectMsgSenderImpl implements MsgSender {

	private final RabbitTemplate rabbitTemplate;

	@Override
	public void send(@NonNull String routingKey, @NonNull String message) {
		rabbitTemplate.send(ExchangeConstant.PUBLIC_EXCHANGE, routingKey, new Message(message.getBytes(StandardCharsets.UTF_8)));
		log.debug("Topic消息发送成功，routingKey: {}, message: {}", routingKey, message);
	}


	@Override
	public void delay(@NonNull String message, @NonNull int delayTime) {
		MessageProperties properties = new MessageProperties();
		properties.setDelay(delayTime);
		rabbitTemplate.send(ExchangeConstant.DELAY_EXCHANGE, RoutingKeyEnum.DELAY_KEY.getCode(), new Message(message.getBytes(StandardCharsets.UTF_8), properties));
		log.debug("RabbitMQ 延时任务设定成功，message: {}, delayTime: {}毫秒", message, delayTime);
	}

}
