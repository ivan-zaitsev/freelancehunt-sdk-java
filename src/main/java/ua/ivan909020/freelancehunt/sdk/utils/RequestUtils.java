package ua.ivan909020.freelancehunt.sdk.utils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public final class RequestUtils {

    private RequestUtils() {
    }

    public static String buildUrlParameters(Map<String, Object> parameters) {
        StringBuilder result = new StringBuilder("?");

        for (Map.Entry<String, Object> entry : parameters.entrySet()) {
            result.append(encode(entry.getKey())).append("=");
            result.append(encode(String.valueOf(entry.getValue()))).append("&");
        }

        return result.length() > 0 ? result.substring(0, result.length() - 1) : "";
    }

    private static String encode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }

}
