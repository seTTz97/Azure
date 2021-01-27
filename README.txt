first create new App
to deploy app on windows:
1. launch cmd
2. open directory which contains application in cmd
3. insert command "mvn clean package" if maven is already installed if not use internal maven wrapper using command "./mvnw clean package"
4. insert command "mvn azure-webapp:deploy" or use internal maven using "./mvnw azure-webapp:deploy"
5. log in to azure