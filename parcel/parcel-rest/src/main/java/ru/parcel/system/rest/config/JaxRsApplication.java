package ru.parcel.system.rest.config;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationScoped
@ApplicationPath("/api/v1")
public class JaxRsApplication extends Application {

}
