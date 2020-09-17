# REST Countries API 

## Build Instructions:
1. Clone or Download the repository
2. Import the project into Android Studio
3. Build and then run the application


## Gradle library used:
* RecyclerView: displaying list
* RxJava: for programming reactively
* Retrofit: for making http request
* Timber : for debugging
* OKHttp: for http interceptions
* Dagger: for dependency injection


## App flow:
When the application is run, the launch activity is MainActivtiy, it shows a list of countries [RestCountries](https://restcountries.eu/).

The List is initially sort by Country Name A -> Z.

The List can be sorted by:
- Name: A to Z ↑↓ 
- Population: 0 to n ↑↓


## Time to complete:
The core of the application took about 4hrs complete. Junit test where added after 4hrs mark.


## With more time:
- Would add more test
- Added more data sources e.g. Room Database, in keeping with the reactive manifesto
- Improved the UI e.g. Buttons
- Added Search functionality 