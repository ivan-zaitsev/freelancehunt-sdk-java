package ua.ivanzaitsev.freelancehunt.sdk.objects.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Avatar {

    @JsonProperty("small")
    private Image smallImage;

    @JsonProperty("large")
    private Image largeImage;

    public Image getSmallImage() {
        return smallImage;
    }

    public Image getLargeImage() {
        return largeImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Avatar avatar = (Avatar) o;
        return Objects.equals(smallImage, avatar.smallImage) &&
                Objects.equals(largeImage, avatar.largeImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(smallImage, largeImage);
    }

    @Override
    public String toString() {
        return "Avatar{" +
                "smallImage=" + smallImage +
                ", largeImage=" + largeImage +
                '}';
    }

}
