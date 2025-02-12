JC = javac
JFLAGS = -classpath
JD = javadoc
JDFLAGS = -protected -splitindex -use -author -version -d ./javadoc
RM = rm
JR = java

CLASSES = src/*.java

run: all
	java -cp target Tester

all: 
	javac -d target -sourcepath . src/BubbleSort.java src/MergeSort.java src/QuickSort.java src/SelectionSort.java src/SortAlgorithm.java src/Tester.java 

javadoc: 
	javadoc -d doc/ src/BubbleSort.java src/MergeSort.java src/QuickSort.java src/SelectionSort.java src/SortAlgorithm.java src/Tester.java 
