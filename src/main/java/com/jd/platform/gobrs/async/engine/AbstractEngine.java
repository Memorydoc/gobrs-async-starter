package com.jd.platform.gobrs.async.engine;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jd.platform.gobrs.async.rule.Rule;
import com.jd.platform.gobrs.async.wrapper.TaskWrapper;

import java.util.*;

/**
 * @program: gobrs-async
 * @ClassName AbstractEngine
 * @description:
 * @author: sizegang
 * @Version 1.0
 **/
public abstract class AbstractEngine implements Engine {
    public Map<String, Rule> ruleMap = new HashMap<>();

    @Override
    public Map<String, List<TaskWrapper>> parse(String rule) {
        return Optional.ofNullable(rule).map((ru) -> {
            Map<String, List<TaskWrapper>> listMap = new HashMap<>();
            List<Rule> rules = JSONArray.parseArray(ru, Rule.class);
            for (Rule r : rules) {
                ruleMap.put(r.getName(), r);
                parsing(r, Collections.emptyMap());
            }
            return listMap;
        }).orElse(Collections.emptyMap());
    }

}
