package com.ivan909020.freelancehunt.sdk.requests.projects.update;

import static com.ivan909020.freelancehunt.sdk.configs.ObjectMapperConfig.DATE_TIME_PATTERN;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import com.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import com.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import com.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.ivan909020.freelancehunt.sdk.responses.projects.update.ExtendProjectExpireDateResponse;

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
        return "/projects/" + projectId + "/extend";
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
    public ExtendProjectExpireDateResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, ExtendProjectExpireDateResponse.class);
    }

}
