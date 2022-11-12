package priv.component.service;

import priv.component.model.bo.DelayMsgBO;
import priv.component.model.bo.MqMsgBO;

import javax.validation.Valid;

/**
 * 发送 MQ 消息服务
 *
 * @author Mingpeng Zhuang
 * @date 2022/9/14 09:20
 */
public interface MsgSendService {

	/**
	 * 发送消息
	 *
	 * @param messageBO 消息信息
	 */
	void sendMsg(@Valid MqMsgBO messageBO);

	/**
	 * 延迟消息
	 *
	 * @param msgBO 消息信息
	 */
	void delayMsg(@Valid DelayMsgBO msgBO);

}
