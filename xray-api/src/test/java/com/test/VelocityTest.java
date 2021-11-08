package com.test;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;

public class VelocityTest {

    public static void main(String[] args) {
        //得到VelocityEngine
        VelocityEngine ve = new VelocityEngine();
        //得到模板文件
        ve.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, "/home/fun90/code/xray-admin-service/xray-api/src/main/resources/subscription");
        ve.init();
        Template template = ve.getTemplate("common.vm", "UTF-8");
        VelocityContext data = new VelocityContext();

        data.put("mapperName", "com.xxx.mapperName");

        try {
            //调用merge方法传入context
            StringWriter stringWriter = new StringWriter();
            template.merge(data, stringWriter);
//            stringWriter.flush();
            System.out.println(stringWriter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}