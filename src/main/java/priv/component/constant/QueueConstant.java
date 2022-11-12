package priv.component.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Queue 常量
 *
 * @author Mingpeng Zhuang
 * @date 2022/9/14 08:48
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QueueConstant {

	/**
	 * sd-app 的命令队列
	 * <pre>
	 *     sd-mqtt 发送
	 *     sd-app 接收
	 * </pre>
	 */
	public static final String SD_APP_QUEUE = "queue.direct.sd.app";

	/**
	 * sd-mqtt 发送命令队列
	 * <pre>
	 *     sd-app 发送
	 *     sd-mqtt 接收
	 * </pre>
	 */
	public static final String SD_MQTT_QUEUE = "queue.direct.sd.mqtt";

	/**
	 * 延时器队列
	 */
	public static final String DELAY_QUEUE = "queue.direct.delay";

	/**
	 * 通用的死信队列
	 */
	public static final String DLX_PUBLIC_QUEUE = "queue.direct.dlx.public";

	/**
	 * 延时器指定的死信队列
	 */
	public static final String DLX_DELAY_QUEUE = "queue.direct.dlx.delay";

}
