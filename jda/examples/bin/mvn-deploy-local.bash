# echo deploy all jars in lib dir to local-maven-repo
version=$1
currVer=5.4-SNAPSHOT

if [ -z "$version" ]
then
	version=$currVer
fi

# function: 3 parameters
mvnDeploy() {
  groupId=$1      # param 1
  version=$2      # param 2
  jarFilePath=$3  # param 3
  # extract artifactId from jarName
  jarName=$( basename -s .jar $jarFilePath )
  arrPath=(${jarName//-/ })
  artifactId=${arrPath[0]}-${arrPath[1]}
  
  mvnDeployFile $groupId, $artifactId, $version, $jarFilePath
}

# function: 3 parameters
mvnDeployFile() {
  groupId=$1      # param 1
  artifactId=$2      # param 1
  version=$3      # param 2
  jarFilePath=$4  # param 3
  
  echo "Deploying $artifactId ($jarFilePath) to local-maven-rep..." 
  mvn deploy:deploy-file \
    -DgroupId=$groupId \
    -DartifactId=$artifactId \
    -Dversion=$version \
    -Durl=file:./local-maven-repo/ \
    -DrepositoryId=local-maven-repo \
    -DupdateReleaseInfo=true \
    -Dfile=$jarFilePath
}

# deploy jda's top-level libs
for jarFilePath in lib/jda/*.jar
do 
  mvnDeploy "jda" $version $jarFilePath
done

# deploy jda's module libs
for jarFilePath in lib/jda-modules/*.jar
do 
  mvnDeploy "jda.modules" $version $jarFilePath
done

# deploy other libs
mvnDeployFile "jscaledhtmltextpane" "jscaledhtmltextpane" "unknown" lib/jscaledhtmltextpane.jar
mvnDeployFile "scrollabledesktop" "scrollabledesktop" "unknown" lib/scrollabledesktop.jar

echo "...done"
