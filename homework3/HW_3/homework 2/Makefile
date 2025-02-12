JC = javac
JFLAGS = -classpath
JD = javadoc
JDFLAGS = -protected -splitindex -use -author -version -d ./javadoc
RM = rm
JR = java

CLASSES = src/*.java

run: all
	java -cp target/ Homework3.Test

all: 
	javac -d target -sourcepath . src/Homework3/Device.java src/Homework3/Tv.java src/Homework3/Gamebox.java src/Homework3/Headphones.java src/Homework3/Inventory.java src/Homework3/Laptop.java src/Homework3/Smartphone.java src/Homework3/Test.java

javadoc: 
	javadoc -d doc/ src/Homework3/Device.java src/Homework3/Tv.java src/Homework3/Gamebox.java src/Homework3/Headphones.java src/Homework3/Inventory.java src/Homework3/Laptop.java src/Homework3/Smartphone.java src/Homework3/Test.java