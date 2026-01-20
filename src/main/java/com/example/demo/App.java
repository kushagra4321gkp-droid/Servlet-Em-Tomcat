package com.example.demo;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws LifecycleException {
        System.out.println( "Hello World!" );

        Tomcat tomcat = new Tomcat();

        // 1️⃣ Set port
        tomcat.setPort(8080);

        // 2️⃣ Create context
        Context context = tomcat.addContext("", null);

        // 3️⃣ Register servlet
        Tomcat.addServlet(context, "helloServ", new HelloServlet());
        context.addServletMappingDecoded("/hello", "helloServ");

        // 4️⃣ FORCE connector creation (VERY IMPORTANT)
        tomcat.getConnector();

        // 5️⃣ Start Tomcat
        tomcat.start();

        // 6️⃣ KEEP JVM ALIVE
        tomcat.getServer().await();



        //
//        Context context = tomcat.addContext("", null);
//        Tomcat.addServlet(context ,"helloServ", new HelloServlet());
//        context.addServletMappingDecoded("/hello", "helloServ");
//        tomcat.start();
//        tomcat.getServer().await();



    }
}
