package ua.ivan909020.freelancehunt.sdk.objects.entities;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import ua.ivan909020.freelancehunt.sdk.objects.models.EntityType;

public class Attachment {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    private EntityType type;

    @JsonProperty("file_type")
    private String fileType;

    @JsonProperty("size")
    private Integer size;

    @JsonProperty("name")
    private String name;

    @JsonProperty("url")
    private String url;

    @JsonProperty("thumbnail_url")
    private String thumbnailUrl;

    public Attachment() {
    }

    public Long getId() {
        return id;
    }

    public EntityType getType() {
        return type;
    }

    public String getFileType() {
        return fileType;
    }

    public Integer getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attachment that = (Attachment) o;
        return Objects.equals(id, that.id) &&
                type == that.type &&
                Objects.equals(fileType, that.fileType) &&
                Objects.equals(size, that.size) &&
                Objects.equals(name, that.name) &&
                Objects.equals(url, that.url) &&
                Objects.equals(thumbnailUrl, that.thumbnailUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, fileType, size, name, url, thumbnailUrl);
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "id=" + id +
                ", type=" + type +
                ", fileType='" + fileType + '\'' +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                '}';
    }

}
