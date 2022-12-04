package priv.component.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * MQ 命令常量类
 *
 * @author Sunny Boy
 * @date 2022/9/14 09:37
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommandConstant {

	/**
	 * 有关绑定的命令
	 */
	public enum Bind {

		/**
		 * 绑定
		 */
		BINDING,

		/**
		 * 取消绑定
		 */
		CANCEL_BIND,

		/**
		 * 解除绑定
		 */
		UNBIND
	}

	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	public static class BindResult{

		/**
		 * 绑定失败
		 */
		public static final String FAILED = "0";

		/**
		 * 绑定成功
		 */
		public static final String SUCCESS = "1";
	}

}
