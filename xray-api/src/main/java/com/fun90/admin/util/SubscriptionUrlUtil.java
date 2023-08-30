package com.fun90.admin.util;

import com.fun90.admin.constant.enumObject.WebsiteConfigEnum;
import com.fun90.admin.model.ServerConfig;
import com.fun90.admin.service.ServerConfigService;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class SubscriptionUrlUtil {
    public static String getPrefix(HttpServletRequest request, ServerConfigService serverConfigService) {
        ServerConfig serverConfig = serverConfigService.getServerConfig(WebsiteConfigEnum.SUBSCRIPTION_ADDRESS_PREFIX.getKey());
        if (serverConfig != null && StringUtils.isNoneBlank(serverConfig.getValue()) && !serverConfig.getValue().equals("0")) {
            return serverConfig.getValue();
        }
        return "https://" + request.getServerName() + "/api";
    }
}
