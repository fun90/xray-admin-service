package com.fun90.admin.util.subscribe;

import com.fun90.admin.util.subscribe.parser.IRulesParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RulesParserFactory {
    private final Map<String, IRulesParser> parserMap = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(RulesParserFactory.class);

    @Autowired
    public RulesParserFactory(List<IRulesParser> parsers) {
        parsers.forEach(o -> {
            logger.info("加载规则解析器：{}", o.getClass().getName());
            if (parserMap.containsKey(o.getTarget())) {
                throw new RuntimeException("规则解析器有重复的target：" + o.getTarget());
            }
            parserMap.put(o.getTarget(), o);
        });
    }

    public IRulesParser get(String target) {
       return parserMap.get(target);
    }

    public boolean contains(String target) {
        return parserMap.containsKey(target);
    }
}
