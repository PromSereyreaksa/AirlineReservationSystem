# PricingSystem Class Documentation

The `PricingSystem` class is designed to calculate the price of a booking based on various factors such as distance, travel class, demand, seasonality, competition, and more. Below is a detailed explanation of the attributes and methods in the class.

## Attributes

### `source`
- **Type**: `String`
- **Description**: Represents the starting point of the journey.

### `destination`
- **Type**: `String`
- **Description**: Represents the destination of the journey.

### `travelClass`
- **Type**: `String`
- **Description**: Represents the class of travel (e.g., Economy, Business, First).

### `departureDate`
- **Type**: `LocalDate`
- **Description**: Represents the date of departure.

### `departureTime`
- **Type**: `LocalTime`
- **Description**: Represents the time of departure.

### `arrivalDate`
- **Type**: `LocalDate`
- **Description**: Represents the date of arrival.

### `arrivalTime`
- **Type**: `LocalTime`
- **Description**: Represents the time of arrival.

### `economyClass`
- **Type**: `double`
- **Description**: A static multiplier for the economy class price.

### `businessClass`
- **Type**: `double`
- **Description**: A static multiplier for the business class price.

### `firstClass`
- **Type**: `double`
- **Description**: A static multiplier for the first class price.

## Methods

### `PricingSystem(String source, String destination, String travelClass, LocalDate departureDate, LocalDate arrivalDate, LocalTime departureTime, LocalTime arrivalTime)`
- **Description**: Constructor to initialize the `PricingSystem` object with the provided attributes.
- **Parameters**:
  - `source`: The starting point of the journey.
  - `destination`: The destination of the journey.
  - `travelClass`: The class of travel.
  - `departureDate`: The date of departure.
  - `arrivalDate`: The date of arrival.
  - `departureTime`: The time of departure.
  - `arrivalTime`: The time of arrival.

### `calculateBasePrice(double distance, String travelClass)`
- **Description**: Calculates the base price based on the distance and travel class.
- **Parameters**:
  - `distance`: The distance of the journey in kilometers.
  - `travelClass`: The class of travel.
- **Returns**: The base price as a `double`.

### `calculateFinalPrice(double distance)`
- **Description**: Calculates the final price by applying various factors to the base price.
- **Parameters**:
  - `distance`: The distance of the journey in kilometers.
- **Returns**: The final price as a `double`.

### `calculateDemandFactor()`
- **Description**: Calculates the demand factor (currently a skeleton method).
- **Returns**: A `double` representing the demand factor (default is 1.0).

### `calculateSeasonalityFactor()`
- **Description**: Calculates the seasonality factor (currently a skeleton method).
- **Returns**: A `double` representing the seasonality factor (default is 1.0).

### `calculateCompetitionFactor()`
- **Description**: Calculates the competition factor (currently a skeleton method).
- **Returns**: A `double` representing the competition factor (default is 1.0).

### `calculateTimeOfBookingFactor()`
- **Description**: Calculates the time of booking factor (currently a skeleton method).
- **Returns**: A `double` representing the time of booking factor (default is 1.0).

### `calculateFuelCostFactor()`
- **Description**: Calculates the fuel cost factor (currently a skeleton method).
- **Returns**: A `double` representing the fuel cost factor (default is 1.0).

### `calculateOperatingCostFactor()`
- **Description**: Calculates the operating cost factor (currently a skeleton method).
- **Returns**: A `double` representing the operating cost factor (default is 1.0).

### `calculateAirlineStrategyFactor()`
- **Description**: Calculates the airline strategy factor (currently a skeleton method).
- **Returns**: A `double` representing the airline strategy factor (default is 1.0).

### `calculateTotalTravelTime()`
- **Description**: Calculates the total travel time between departure and arrival.
- **Returns**: A `String` representing the total travel time in hours and minutes.

### `validateTravelClass(String travelClass)`
- **Description**: Validates if the provided travel class is valid.
- **Parameters**:
  - `travelClass`: The class of travel to validate.
- **Returns**: A `boolean` indicating whether the travel class is valid.

### `validateDateTime(LocalDate date, LocalTime time)`
- **Description**: Validates if the provided date and time are not in the past.
- **Parameters**:
  - `date`: The date to validate.
  - `time`: The time to validate.
- **Returns**: A `boolean` indicating whether the date and time are valid.

### `generateBookingID()`
- **Description**: Generates a booking ID based on the departure date and a random number (currently a skeleton method).
- **Returns**: A `String` representing the booking ID.

## Relationships Between Attributes and Methods

- The `calculateBasePrice` method uses the `travelClass` attribute to determine the price multiplier and calculates the base price based on the distance.
- The `calculateFinalPrice` method calls `calculateBasePrice` and then applies various factors (demand, seasonality, competition, etc.) to compute the final price.
- The `calculateTotalTravelTime` method uses `departureTime` and `arrivalTime` to calculate the total travel duration.
- The `validateTravelClass` method checks if the `travelClass` attribute is valid.
- The `validateDateTime` method ensures that the `departureDate` and `departureTime` are not in the past.
- The `generateBookingID` method uses the `departureDate` to create a unique booking ID.

## Conclusion

The `PricingSystem` class is a comprehensive system for calculating the price of a booking based on various factors. The methods are designed to be modular, allowing for easy extension and customization. The attributes store essential information about the booking, which is used by the methods to perform calculations and validations.
