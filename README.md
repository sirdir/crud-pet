# build/test

Test assignment for Sr. QA Automation Engineer in (EPAMm, Netherland)

##Test assignment

You can find pdf in project root folder file Test-automation-assignment.pdf
`Please complete it and  then send me back alongside with the estimated time you spent dealing with it!`

##IMPORTANT

Additional suggestions from reviewers to add Lombok for builder pattern and json POJOs. Move constants to configs.

-----

gradle used as dependency management

if you want to execute test and get report in one command use
* for Win users `gradlew.bat clean test allureReport allureServe`
* for Linux/Mac users `./gradlew clean test allureReport allureServe`

for just test run use

* for Win `gradlew.bat clean test`
* for Linux/Mac `./gradlew clean test`

# reports
will be generated after build and opened in default browser

https://youtu.be/uCPeqIf3CDs - just brief introduction of allure2

but sill if you want look at them separately after test run, you can execute

* for Win 
* * `gradlew.bat allureReport` 
* * `.allure\allure-2.8.0\bin\allure.bat serve .\build\allure-results`
* for Linux/Mac 
* * `./gradlew allureReport` 
* * `.allure/allure-2.8.0/bin/allure serve ./build/allure-results`