package com.example.RouteService;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;
 
  
public class LogComponent {
 
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.enableHangupSupport();
        main.addRouteBuilder(new RouteLogger());
        main.run(args);
    }
}
 
class RouteLogger extends RouteBuilder {
 
    @Override
    public void configure() throws Exception {
 
       from("timer://simpleTimer?period=1000")
                            .setBody(simple("Hello from timer at ${header.firedTime}"))
                                     .to("log:myLog");
 
    }
}