build:
	javac Tnode.java
	javac Brain.java
	javac Tree.java
	javac FancyString.java

clean:
	rm *.class

run:
	java Brain
