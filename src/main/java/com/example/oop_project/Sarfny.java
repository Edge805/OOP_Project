package com.example.oop_project;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Sarfny {
    private static String apiKey = "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";

    public Sarfny() {
    }

    public String generateResponse(String prompt) throws IOException {
        try {
            URL url = new URL("https://api.openai.com/v1/engines/davinci/completions");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String data = "{\"prompt\": \"" + prompt + "\", \"max_tokens\": 100}";
            byte[] postData = data.getBytes(StandardCharsets.UTF_8);
            try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                outputStream.write(postData);
            }

            StringBuilder response = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
            }
            connection.disconnect();
            // Extract and return the generated response from the API response
            return extractGeneratedResponse(response.toString());
        } catch (Exception e) {
            throw e;
        }

    }

    private String extractGeneratedResponse(String apiResponse) {
        int startIndex = apiResponse.indexOf("\"choices\":");
        if (startIndex != -1) {
            startIndex = apiResponse.indexOf("\"text\":", startIndex);
            if (startIndex != -1) {
                int endIndex = apiResponse.indexOf("\"", startIndex + 8);
                if (endIndex != -1) {
                    return apiResponse.substring(startIndex + 8, endIndex);
                }
            }
        }
        return null;
    }
}
