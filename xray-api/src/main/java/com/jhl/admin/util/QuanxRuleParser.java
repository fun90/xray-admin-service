package com.jhl.admin.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class QuanxRuleParser implements Function<String, String> {
    private final Map<String, String> rulesTypes;
    private final String noResolve = "no-resolve";
    private final String group;

    public QuanxRuleParser(Map<String, String> rulesTypes, String group) {
        this.rulesTypes = rulesTypes;
        this.group = group;
    }

    @Override
    public String apply(String line) {
        String[] arr = line.split(",");
        if (arr.length < 2) {
            return line + System.lineSeparator();
        }
        arr[0] = rulesTypes.getOrDefault(arr[0], arr[0]);
        String[] newArr = Arrays.copyOf(arr, arr.length + 1);
        if (newArr[newArr.length - 2].equals(noResolve)) {
            newArr[newArr.length - 2] = group;
            newArr[newArr.length - 1] = noResolve;
        } else {
            newArr[newArr.length - 1] = group;
        }
        return String.join(",", newArr) + System.lineSeparator();
    }
}
