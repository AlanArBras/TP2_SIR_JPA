mvn dependency:copy-dependencies
if [ ! -d "$DIRECTORY" ]
then
	mkdir data

fi
cd data
java -cp '../target/dependency/*' org.hsqldb.Server
