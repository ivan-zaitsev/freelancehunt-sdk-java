package ua.ivan909020.freelancehunt.sdk.requests.threads;

import static java.lang.String.format;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpRequest;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.threads.UploadFileToThreadResponse;
import ua.ivan909020.freelancehunt.sdk.utils.StreamUtils;

public class UploadFileToThreadRequest extends PostApiRequest<UploadFileToThreadResponse> {

    private Long threadId;
    private List<File> attachments;

    public UploadFileToThreadRequest() {
    }

    public UploadFileToThreadRequest setThreadId(Long threadId) {
        this.threadId = threadId;
        return this;
    }

    public UploadFileToThreadRequest setAttachments(List<File> attachments) {
        this.attachments = attachments;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/threads/" + threadId + "/attachment";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity();
        }
        return httpEntity;
    }

    @Override
    public void writeRequest(HttpRequest request) throws IOException {
        request.addHeader("Content-Type", "multipart/form-data; boundary=boundary");

        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(request.getOutputStream(), UTF_8), true)) {
            for (int i = 0; i < attachments.size(); i++) {
                String fieldName = "attachment" + (i + 1);
                File file = attachments.get(i);

                appendFileHeaders(writer, fieldName, file.getName());
                appendFileContent(request.getOutputStream(), file);

                writer.append("\r\n");
            }

            writer.append("\r\n");
            writer.append("--").append("boundary").append("--").append("\r\n");
            writer.flush();
        }
    }

    private void appendFileHeaders(PrintWriter writer, String fieldName, String fileName) {
        writer.append("--").append("boundary");
        writer.append("\r\n");

        writer.append(format("Content-Disposition: form-data; name=\"%s\"; filename=\"%s\"", fieldName, fileName));
        writer.append("\r\n");

        writer.append("Content-Type: application/octet-stream; charset=UTF-8");
        writer.append("\r\n");

        writer.append("Content-Transfer-Encoding: binary");
        writer.append("\r\n\r\n");
        writer.flush();
    }

    private void appendFileContent(OutputStream outputStream, File file) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(file)) {
            StreamUtils.transfer(inputStream, outputStream);
        }
        outputStream.flush();
    }

    @Override
    protected void validate() {
        if (threadId == null) {
            throw new ApiValidationException("ThreadId parameter can't be empty");
        }
        if (attachments == null || attachments.isEmpty()) {
            throw new ApiValidationException("Attachments parameter can't be empty");
        }
    }

    @Override
    protected UploadFileToThreadResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, UploadFileToThreadResponse.class);
    }

}
