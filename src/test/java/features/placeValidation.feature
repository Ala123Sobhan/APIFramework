Feature: Validation Place API

  Scenario Outline: Verify Place is being successfully added using AddPlaceApi
    Given Add place payload with <Name> , <Address> and <Language>
    When user calls "AddPlaceAPI" with "Post" http request
    Then the API call returns status code 200
    And the "status" in response body is "OK"
    And the "scope" in response body is "APP"
    And the "place_id" maps to the <Name> when user calls "getPlaceAPI"

    Examples:
      | Name        | Address    | Language |
      | Frame House | Bronx, NY  | English  |
      | AID Coching | Dhaka, Ban | Bengali  |



