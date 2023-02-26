package ua.ivan909020.freelancehunt.sdk.requests.projects.update;

import static ua.ivan909020.freelancehunt.sdk.utils.DateUtils.DATE_TIME_PATTERN;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.request.entity.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.projects.update.ExtendProjectExpireDateResponse;

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
    protected void validate() {
        if (projectId == null) {
            throw new ApiValidationException("ProjectId parameter can't be empty");
        }
        if (expiredAt == null) {
            throw new ApiValidationException("ExpiredAt parameter can't be empty");
        }
    }

}
