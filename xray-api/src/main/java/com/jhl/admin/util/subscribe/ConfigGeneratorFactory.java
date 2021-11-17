package com.jhl.admin.util.subscribe;

import com.jhl.admin.util.subscribe.generator.*;

public class ConfigGeneratorFactory {
    public static IConfigGenerator build(String target) {
        if ("surge".equals(target)) {
            return new SurgeConfigGenerator();
        } else if ("quanx".equals(target)) {
            return new QuanxConfigGenerator();
        } else if ("loon".equals(target)) {
            return new LoonConfigGenerator();
        } else if ("clash".equals(target)) {
            return new ClashConfigGenerator();
        } else {
            throw new RuntimeException("未知的target");
        }
    }
}
