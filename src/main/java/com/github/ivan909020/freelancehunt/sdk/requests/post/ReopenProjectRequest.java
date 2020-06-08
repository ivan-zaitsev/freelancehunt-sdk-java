package com.github.ivan909020.freelancehunt.sdk.requests.post;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.post.ReopenProjectResponse;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Map;

import static com.github.ivan909020.freelancehunt.sdk.client.ObjectMapperConfig.DATE_TIME_PATTERN;

public class ReopenProjectRequest extends PostApiRequest<ReopenProjectResponse> {

    private Long projectId;
    private ZonedDateTime expiredAt;

    public ReopenProjectRequest() {
    }

    public ReopenProjectRequest setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    public ReopenProjectRequest setExpiredAt(ZonedDateTime expiredAt) {
        this.expiredAt = expiredAt;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "projects/" + projectId + "/reopen";
    }

    @Override
    public Map<String, Object> getParameters() {
        return Collections.singletonMap("expired_at", expiredAt.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)));
    }

    @Override
    public void validate() {
        super.validate();
        if (projectId == null) {
            throw new ApiValidationException("ProjectId parameter can't be empty");
        }
        if (expiredAt == null) {
            throw new ApiValidationException("ExpiredAt parameter can't be empty");
        }
    }

    @Override
    public ReopenProjectResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, ReopenProjectResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
