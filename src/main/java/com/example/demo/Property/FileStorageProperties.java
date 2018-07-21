package com.example.demo.Property;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Cloie Andrea on 21/07/2018.
 */

@ConfigurationProperties()
public class FileStorageProperties {
    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
