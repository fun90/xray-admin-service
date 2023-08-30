package com.fun90.admin.util.subscribe;

import com.fun90.admin.util.subscribe.generator.IConfigGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ConfigGeneratorFactory {
    private final Map<String, IConfigGenerator> generatorMap = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(ConfigGeneratorFactory.class);

    @Autowired
    public ConfigGeneratorFactory(List<IConfigGenerator> generators) {
        generators.forEach(o -> {
            if (generatorMap.containsKey(o.getTarget())) {
                throw new RuntimeException("重复的target：" + o.getTarget());
            }
            generatorMap.put(o.getTarget(), o);
            logger.info("加载配置生成器：{}", o.getClass().getName());
        });
    }

    public IConfigGenerator get(String target) {
        IConfigGenerator generator = generatorMap.get(target);
        if (generator != null) {
           return generator;
        } else {
            throw new RuntimeException("不支持的target");
        }
    }

    public boolean contains(String target) {
        return generatorMap.containsKey(target);
    }
}
