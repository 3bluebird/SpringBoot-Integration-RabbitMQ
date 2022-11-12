package priv.component.model.bo;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 延迟执行器消息
 *
 * @author Sunny Boy
 * @date 2022/11/9 08:42
 */
@Data
public class DelayMsgBO {

	/**
	 * 延时时间，单位：秒
	 */
	@NotNull
	@Min(value = 1, message = "消息的延迟最小时间为1秒")
	@Max(value = Integer.MAX_VALUE / 1000, message = "消息的延迟最大时间为" + Integer.MAX_VALUE / 1000 + "秒")
	private Integer delayTime;

	/**
	 * 消息内容
	 */
	@NotNull
	private DelayMsgBody msgBody;

}
