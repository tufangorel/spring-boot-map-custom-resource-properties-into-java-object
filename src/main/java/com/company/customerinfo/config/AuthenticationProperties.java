package com.company.customerinfo.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;


@Configuration
@PropertySource("classpath:/authentication/authentication-${spring.profiles.active}.properties")
@ConfigurationProperties(prefix = "authentication")
public class AuthenticationProperties {

    private String username;
    private String password;
    List<Boolean> enabledports;
    Map<String,Boolean> additionalRights;
    private Directory directory;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Boolean> getEnabledports() {
        return enabledports;
    }

    public void setEnabledports(List<Boolean> enabledports) {
        this.enabledports = enabledports;
    }

    public Map<String, Boolean> getAdditionalRights() {
        return additionalRights;
    }

    public void setAdditionalRights(Map<String, Boolean> additionalRights) {
        this.additionalRights = additionalRights;
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }
}