package com.herbalife.examples;

import io.smallrye.config.ConfigMapping;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
@ConfigMapping(prefix = "db")
public interface MyDatabaseSettings {
     String server();
     int port();
     String user();
     String password();
     String database();

}
