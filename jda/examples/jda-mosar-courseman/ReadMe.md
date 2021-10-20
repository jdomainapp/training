# CourseMan example for module `jda-mosar`

## How to set up and run the CourseMan RFS example
1. clone/pull latest version of the the training repository.
   - Suppose the cloned folder is: `~/jda-training/training`.
   - The folder that we focus on in this example:
      `EXAMPLE.FOLDER` = `~/jda-training/training/jda/examples/jda-mosar-courseman`

2. cd into `$EXAMPLE.FOLDER`
3. compile source code: `mvn clean install`
4. generate the CourseMan RFS source code:

   `mvn exec:java@genrfs`

   - frontend source: `src/main/java/org/jda/example/mosar/courseman/frontend`
   - backend source: `src/main/java/org/jda/example/mosar/courseman/backend`
5. compile again (to compile the generated code): 

    `mvn compile`

6. run the backend (SpringBoot application):

    `mvn exec:java@runbe`
7. run the frontend (Reactjs):
   - create a project's folder from the provided template `dist/react-proj-template.zip`:

     `unzip $EXAMPLE.FOLDER/dist/react-proj-template.zip`

   - copy the generated frontend source to the project's `src` folder. Assume you have `cd`ed into the project's folder:

     `cp -r $EXAMPLE.FOLDER/src/main/java/org/jda/example/mosar/courseman/frontend/* src/`
    
   - from the project's folder:
     - install dependencies (only needs to do this once; takes a few minutes!):

       `npm install`

     - run the app:

       `PORT=5000 npm run start`

