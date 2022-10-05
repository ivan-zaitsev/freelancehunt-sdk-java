package com.ivan909020.freelancehunt.sdk.requests.projects;

import static com.ivan909020.freelancehunt.sdk.configs.ObjectMapperConfig.DATE_TIME_PATTERN;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import com.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import com.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.ivan909020.freelancehunt.sdk.responses.projects.ReopenProjectResponse;

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
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity(requestSerializer.serialize(buildBodyParameters()));
        }
        return httpEntity;
    }

    private Map<String, Object> buildBodyParameters() {
        return Map.of("expired_at", expiredAt.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)));
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
    public ReopenProjectResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, ReopenProjectResponse.class);
    }

}
