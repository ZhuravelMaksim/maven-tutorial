# maven-tutorial
0. Introduction
 - 3 tier web architecture

 - SOLID principles - https://web-creator.ru/articles/solid

A. What is Maven. https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
 - War file structure. See image 1

 - POM structure - https://maven.apache.org/pom.html

B. Maven build stages. see image 2
https://www.studytonight.com/maven/maven-build-life-cycle

C. Work with modules:

1. Add parent project: mvn archetype:generate -DgroupId=com.intexsoft -DartifactId=webApp -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=pom-root -DarchetypeVersion=RELEASE

2. Add web module inside parent project: mvn archetype:generate -DgroupId=com.intexsoft -DartifactId=web -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

3. Add service module inside parent project: mvn archetype:generate -DgroupId=com.intexsoft -DartifactId=service -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

4. Add repository module inside parent project: mvn archetype:generate -DgroupId=com.intexsoft -DartifactId=repository -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

5. Add model module inside parent project: mvn archetype:generate -DgroupId=com.intexsoft -DartifactId=model -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

D. Dependencies and dependencies management. Dependency scope: see image 3

E. Plugins:
https://maven.apache.org/plugins/

1. http://maven.apache.org/plugins/maven-dependency-plugin/ :
	-Type mvn dependency:analyze and you'll see unused dependencies in web module:
	[WARNING] Unused declared dependencies found:
	[WARNING]    junit:junit:jar:4.12:test
	[WARNING]    org.apache.commons:commons-lang3:jar:3.8.1:compile
	
	-Type mvn dependency:analyze and you'll see duplicate dependencies in web module:
	List of duplicate dependencies defined in <dependencies/> in your pom.xml: org.apache.commons:commons-lang3:jar

2. http://maven.apache.org/plugins/maven-compiler-plugin/ :
	We can tell to comlier which version of java it should use -
	  <properties>
		<maven.compiler.source>1.8</maven.compiler.source>
		<maven.compiler.target>1.8</maven.compiler.target>
	  </properties>
	  or use maven-compiler-plugin directly
	  
3. https://maven.apache.org/plugins/maven-jar-plugin/ : use for jar customizing.
	  
4. http://maven.apache.org/plugins/maven-deploy-plugin/ :
	use for deploy artifact to repository - http://maven.apache.org/plugins/maven-deploy-plugin/usage.html

F. Profiles:
https://maven.apache.org/guides/introduction/introduction-to-profiles.html

1. Run mvn compile -X. You'll see that some compiler properties will be changed, because you use java 1.8.
2. mvn clean install -Dtest=false -X. You'll see that project tests will not run.
3. mvn clean install -Pdev; mvn clean install -Pqa;mvn clean install -Pprod. You'll see different war file names.
