package priv.component.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import priv.component.constant.enums.DelayTypeEnum;
import priv.component.constant.enums.MsgTypeEnum;
import priv.component.constant.enums.RoutingKeyEnum;
import priv.component.consumer.SdAppConsumer;
import priv.component.model.bo.DelayMsgBO;
import priv.component.model.bo.DelayMsgBody;
import priv.component.model.bo.MqMsgBO;
import priv.component.model.dto.MqMessage;
import priv.component.service.MsgSendService;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@Slf4j
@SpringBootTest
class MsgSendServiceImplTest {

	@Autowired
	MsgSendService msgSendService;
	@Autowired
	SdAppConsumer sdAppConsumer;

	@Test
	void sendMsg() {
		MqMsgBO bo = new MqMsgBO();
		bo.setRoutingKey(RoutingKeyEnum.SD_APP_KEY);

		String body = "test";
		MqMessage message = MqMessage.success(MsgTypeEnum.PORT_VALUE, body);
		bo.setMessage(message);

		assertDoesNotThrow(() -> msgSendService.sendMsg(bo));
	}

	@Test
	void delayMsg() {
		DelayMsgBO bo = new DelayMsgBO();
		bo.setDelayTime(5);
		bo.setMsgBody(new DelayMsgBody(DelayTypeEnum.TASK_DELAY_RUNNING, "test"));
		assertDoesNotThrow(() -> msgSendService.delayMsg(bo));
	}
}