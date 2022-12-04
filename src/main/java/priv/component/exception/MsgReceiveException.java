package priv.component.exception;

/**
 * 消息接收异常
 *
 * @author Sunny Boy
 * @date 2022/9/15 17:26
 */
public class MsgReceiveException extends MqMessageException{

	public MsgReceiveException(String message) {
		super(message);
	}

}
