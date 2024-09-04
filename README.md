## task1 - simple project with two activities. MainAcivity transition to the second with notify-button.
## task2 - simple project with one activity with profile-layout.
## task3 - simple project with getting weather from api.
You need to register the key in the local.properties with keyname "API_KEY", for examle `API_KEY = 1f5d4f6r`
## task4 - two simple projects with getting weather from api
### 1 - with DI on Koin
### 2 - with DI on Hilt
You also need to register the key in the local.properties like in task3
## task5 - simple project with two recycler views and one view flipper
You can click to view flipper for slide, add items to recycler views by button click, refresh page by swipe to down.
## task6 - simple project with features like in the task1-project but on compose
## task7 - simple project with three screens. navigation between screens is done with arguments
## final_task - mobile application "Together" is multi-module project on Clean Architecture with DI Hilt.
Modules: 
* app - application builder and graph navigation builder
* core
  * core-common - business logic
  * core-navigation - compose navigation
  * core-ui - themes, fonts, components
  * core-utils - shared prefs, hashing password algorithms, text validation
* database - room local database
* network - retrofit api service, processing 401 status with shared prefs phone, password, token values
* feature_details - unfinished module
* feature_home_screen - getting last local note, last community note, courses
* feature_login - authorization and registration screens
