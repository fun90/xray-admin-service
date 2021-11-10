package com.jhl.admin.util;

import com.jhl.admin.constant.ClientConstant;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class QuanxRuleParser implements Function<String, String> {
    private final ClientConstant clientConstant;
    private final String group;

    public QuanxRuleParser(ClientConstant clientConstant, String group) {
        this.clientConstant = clientConstant;
        this.group = group;
    }

    @Override
    public String apply(String line) {
        String[] arr = line.split(",");
        if (arr.length < 2) {
            return line + System.lineSeparator();
        }
        List<String> excludeTypes = clientConstant.getExcludeRuleTypes().get("quanx");
        if (excludeTypes.contains(arr[0])) {
            return "#" + line + System.lineSeparator();
        }
        arr[0] = clientConstant.getQuanxRuleTypes().getOrDefault(arr[0], arr[0]);
        String[] newArr = Arrays.copyOf(arr, arr.length + 1);
        String noResolve = "no-resolve";
        if (newArr[newArr.length - 2].equals(noResolve)) {
            newArr[newArr.length - 2] = group;
            newArr[newArr.length - 1] = noResolve;
        } else {
            newArr[newArr.length - 1] = group;
        }
        return String.join(",", newArr) + System.lineSeparator();
    }
}
