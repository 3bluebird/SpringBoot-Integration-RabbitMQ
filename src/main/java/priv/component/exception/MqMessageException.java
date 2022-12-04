package priv.component.exception;

/**
 * MQ 消息异常
 *
 * @author Sunny Boy
 * @date 2022/9/14 11:14
 */
public class MqMessageException extends RuntimeException{
	public MqMessageException() {
		super();
	}

	public MqMessageException(String message) {
		super(message);
	}

	public MqMessageException(String message, Throwable cause) {
		super(message, cause);
	}

	public MqMessageException(Throwable cause) {
		super(cause);
	}

	protected MqMessageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
