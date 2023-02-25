# freelancehunt-sdk-java

Java library for Freelancehunt API interaction. Features documentation can be found [here](https://apidocs.freelancehunt.com/).

## Technology stack

Java 8, Maven, FasterXML Jackson

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

GetCitiesResponse citiesResponse = apiClient.sendRequest(new GetCitiesRequest().setCountryId(1L));
for (City city : citiesResponse.getCities()) {
    System.out.println(city.getName());
}
```
