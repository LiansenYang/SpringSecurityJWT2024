package com.example.springsecurity20240711demo_jwt.configuration;
import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DirectoryInitializer {

    private final String uploadDir = "C:\\uploads\\";

    @PostConstruct
    public void init() {
        File uploadDirectory = new File(uploadDir);
        if (!uploadDirectory.exists()) {
            uploadDirectory.mkdirs();
        }
    }
}
