# CourseMan basic example for `jda-tool`

## How to set up and run the CourseMan Basic example
1. clone/pull latest version of the the training repository.
   - Suppose the cloned folder is: `~/jda-training/training`.
   - The folder that we focus on in this example:
      `EXAMPLE.FOLDER` = `~/jda-training/training/jda/examples/jda-eg-coursemanbasics`

2. compile the code (from the parent folder, to ensure that local-maven-repo is updated with any JDA's jar changes)
   1. cd into the parent `.../examples` folder
4. compile source code: `mvn -U compile` (`-U` option is to activate the local-maven-repo updates)
5. cd into the `$EXAMPLE.FOLDER`
6. run the example:

    `mvn exec:java@run`
     
A successful execution presents the following output on the console (Press `Ctrl+C` to exit):

```
class org.jda.example.courseman.software.MainBasic

(+) DomSoftware.init()
16:02:48.681 [org.jda.example.courseman.software.MainBasic.main()] INFO  MainBasic - Resetting DomCity

(+) DomSoftware.deleteDomainModel(1 classes)
16:02:54.157 [org.jda.example.courseman.software.MainBasic.main()] INFO  MainBasic - Resetting DomStudents

(+) DomSoftware.deleteDomainModel(1 classes)
16:02:54.164 [org.jda.example.courseman.software.MainBasic.main()] INFO  MainBasic - Running DomCity

(+) DomSoftware.addClasses()

(+) DomSoftware.loadObjects(City)


(+) DomSoftware.printObjectPool()
Class: org.jda.example.courseman.services.student.model.City
(empty)

(+) DomSoftware.addObject(class org.jda.example.courseman.services.student.model.City, Hanoi)


(+) DomSoftware.printObjectDB()

TABLE: courseman.City
ID,  NAME
1,  Hanoi
16:02:55.201 [org.jda.example.courseman.software.MainBasic.main()] INFO  MainBasic - Running DomStudents

(+) DomSoftware.addClasses()

(+) DomSoftware.retrieveObject(City: id EQ 1)

(+) DomSoftware.addObject(class org.jda.example.courseman.services.student.model.Student, Student(S2021,Duc Le,Male, Thu Jan 01 00:00:00 ICT 1970,Hanoi,duc@gmail.com))


(+) DomSoftware.printObjectDB()

TABLE: courseman.Student
ID,  NAME,  GENDER_NAME,  DOB,  ADDRESS_ID,  EMAIL,  SCLASS_ID
S2021,  Duc Le,  Male,  1970-01-01,  1,  duc@gmail.com,  null
```
