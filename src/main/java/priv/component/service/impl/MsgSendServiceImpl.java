package priv.component.service.impl;

import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import priv.component.model.bo.DelayMsgBO;
import priv.component.model.bo.MqMsgBO;
import priv.component.service.MsgSendService;
import priv.component.service.MsgSender;

import javax.validation.Valid;

/**
 * 消息发送服务类
 *
 * @author Mingpeng Zhuang
 * @date 2022/9/14 09:23
 */
@Service
@Validated
@RequiredArgsConstructor
public class MsgSendServiceImpl implements MsgSendService {

	private final MsgSender msgSender;

	@Override
	public void sendMsg(@Valid MqMsgBO msg) {
		msgSender.send(msg.getRoutingKey().getCode(), JSONUtil.toJsonStr(msg.getMessage()));
	}

	@Override
	public void delayMsg(@Valid DelayMsgBO msgBO) {
		msgSender.delay(JSONUtil.toJsonStr(msgBO.getMsgBody()), msgBO.getDelayTime() * 1000);
	}

}
