Feature: Validation Place API

  Scenario: Verify Place is being successfully added using AddPlaceApi
    Given Add place payload is ready
    When user calls AddPlaceAPI with Post http request
    Then the API call returns status code 200
    And the status in response body is OK

