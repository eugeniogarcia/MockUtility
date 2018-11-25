package com.ng.systemtest;


import com.google.common.base.Charsets;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.util.Properties;

public class Templates {

    static {
        Properties properties = new Properties();
        properties.put(RuntimeConstants.RESOURCE_LOADER, "classpath");
        properties.put("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        Velocity.init(properties);
    }

    public static String process(final String templateResource, VelocityContext velocityContext) {
        StringWriter sw = new StringWriter();
        Velocity.getTemplate(templateResource).merge(velocityContext, sw);
        return sw.toString();
    }

    public static String fromResource(final String resource) {
        URL url = com.google.common.io.Resources.getResource(resource);
        try {
            return com.google.common.io.Resources.toString(url, Charsets.UTF_8);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
