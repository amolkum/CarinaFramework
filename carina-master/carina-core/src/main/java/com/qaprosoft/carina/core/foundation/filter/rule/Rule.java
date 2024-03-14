package com.qaprosoft.carina.core.foundation.filter.rule;


import com.qaprosoft.carina.core.foundation.filter.IFilter;

import java.util.List;

/**
 * Java bean for the rule that can be used for suite limit 
 *
 */
public class Rule {

    private String ruleName;
    
    private IFilter testFilter;

    private List<String> ruleExpression;

    public Rule(String ruleName, IFilter filter, List<String> ruleExpression) {
        this.ruleName = ruleName;
        this.testFilter = filter;
        this.ruleExpression = ruleExpression;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public IFilter getTestFilter() {
        return testFilter;
    }

    public void setTestFilter(IFilter testFilter) {
        this.testFilter = testFilter;
    }

    public List<String> getRuleExpression() {
        return ruleExpression;
    }

    public void setRuleExpression(List<String> ruleExpression) {
        this.ruleExpression = ruleExpression;
    }

    @Override
    public String toString() {
        return "Rule [ruleName=" + ruleName + ", testFilter=" + testFilter + ", ruleExpression=" + ruleExpression + "]";
    }

}
