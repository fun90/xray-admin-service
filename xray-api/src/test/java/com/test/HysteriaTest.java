package com.test;

import com.fun90.admin.util.Utils;

public class HysteriaTest {
    public static void main(String[] args) {
        String response = Utils.call("http://127.0.0.1:12345/traffic?clear=1", "test", null);
        System.out.println(response);

        response = Utils.call("http://127.0.0.1:12345/kick", "test", "[\"testuser\"]");
        System.out.println(response);
    }
}
