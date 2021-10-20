@echo off

@REM echo deploy all jars in lib dir to local-maven-repo
set version=%1
set currVer=5.4-SNAPSHOT

if "%version%"=="" set "version=%currVer%"

@REM function: 3 parameters
:mvnDeploy
  set groupId=%~1     
  set version=%~2
  set jarFilePath=%~3
  set artifactId=%~4
  @REM (TODO:) extract artifactId from jarName 
  @REM jarName=$( basename -s .jar $jarFilePath )
  @REM arrPath=(${jarName//-/ })
  @REM artifactId=${arrPath[0]}-${arrPath[1]}
  
  set "mesg=Deploying %artifactId% (%jarFilePath%) to local-maven-rep..." 
  echo %mesg%
  mvn deploy:deploy-file ^
    -DgroupId=%groupId% ^
    -DartifactId=%artifactId% ^
    -Dversion=%version% ^
    -Durl=file:./local-maven-repo/ ^
    -DrepositoryId=local-maven-repo ^
    -DupdateReleaseInfo=true ^
    -Dfile=%jarFilePath%
EXIT /B 0

@REM deploy jda's top-level libs
for %%jarFilePath in (lib/jda/*.jar) do (
  call :mvnDeploy "jda", %version%, %%jarFilePath%
)

@REM deploy jda's module libs
for %%jarFilePath in (lib/jda-modules/*.jar) do (
  call :mvnDeploy "jda-modules", %version% , %%jarFilePath
)

echo "...done"