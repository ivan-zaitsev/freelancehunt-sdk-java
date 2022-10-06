package ua.ivan909020.freelancehunt.sdk.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public final class StreamUtils {

    private StreamUtils() {
    }

    public static String readContent(InputStream inputStream) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        
        transfer(inputStream, result);
        
        return result.toString(StandardCharsets.UTF_8);
    }
    
    public static void transfer(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, length);
        }
    }

}
