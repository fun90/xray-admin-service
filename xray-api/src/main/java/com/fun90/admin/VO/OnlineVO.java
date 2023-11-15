package com.fun90.admin.VO;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class OnlineVO implements Serializable {
    private String datetime;
    private String target;
    private String tag;
    private String email;
    private String ip;
    private String machineName;
}
