package com.jhl.admin.util.subscribe.generator;

import org.springframework.stereotype.Component;

@Component
public class Clash2ConfigGenerator extends ClashConfigGenerator {
    @Override
    public String getTarget() {
        return "clash2";
    }
}
