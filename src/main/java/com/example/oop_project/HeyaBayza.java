package com.example.oop_project;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class HeyaBayza {

    public static String IsHeyaBayza(String imagePath){
        String serverUrl = "http://localhost:5000"; // Replace with your server URL

        try {
            URL url = new URL(serverUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            // Set the content type as multipart/form-data
            String boundary = "----WebKitFormBoundary7MA4YWxkTrZu0gW";
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

            OutputStream outputStream = connection.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);

            // Write the multipart/form-data boundary
            writer.println("--" + boundary);

            // Write the file content
            writer.println("Content-Disposition: form-data; name=\"image\"; filename=\"" + imagePath + "\"");
            writer.println("Content-Type: image/jpeg");
            writer.println();
            writer.flush();

            // Read the image file and write it to the output stream
            FileInputStream fileInputStream = new FileInputStream(new File(imagePath));
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            fileInputStream.close();

            // Write the multipart/form-data closing boundary
            writer.println();
            writer.println("--" + boundary + "--");
            writer.close();

            // Get the response from the server
            int responseCode = connection.getResponseCode();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            // Extract the predicted class from the HTML response
            String predictedClass = extractPredictedClass(response.toString());

            // Display the predicted class
            System.out.println("Predicted Class: " + predictedClass);
            // Close the reader
            reader.close();
            return "Predicted Class: " + predictedClass;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String extractPredictedClass(String html) {
        // Logic to extract the predicted class from the HTML response
        // Modify this method based on the structure of your HTML response
        // You can use libraries like Jsoup for HTML parsing

        String predictedClass = ""; // Placeholder

        // Example logic: Assuming the predicted class is present within a <span> element with the id "predicted-class"
        int start = html.indexOf("<p class=\"card-text\">");
        if (start != -1) {
            start += "<p class=\"card-text\">".length();
            int end = html.indexOf("</p>", start);
            if (end != -1) {
                predictedClass = html.substring(start, end);
            }
        }

        return predictedClass;
    }
}

