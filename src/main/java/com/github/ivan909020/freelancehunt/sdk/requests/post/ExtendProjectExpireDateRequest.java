package com.github.ivan909020.freelancehunt.sdk.requests.post;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.post.ExtendProjectExpireDateResponse;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Map;

import static com.github.ivan909020.freelancehunt.sdk.client.ObjectMapperConfig.DATE_TIME_PATTERN;

public class ExtendProjectExpireDateRequest extends PostApiRequest<ExtendProjectExpireDateResponse> {

    private Long projectId;
    private ZonedDateTime expiredAt;

    public ExtendProjectExpireDateRequest() {
    }

    public ExtendProjectExpireDateRequest setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    public ExtendProjectExpireDateRequest setExpiredAt(ZonedDateTime expiredAt) {
        this.expiredAt = expiredAt;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "projects/" + projectId + "/extend";
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
    public ExtendProjectExpireDateResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, ExtendProjectExpireDateResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
