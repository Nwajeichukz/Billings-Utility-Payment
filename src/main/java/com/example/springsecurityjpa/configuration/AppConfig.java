package com.example.springsecurityjpa.configuration;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
    private static final Dotenv dotenv = Dotenv.load();

    public static String getApiKey() {
        return dotenv.get("APIKEY");
    }

    public static String getApiCategory() {
        return dotenv.get("CATEGORY");
    }
    public static String getApiUrl() {
        return dotenv.get("APIURL");
    }
}
