package priv.component.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 路由 key 常量
 *
 * @author Sunny Boy
 * @date 2022/9/14 09:03
 */
@Getter
@AllArgsConstructor
public enum RoutingKeyEnum {

	/**
	 * sd-mqtt 路由
	 */
	SD_MQTT_KEY("mqtt.routing.key"),

	/**
	 * sd-app 路由
	 */
	SD_APP_KEY("app.routing.key"),

	/**
	 * 延迟器路由
	 */
	DELAY_KEY("timer.routing.key"),

	/**
	 * 通用的死信路由
	 */
	DLX_PUBLIC_KEY("dlx.public.routing.key");

	private final String code;

}
