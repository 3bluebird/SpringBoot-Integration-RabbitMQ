package priv.component.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import priv.component.constant.CommandConstant;

/**
 * 设备绑定 DTO
 *
 * @author Mingpeng Zhuang
 * @date 2022/9/14 09:34
 */
@Data
@Accessors(chain = true)
public class DeviceBindDTO {

	/**
	 * 设备真实的id
	 */
	private String deviceId;

	/**
	 * 客户id
	 */
	private String accountId;

	/**
	 * 操作命令
	 */
	private CommandConstant.Bind  command;

}
