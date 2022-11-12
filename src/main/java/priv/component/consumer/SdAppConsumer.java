package priv.component.consumer;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import priv.component.constant.QueueConstant;
import priv.component.exception.MqMessageException;
import priv.component.model.dto.MqMessage;

/**
 * Sd APP 接收器
 *
 * @author Sunny Boy
 * @date 2022/11/12 10:25
 */
@Slf4j
@Component
public class SdAppConsumer {

	@RabbitListener(queues = QueueConstant.SD_APP_QUEUE)
	public void receiver(String message) {
		log.info("接收的消息: {}", message);
		boolean typeJSON = JSONUtil.isTypeJSON(message);
		if (!typeJSON) {
			throw new MqMessageException("RabbitMQ 消息异常");
		}

		MqMessage body = JSONUtil.toBean(message, MqMessage.class);
		Assert.notNull(body, "sd app consumer 接收的消息异常");
	}

}
