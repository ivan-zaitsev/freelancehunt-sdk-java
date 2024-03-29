package ua.ivanzaitsev.freelancehunt.sdk.objects.models;

import static ua.ivanzaitsev.freelancehunt.sdk.utils.DateUtils.DATE_TIME_PATTERN;

import java.time.ZonedDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Update {

    @JsonProperty("description")
    private String description;

    @JsonProperty("description_html")
    private String descriptionHtml;

    @JsonProperty("published_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
    private ZonedDateTime publishedAt;

    public String getDescription() {
        return description;
    }

    public String getDescriptionHtml() {
        return descriptionHtml;
    }

    public ZonedDateTime getPublishedAt() {
        return publishedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Update update = (Update) o;
        return Objects.equals(description, update.description) &&
                Objects.equals(descriptionHtml, update.descriptionHtml) &&
                Objects.equals(publishedAt, update.publishedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, descriptionHtml, publishedAt);
    }

    @Override
    public String toString() {
        return "Update{" +
                "description='" + description + '\'' +
                ", descriptionHtml='" + descriptionHtml + '\'' +
                ", publishedAt=" + publishedAt +
                '}';
    }

}
