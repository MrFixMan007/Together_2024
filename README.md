# mobile application "Together" for notes is multi-module project on Clean Architecture with DI Hilt.
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

https://github.com/user-attachments/assets/acbdee5d-163d-49b7-bcb3-5a5367d3d630

