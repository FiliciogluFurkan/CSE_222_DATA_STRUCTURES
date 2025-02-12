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
	javac -d target -sourcepath . src/Alphabet.java src/Decryptor.java src/encrpytor.java src/Preprocessor.java src/Test.java 

javadoc: 
	javadoc -d doc/ src/Alphabet.java src/Decryptor.java src/encrpytor.java src/Preprocessor.java src/Test.java
