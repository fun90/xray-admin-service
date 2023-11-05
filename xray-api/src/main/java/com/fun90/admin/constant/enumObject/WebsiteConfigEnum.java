package com.fun90.admin.constant.enumObject;

import lombok.Getter;

@Getter
public enum WebsiteConfigEnum {


	TASK_ENABLE("开启自动统计流量&账号过期任务", "TASK_ENABLE", "true", "config"),
	IS_NEED_INVITE_CODE("需要邀请码才能注册吗？", "IS_NEED_INVITE_CODE", "false", "config"),
	VIP_CAN_INVITE("用户能邀请其他人注册吗？", "VIP_CAN_INVITE", "false", "config"),
	SUBSCRIPTION_ADDRESS_PREFIX("订阅地址访问前缀", "SUBSCRIPTION_ADDRESS_PREFIX", "http://127.0.0.1:9091/api", "config"),
	SUB_CONVERTER_ADDRESS("订阅转换地址", "SUB_CONVERTER_ADDRESS", "0", "config"),
	ACCOUNT_LEVEL_JSON("账号等级", "ACCOUNT_LEVEL_JSON", "[\n" +
			"  {\"value\": 0, \"label\": \"等级0\"},\n" +
			"  {\"value\": 1, \"label\": \"等级1\"},\n" +
			"  {\"value\": 2, \"label\": \"等级2\"},\n" +
			"  {\"value\": 3, \"label\": \"等级3\"},\n" +
			"  {\"value\": 4, \"label\": \"等级4\"},\n" +
			"  {\"value\": 5, \"label\": \"等级5\"}\n" +
			"]", "config"),
	RULE_SET_JSON("分流规则", "RULE_SET_JSON", "{\n" +
			"    \"direct\": [\n" +
			"        \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/direct.txt\",\n" +
			"        \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/cncidr.txt\"\n" +
			"    ],\n" +
			"    \"private\": [\n" +
			"        \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/private.txt\"\n" +
			"    ],\n" +
			"    \"proxy\": [\n" +
			"        \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/proxy.txt\",\n" +
			"        \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/tld-not-cn.txt\",\n" +
			"        \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/gfw.txt\",\n" +
			"        \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/greatfire.txt\",\n" +
			"    ],\n" +
			"    \"telegramcidr\": [\n" +
			"        \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/telegramcidr.txt\"\n" +
			"    ],\n" +
			"    \"apple\": [\n" +
			"        \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/apple.txt\"\n" +
			"    ],\n" +
			"    \"icloud\": [\n" +
			"        \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/icloud.txt\"\n" +
			"    ],\n" +
			"    \"reject\": [\n" +
			"        \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/reject.txt\"\n" +
			"    ],\n" +
			"    \"advertisinglite\": [\n" +
			"        \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/advertisinglite/AdvertisingLite_Resolve.list\"\n" +
			"    ],\n" +
			"    \"advertisinglitedomain\": [\n" +
			"        \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/advertisinglite/AdvertisingLite_Domain.list\"\n" +
			"    ],\n" +
			"    \"banprogramad\": [\n" +
			"        \"https://raw.githubusercontent.com/ACL4SSR/ACL4SSR/master/Clash/banprogramad.list\"\n" +
			"    ],\n" +
			"    \"google\": [\n" +
			"        \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/google/Google_Resolve.list\"\n" +
			"    ],\n" +
			"    \"microsoft\": [\n" +
			"        \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/microsoft/microsoft.list\"\n" +
			"    ],\n" +
			"    \"paypal\": [\n" +
			"        \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/paypal/paypal.list\"\n" +
			"    ],\n" +
			"    \"amazon\": [\n" +
			"        \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/amazon/Amazon_Resolve.list\"\n" +
			"    ],\n" +
			"    \"whatsapp\": [\n" +
			"        \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/whatsapp/Whatsapp_Resolve.list\"\n" +
			"    ],\n" +
			"    \"tiktok\": [\n" +
			"        \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/tiktok/tiktok.list\"\n" +
			"    ],\n" +
			"    \"youtube\": [\n" +
			"        \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/youtube/YouTube_Resolve.list\"\n" +
			"    ]\n" +
			"}", "config");

	private String name;

	private String key;

	private String value;

	private String scope;

	WebsiteConfigEnum(String name, String key, String value, String scope) {
		this.name = name;
		this.key = key;
		this.value = value;
		this.scope = scope;
	}


}
