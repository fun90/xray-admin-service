package com.fun90.admin.service.v2ray;

import org.apache.commons.codec.digest.DigestUtils;

public class V2RayPathEncoder {
	private V2RayPathEncoder() {

	}

	public static String encoder(String account, String host, String password) {

		return DigestUtils.md5Hex(account + host + password);
	}
}
