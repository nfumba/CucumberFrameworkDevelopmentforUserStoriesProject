package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static String read(String path, String key) throws IOException {

        FileInputStream fis = new FileInputStream(path);
        Properties properties = new Properties();
        properties.load(fis);
        return properties.getProperty(key);

    }





    public static String read(String key) throws IOException {
        return read(Constants.CONFIG_FILE_PATH, key);

    }
    public static String incrementUserId() throws IOException {
        String key = "userId";
        FileInputStream fis = new FileInputStream(Constants.CONFIG_FILE_PATH);
        Properties properties = new Properties();
        properties.load(fis);
        fis.close();

        // Get the current value of userId
        String value = properties.getProperty(key);

        try {
            // Parse the value as an integer
            int intValue = Integer.parseInt(value);
            // Increment the userId by 1
            intValue++;
            // Convert the updated value back to a String
            value = String.valueOf(intValue);

            // Update the property in the Properties object
            properties.setProperty(key, value);

            // Write the updated properties back to the file
            FileOutputStream fos = new FileOutputStream(Constants.CONFIG_FILE_PATH);
            properties.store(fos, null);
            fos.close();

            System.out.println("userId incremented to: " + value);

        } catch (NumberFormatException e) {
            System.out.println("The value for 'userId' is not a valid integer.");
        }

        return value;  // Return the incremented userId value
    }
}