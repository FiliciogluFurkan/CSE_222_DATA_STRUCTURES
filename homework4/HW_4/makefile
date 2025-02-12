JC = javac
JFLAGS = -classpath
JD = javadoc
JDFLAGS = -protected -splitindex -use -author -version -d ./javadoc
RM = rm
JR = java

CLASSES = src/*.java

run: all
	java -cp target Test

all: 
	javac -d target -sourcepath . src/Directory.java src/File.java src/FileSystem.java src/FileSystemElement.java src/Test.java 

javadoc: 
	javadoc -d doc/ src/Directory.java src/File.java src/FileSystem.java src/FileSystemElement.java src/Test.java