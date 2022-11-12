package priv.component.service;

import org.springframework.lang.NonNull;

/**
 * 消息发送
 *
 * @author Mingpeng Zhuang
 * @date 2022/9/14 09:09
 */
public interface MsgSender {

	/**
	 * 向指定的路由发送消息
	 *
	 * @param routingKey 路由key
	 * @param message    消息内容
	 */
	void send(@NonNull String routingKey, @NonNull String message);

	/**
	 * RabbitMQ 实现延时器任务。到时之后会自动转到 {@link priv.component.constant.QueueConstant#DLX_DELAY_QUEUE} 队列
	 *
	 * @param message   消息内容
	 * @param delayTime 消息延时时间，单位：毫秒
	 */
	void delay(@NonNull String message, @NonNull int delayTime);

}
