package com.jhl.admin.util.subscribe.parser;

import com.jhl.admin.util.Utils;
import com.jhl.admin.util.subscribe.TemplateUtil;

public interface IRulesParser {
    String getTarget();

    default String content(String fileName, String group) {
        return Utils.writeString(TemplateUtil.getTemplatePath(), "rules", fileName);
    }
}
