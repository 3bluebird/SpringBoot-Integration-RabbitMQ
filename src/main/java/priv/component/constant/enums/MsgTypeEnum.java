package priv.component.constant.enums;

/**
 * 消息类型
 *
 * @author Mingpeng Zhuang
 * @date 2022/9/14 11:12
 */
public enum MsgTypeEnum {

	/**
	 * 设备信息更新
	 */
	DEVICE_UPDATE,
	/**
	 * 单元信息更新
	 */
	UNIT_UPDATE,
	/**
	 * 端口信息更新
	 */
	PORT_UPDATE,
	/**
	 * 端口的选项信息
	 */
	PORT_OPTIONS,
	/**
	 * 心跳包
	 */
	KEEP_ALIVE,
	/**
	 * 端口值
	 */
	PORT_VALUE,
	/**
	 * 单元状态
	 */
	UNIT_STATUS,
	/**
	 * 设备终止结果
	 */
	STOP_RESULT,
	/**
	 * 服务端查询端口值
	 */
	QUERY_PORT_VALUE,
	/**
	 * 服务端向设备端发布指令，设置某端口值
	 */
	SET_PORT_VALUE

}
