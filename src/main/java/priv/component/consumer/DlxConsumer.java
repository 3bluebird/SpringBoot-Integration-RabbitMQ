package priv.component.consumer;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import priv.component.constant.QueueConstant;
import priv.component.service.DlxQueueService;
import priv.component.service.impl.DefaultDlxQueueServiceImpl;

import java.util.Objects;

/**
 * 死信队列消费
 *
 * @author Sunny Boy
 * @date 2022/9/15 09:38
 */
@Slf4j
@Component
public class DlxConsumer {

	private final DlxQueueService dlxQueueService;

	@RabbitListener(queues = QueueConstant.DLX_PUBLIC_QUEUE)
	public void process(String msg, Channel channel, Message message) {
		dlxQueueService.aftercare(msg, channel, message);
	}

	public DlxConsumer(@Nullable DlxQueueService queueService) {
		dlxQueueService = Objects.nonNull(queueService) ? queueService : new DefaultDlxQueueServiceImpl();
	}

}
