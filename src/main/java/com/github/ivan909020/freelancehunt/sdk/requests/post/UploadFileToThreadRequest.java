package com.github.ivan909020.freelancehunt.sdk.requests.post;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.post.UploadFileToThreadResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.File;
import java.util.List;

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
    public void setEntity(HttpPost request) {
        MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
        for (int i = 0; i < attachments.size(); i++) {
            String name = "attachment" + (i + 1);
            File file = attachments.get(i);
            entityBuilder.addBinaryBody(name, file, ContentType.APPLICATION_OCTET_STREAM, file.getName());
        }
        request.setEntity(entityBuilder.build());
    }

    @Override
    public String getUrlPath() {
        return "threads/" + threadId + "/attachment";
    }

    @Override
    public void validate() {
        super.validate();
        if (threadId == null) {
            throw new ApiValidationException("ThreadId parameter can't be empty");
        }
        if (attachments == null || attachments.isEmpty()) {
            throw new ApiValidationException("Attachments parameter can't be empty");
        }
    }

    @Override
    public UploadFileToThreadResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, UploadFileToThreadResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
