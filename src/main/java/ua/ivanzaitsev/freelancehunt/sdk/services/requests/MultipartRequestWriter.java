package ua.ivanzaitsev.freelancehunt.sdk.services.requests;

import static java.lang.String.format;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UncheckedIOException;

import ua.ivanzaitsev.freelancehunt.sdk.utils.StreamUtils;

public class MultipartRequestWriter {

    private static final String LINE = "\r\n";

    private final String boundary;
    private final OutputStream outputStream;
    private final PrintWriter printWriter;

    public MultipartRequestWriter(String boundary, OutputStream outputStream) {
        this.boundary = boundary;
        this.outputStream = outputStream;
        this.printWriter = new PrintWriter(new OutputStreamWriter(outputStream, UTF_8), true);
    }

    public void writeFilePart(String fieldName, String fileName, InputStream inputStream) {
        printWriter.append("--").append(boundary);
        printWriter.append(LINE);

        printWriter.append(format("Content-Disposition: form-data; name=\"%s\"; filename=\"%s\"", fieldName, fileName));
        printWriter.append(LINE);

        printWriter.append("Content-Type: application/octet-stream; charset=UTF-8");
        printWriter.append(LINE);

        printWriter.append("Content-Transfer-Encoding: binary");
        printWriter.append(LINE).append(LINE);
        printWriter.flush();

        try {
            StreamUtils.transfer(inputStream, outputStream);
            outputStream.flush();
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to transfer input stream", e);
        }
        printWriter.append(LINE);
        printWriter.flush();
    }

    public void finish() {
        printWriter.append(LINE);
        printWriter.append("--").append(boundary).append("--");
        printWriter.append(LINE);
        printWriter.flush();
    }

}
