package priv.component.model.dto;

import cn.hutool.json.JSONUtil;
import lombok.Data;
import priv.component.constant.enums.MsgResultEnum;
import priv.component.constant.enums.MsgTypeEnum;

/**
 * MQ 消息
 *
 * @author Mingpeng Zhuang
 * @date 2022/9/14 11:11
 */
@Data
public class MqMessage {

	/**
	 * 消息结果
	 */
	private MsgResultEnum resultEnum;

	/**
	 * 消息类型
	 */
	private MsgTypeEnum typeEnum;

	/**
	 * 消息内容, JSON 格式
	 */
	private String content;

	/**
	 * 异常信息
	 */
	private String errMsg;

	public static MqMessage success(MsgTypeEnum typeEnum, Object content) {
		MqMessage mqMessage = new MqMessage();
		mqMessage.setResultEnum(MsgResultEnum.SUCCESS);
		mqMessage.setTypeEnum(typeEnum);
		mqMessage.setContent(JSONUtil.toJsonStr(content));
		return mqMessage;
	}

}
