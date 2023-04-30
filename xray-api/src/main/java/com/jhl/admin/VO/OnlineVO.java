package com.jhl.admin.VO;

import lombok.Data;

import java.io.Serializable;

@Data
public class OnlineVO implements Serializable {
    private String datetime;
    private String target;
    private String tag;
    private String email;
    private String ip;
}
