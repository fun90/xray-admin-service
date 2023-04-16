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
			"    \"Direct\": \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/direct.txt\",\n" +
			"    \"CnCidr\": \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/cncidr.txt\",\n" +
			"    \"Private\": \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/private.txt\",\n" +
			"    \"Tld-not-cn\": \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/tld-not-cn.txt\",\n" +
			"    \"Gfw\": \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/gfw.txt\",\n" +
			"    \"Greatfire\": \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/greatfire.txt\",\n" +
			"    \"Proxy\": \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/proxy.txt\",\n" +
			"    \"Apple\": \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/apple.txt\",\n" +
			"    \"iCloud\": \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/icloud.txt\",\n" +
			"    \"TelegramCidr\": \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/telegramcidr.txt\",\n" +
			"    \"Reject\": \"https://raw.githubusercontent.com/Loyalsoldier/surge-rules/release/ruleset/reject.txt\",\n" +
			"    \"AdvertisingLite\": \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/AdvertisingLite/AdvertisingLite_Resolve.list\",\n" +
			"    \"AdvertisingLiteDomain\": \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/AdvertisingLite/AdvertisingLite_Domain.list\",\n" +
			"    \"BanProgramAD\": \"https://raw.githubusercontent.com/ACL4SSR/ACL4SSR/master/Clash/BanProgramAD.list\",\n" +
			"    \"Google\": \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/Google/Google_Resolve.list\",\n" +
			"    \"Microsoft\": \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/Microsoft/Microsoft.list\",\n" +
			"    \"PayPal\": \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/PayPal/PayPal.list\",\n" +
			"    \"Amazon\": \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/Amazon/Amazon.list\",\n" +
			"    \"YouTube\": \"https://raw.githubusercontent.com/blackmatrix7/ios_rule_script/master/rule/Surge/YouTube/YouTube_Resolve.list\"\n" +
			"  }", "config");

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
