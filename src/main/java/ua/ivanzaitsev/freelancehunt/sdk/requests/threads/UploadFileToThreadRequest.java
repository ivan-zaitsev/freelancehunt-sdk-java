package ua.ivanzaitsev.freelancehunt.sdk.requests.threads;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.ivanzaitsev.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivanzaitsev.freelancehunt.sdk.objects.request.HttpRequest;
import ua.ivanzaitsev.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivanzaitsev.freelancehunt.sdk.requests.PostApiRequest;
import ua.ivanzaitsev.freelancehunt.sdk.responses.threads.UploadFileToThreadResponse;
import ua.ivanzaitsev.freelancehunt.sdk.services.requests.MultipartRequestWriter;

public class UploadFileToThreadRequest extends PostApiRequest<UploadFileToThreadResponse> {

    private Long threadId;
    private List<File> attachments;

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
            httpEntity.addHeaders(buildHeaders());
        }
        return httpEntity;
    }

    private Map<String, String> buildHeaders() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("Content-Type", "multipart/form-data; boundary=boundary");
        return parameters;
    }

    @Override
    public void writeRequest(HttpRequest request) throws IOException {
        OutputStream outputStream = request.getOutputStream();
        try (outputStream) {
            MultipartRequestWriter writer = new MultipartRequestWriter("boundary", outputStream);
            for (int i = 0; i < attachments.size(); i++) {
                String fieldName = "attachment" + (i + 1);
                File file = attachments.get(i);

                try (FileInputStream inputStream = new FileInputStream(file)) {
                    writer.writeFilePart(fieldName, fieldName, inputStream);
                }
            }
            writer.finish();
        }
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

}
