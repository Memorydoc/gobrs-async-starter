package com.gobrs.async.engine;

import com.alibaba.fastjson.JSONArray;
import com.gobrs.async.rule.Rule;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author sizegang1
 * @program: gobrs-async
 * @ClassName AbstractEngine
 * @description:
 * @author: sizegang
 * @Version 1.0
 * @date 2022-01-27 22:04
 **/
public abstract class AbstractEngine implements RuleEngine {

    @Resource
    private RuleEngine ruleEngine;

    @Override
    public void parse(String rule) {
        List<Rule> rules = JSONArray.parseArray(rule, Rule.class);
        for (Rule r : rules) {
            ruleEngine.doParse(r, Collections.emptyMap());
        }
    }

}
