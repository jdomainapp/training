# CourseMan example for module-mosar

1. clone/pull latest version of the the training repository
2. compile source code: `mvn clean install`
3. run RFS code generator:

   `mvn exec:java@genrfs`

   - frontend source: `src/main/java/org/jda/example/mosar/courseman/frontend`
   - backend source: `src/main/java/org/jda/example/mosar/courseman/backend`
4. compile again (to compile the generated code): 

    `mvn compile`
5. run the backend (SpringBoot application):

    `mvn exec:java@runbe`
6. run the frontend (Reactjs):
   - create a project's folder from the provided template
   - copy the generated frontend source to the project's `src` folder
   - from the project's folder, run the app:

    `PORT=5000 npm run start`

