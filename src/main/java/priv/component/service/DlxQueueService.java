package priv.component.service;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;

/**
 * 死信队列处理类
 *
 * @author Mingpeng Zhuang
 * @date 2022/9/15 10:53
 */
public interface DlxQueueService {

	/**
	 * 对死信队列抛出的异常信息进行善后处理
	 *
	 * @param msg     消息
	 * @param channel 信道信息
	 * @param message 消息详情
	 */
	void aftercare(String msg, Channel channel, Message message);

}
