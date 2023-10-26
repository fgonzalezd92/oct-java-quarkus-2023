package com.herbalife.examples;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class DatabaseSettings {
    @ConfigProperty(name = "db.server")
    private String server;
    @ConfigProperty(name = "db.port")
    private int port;
    @ConfigProperty(name = "db.user")
    private String username;
    @ConfigProperty(name = "db.password")
    private String password;
    @ConfigProperty(name = "db.database")
    private String databaseName;

    @Override
    public String toString() {
        return "DatabaseSettings{" +
                "server='" + server + '\'' +
                ", port=" + port +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", databaseName='" + databaseName + '\'' +
                '}';
    }
}
