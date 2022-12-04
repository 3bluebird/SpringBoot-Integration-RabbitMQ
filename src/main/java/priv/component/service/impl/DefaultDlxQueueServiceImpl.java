package priv.component.service.impl;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import priv.component.service.DlxQueueService;

/**
 * 死信队列服务类
 *
 * @author Sunny Boy
 * @date 2022/9/15 10:55
 */
@Slf4j
public class DefaultDlxQueueServiceImpl implements DlxQueueService {

	@Override
	public void aftercare(String msg, Channel channel, Message message) {
		log.error("MQ 死信队列，Message: {}, Channel: {}, 消息内容: {}", message, channel, msg);
	}

}
