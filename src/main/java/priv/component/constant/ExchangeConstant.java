package priv.component.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Exchange 常量
 *
 * @author Sunny Boy
 * @date 2022/9/14 08:48
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExchangeConstant {

	/**
	 * 应用 Exchange 名称
	 */
	public static final String PUBLIC_EXCHANGE = "exchange.direct.public";

	/**
	 * 延时器 Exchange 名称
	 */
	public static final String DELAY_EXCHANGE = "exchange.direct.delay";

	/**
	 * 死信 Exchange
	 */
	public static final String DLX_EXCHANGE = "exchange.direct.dlx.application";


}
