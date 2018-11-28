package com.ssm.util;

import java.util.UUID;

public class UuidUtil {

	/**
	 * 获取UUID
	 * @return
	 */
	public static String getUuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
