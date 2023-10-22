package ua.ivanzaitsev.freelancehunt.sdk.services.requests;

public interface RequestSerializer {

    byte[] serialize(Object content);

}
