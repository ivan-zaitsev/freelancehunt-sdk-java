package ua.ivan909020.freelancehunt.sdk.responses.skills;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.models.Skill;
import ua.ivan909020.freelancehunt.sdk.responses.ApiResponse;

public class GetSkillsResponse extends ApiResponse {

    @JsonProperty("data")
    private List<Skill> skills;

    public List<Skill> getSkills() {
        return skills;
    }

}
