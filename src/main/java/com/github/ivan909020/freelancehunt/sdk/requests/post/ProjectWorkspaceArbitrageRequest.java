package com.github.ivan909020.freelancehunt.sdk.requests.post;

import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiException;
import com.github.ivan909020.freelancehunt.sdk.exceptions.ApiValidationException;
import com.github.ivan909020.freelancehunt.sdk.requests.PostApiRequest;
import com.github.ivan909020.freelancehunt.sdk.responses.post.ProjectWorkspaceArbitrageResponse;

import java.util.Collections;
import java.util.Map;

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
        return "my/workspaces/projects/" + workspaceId + "/request-arbitrage";
    }

    @Override
    public Map<String, Object> getParameters() {
        return Collections.singletonMap("comment_html", commentHtml);
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
    public ProjectWorkspaceArbitrageResponse deserializeResponse(String responseContent) {
        try {
            return deserializeResponse(responseContent, ProjectWorkspaceArbitrageResponse.class);
        } catch (ApiException e) {
            throw e.setRequestPath(getUrl());
        }
    }

}
