JC = javac
JFLAGS = -g
TARGET = Main
SOURCES = Main.java AVLTree.java GUIVisualization.java Stock.java StockDataManager.java
JDDIR = doc

default: $(TARGET)

$(TARGET): $(SOURCES)
	$(JC) $(JFLAGS) $^
	java -Xint $(TARGET)

clean:
	rm -f *.class

javadoc: 
	javadoc -d doc/ Main.java AVLTree.java GUIVisualization.java Stock.java StockDataManager.java

.PHONY: clean default doc
