# todo
Todo App with React Redux && Spring Boot

Frontend start
npm start

How to Compile Project

PreRequisites
java 11 - maven - npm installations are required.

mvn compile
By running mvn compile, both backend and frontend start to compile.

Dependency jars are downloaded from mvn repository.

Dependency js libs are downloaded from npm repository.

npm install command runs within mvn compile.

How to Build Package
To build a package, follow below commands in the given order.

mvn clean
Removes backend/target and frontend/build directories.

mvn package
Runs npm build and copies build files into backend/resources/public directory.

Compiles backend source and packages a springboot jar.

Finally, you can get springboot jar from backend/target directory.
