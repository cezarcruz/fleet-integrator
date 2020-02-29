package com.fleetlize.fleetintegrator.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NewCarRouter extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    from("jms:queue:car-creation")
        .setProperty("plate").jsonpath("$.plate")
        .log("${header.plate}")
        .serviceCall()
        .end();
  }
}
