# freelancehunt-sdk-java

Java library for Freelancehunt API interaction. Features documentation can be found [here](https://apidocs.freelancehunt.com/).

## Technology stack

Java 8, Maven, FasterXML Jackson, Apache HttpComponents

## Usage guide

#### Get cities by country id
```java
FreelancehuntApi api = new FreelancehuntApi("TOKEN");
GetCitiesResponse citiesResponse = api.sendRequest(new GetCitiesRequest().setCountryId(1L));
for (City city : citiesResponse.getCities()) {
    System.out.println(city.getName());
}
```
