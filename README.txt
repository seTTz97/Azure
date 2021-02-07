to deploy app on windows:
1. launch cmd
2. open directory which contains application in cmd
3. insert command "mvnw clean package"
4. insert command "mvnw azure-webapp:deploy"
5. log in to azure
6. there you have it, successfully deploy
7. to see results go to https://<azure app name>azurewebsites.net/books
