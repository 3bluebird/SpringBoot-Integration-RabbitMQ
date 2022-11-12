package priv.component.utils;

import cn.hutool.json.JSONUtil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import priv.component.exception.MqMessageException;

/**
 * MQ 消息工具类
 *
 * @author Mingpeng Zhuang
 * @date 2022/9/15 10:31
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MqMsgUtil {


	/**
	 * 判定消息是否是 JSON 格式，如果不是则抛出异常
	 *
	 * @param message 消息内容
	 * @throws MqMessageException 当不是 JSON 格式时
	 */
	public static void shouldJsonFormat(String message) {
		if (JSONUtil.isTypeJSON(message)) {
			return;
		}

		throw new MqMessageException("接收到 MQTT 发送的消息内容格式不是 JSON 格式");
	}

}
