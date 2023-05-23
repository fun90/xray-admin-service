package com.jhl.admin.constant.enumObject;

import lombok.Getter;

@Getter
public enum WebsiteConfigEnum {


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
			"    \"Direct\": [\n" +
			"        \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/direct.txt\",\n" +
			"        \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/cncidr.txt\"\n" +
			"    ],\n" +
			"    \"Private\": [\n" +
			"        \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/private.txt\"\n" +
			"    ],\n" +
			"    \"Proxy\": [\n" +
			"        \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/proxy.txt\",\n" +
			"        \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/tld-not-cn.txt\",\n" +
			"        \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/gfw.txt\",\n" +
			"        \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/greatfire.txt\",\n" +
			"    ],\n" +
			"    \"Telegramcidr\": [\n" +
			"        \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/telegramcidr.txt\"\n" +
			"    ],\n" +
			"    \"Apple\": [\n" +
			"        \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/apple.txt\"\n" +
			"    ],\n" +
			"    \"iCloud\": [\n" +
			"        \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/icloud.txt\"\n" +
			"    ],\n" +
			"    \"Reject\": [\n" +
			"        \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/reject.txt\"\n" +
			"    ],\n" +
			"    \"AdvertisingLite\": [\n" +
			"        \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/AdvertisingLite/AdvertisingLite_Resolve.list\"\n" +
			"    ],\n" +
			"    \"AdvertisingLiteDomain\": [\n" +
			"        \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/AdvertisingLite/AdvertisingLite_Domain.list\"\n" +
			"    ],\n" +
			"    \"BanProgramAD\": [\n" +
			"        \"https://raw.githubusercontent.com/ACL4SSR/ACL4SSR/master/Clash/BanProgramAD.list\"\n" +
			"    ],\n" +
			"    \"Google\": [\n" +
			"        \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/Google/Google_Resolve.list\"\n" +
			"    ],\n" +
			"    \"Microsoft\": [\n" +
			"        \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/Microsoft/Microsoft.list\"\n" +
			"    ],\n" +
			"    \"PayPal\": [\n" +
			"        \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/PayPal/PayPal.list\"\n" +
			"    ],\n" +
			"    \"Amazon\": [\n" +
			"        \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/Amazon/Amazon.list\"\n" +
			"    ],\n" +
			"    \"Whatsapp\": [\n" +
			"        \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/Whatsapp/Whatsapp.list\"\n" +
			"    ],\n" +
			"    \"YouTube\": [\n" +
			"        \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/YouTube/YouTube_Resolve.list\"\n" +
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
