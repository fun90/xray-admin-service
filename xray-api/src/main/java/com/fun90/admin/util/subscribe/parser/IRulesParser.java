package com.fun90.admin.util.subscribe.parser;

import com.fun90.admin.util.Utils;
import com.fun90.admin.util.subscribe.TemplateUtil;

public interface IRulesParser {
    String getTarget();

    default String content(String fileName, String group) {
        return Utils.writeString(TemplateUtil.getTemplatePath(), "rules", fileName);
    }
}
