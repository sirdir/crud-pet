# build/test
gradle used as dependency management

if you want to execute test and get report in one command use
* for Win users `gradlew.bat clean test allureServe`
* for Linux/Mac users `.\gradlew clean test allureServe`

for just test run use

* for Win `gradlew.bat clean test`
* for Linux/Mac `./gradlew clean test`

# reports
will be generated after build and opened in default browser

but sill if you want look at them separately after test run, you can execute

* for Win 
* * `gradlew.bat allureReport` 
* * `.allure\allure-2.8.0\bin\allure.bat serve .\build\allure-results`
* for Linux/Mac 
* * `./gradlew allureReport` 
* * `.allure/allure-2.8.0/bin/allure serve ./build/allure-results`