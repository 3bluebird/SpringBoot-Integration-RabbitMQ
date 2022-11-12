package priv.component.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import priv.component.constant.enums.RoutingKeyEnum;
import priv.component.model.dto.MqMessage;

import javax.validation.constraints.NotNull;

/**
 * MQ 消息 BO
 *
 * @author Mingpeng Zhuang
 * @date 2022/9/14 09:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MqMsgBO {

	/**
	 * 路由key
	 */
	@NotNull
	private RoutingKeyEnum routingKey;

	/**
	 * 需要发送的消息
	 */
	@NotNull
	private MqMessage message;

}
