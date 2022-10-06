package ua.ivan909020.freelancehunt.sdk.requests.projects.workspaces;

import java.io.IOException;
import java.util.Map;

import ua.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpEntity;
import ua.ivan909020.freelancehunt.sdk.objects.http.HttpResponse;
import ua.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import ua.ivan909020.freelancehunt.sdk.responses.projects.workspaces.ProjectWorkspaceArbitrageResponse;

public class ProjectWorkspaceArbitrageRequest extends PostApiRequest<ProjectWorkspaceArbitrageResponse> {

    private Long workspaceId;
    private String commentHtml;

    public ProjectWorkspaceArbitrageRequest() {
    }

    public ProjectWorkspaceArbitrageRequest setWorkspaceId(Long workspaceId) {
        this.workspaceId = workspaceId;
        return this;
    }

    public ProjectWorkspaceArbitrageRequest setCommentHtml(String commentHtml) {
        this.commentHtml = commentHtml;
        return this;
    }

    @Override
    public String getUrlPath() {
        return "/my/workspaces/projects/" + workspaceId + "/request-arbitrage";
    }

    @Override
    public HttpEntity getEntity() {
        if (httpEntity == null) {
            httpEntity = new HttpEntity(requestSerializer.serialize(buildBodyParameters()));
        }
        return httpEntity;
    }

    private Map<String, Object> buildBodyParameters() {
        return Map.of("comment_html", commentHtml);
    }

    @Override
    public void validate() {
        super.validate();
        if (workspaceId == null) {
            throw new ApiValidationException("WorkspaceId parameter can't be empty");
        }
        if (commentHtml == null) {
            throw new ApiValidationException("CommentHtml parameter can't be empty");
        }
    }

    @Override
    public ProjectWorkspaceArbitrageResponse deserializeResponse(HttpResponse response) throws IOException {
        return responseDeserializer.deserialize(response, ProjectWorkspaceArbitrageResponse.class);
    }

}
