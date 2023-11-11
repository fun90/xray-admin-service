package com.fun90.admin.VO;

import com.alibaba.fastjson2.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServerVO extends BaseEntityVO implements Serializable {


	private String serverName;
	private String clientDomain;
	private Integer clientPort = 443;

	//proxy中间件管理 ip port;

	private String proxyIp = "127.0.0.1";
	private Integer proxyPort = 8091;
	//v2ray 开放 的 ip 和端口
	private String v2rayIp = "127.0.0.1";
	private Integer v2rayManagerPort = 62789;
	private Integer v2rayPort = 6001;


	private String protocol;
	private String protocolField;
	/**
	 * protocolField 的json对象
	 */
	private JSONObject json;

	//流量倍数
	private Double multiple;

	//说明
	private String desc;
	//服务器状态
	private Integer status;

	private String inboundTag;

	/**
	 * 服务器等级
	 */
	private Short level;


}

