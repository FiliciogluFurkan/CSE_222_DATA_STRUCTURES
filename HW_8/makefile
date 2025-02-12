JC = javac
JFLAGS = -classpath
JD = javadoc
JDFLAGS = -protected -splitindex -use -author -version -d ./javadoc
RM = rm
JR = java

CLASSES = src/*.java

run: all
	java -cp target Main

all: 
	javac -d target -sourcepath . src/SocialNetwork.java src/Person.java src/Main.java  

javadoc: 
	javadoc -d doc/ src/SocialNetwork.java src/Person.java src/Main.java 
