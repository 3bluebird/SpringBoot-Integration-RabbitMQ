package priv.component.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import priv.component.constant.enums.DelayTypeEnum;

/**
 * 延迟消息内容
 *
 * @author Sunny Boy
 * @date 2022/11/10 09:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DelayMsgBody {

	/**
	 * 延迟的消息类型
	 */
	private DelayTypeEnum delayType;

	/**
	 * 消息类型
	 */
	private Object body;

}
