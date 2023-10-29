package com.fun90.admin.VO;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SubscribeVO {
    /**
     * 客户端类型: "clash", "clash2", "quanx", "surge", "loon", "shadowrocket"
     */
    private String target;
    private Integer type;
    private Long timestamp;
    /**
     * md5(code+timestamp+api.auth)
     */
    private String token;
    private boolean whitelist = true;
    private String dns;
    private boolean test;

}
