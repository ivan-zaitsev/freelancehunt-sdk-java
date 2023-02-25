# freelancehunt-sdk-java

Java library for Freelancehunt API interaction. Features documentation can be found [here](https://apidocs.freelancehunt.com/).

## Technology stack

Java 11, Maven, FasterXML Jackson

## Usage guide

#### Get cities by country id
```java
ApiConfig apiConfig = new ApiConfig();
apiConfig.setBaseUrl("https://api.freelancehunt.com/v2");
apiConfig.setApiToken("TOKEN");
apiConfig.setLanguage("en");

HttpClientConfig httpClientConfig = new HttpClientConfig();
httpClientConfig.setConnectionTimeout(30_000);
httpClientConfig.setSocketTimeout(30_000);

ApiClient apiClient = ApiClient.builder()
    .setApiConfig(apiConfig)
    .setHttpClientConfig(httpClientConfig)
    .build();


GetCitiesRequest citiesRequest = new GetCitiesRequest();
citiesRequest.setCountryId(1L);

GetCitiesResponse citiesResponse = apiClient.sendRequest(citiesRequest);
for (City city : citiesResponse.getCities()) {
    System.out.println(city.getName());
}
```
