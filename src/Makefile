# Makefile, předběžná verze
# pack balí zatím vše
# clean maže pouze class soubory z bin
# Doxyfile není nastavený, pouze změněná cesta
# run zatím nemá co spouštět

JC = javac
JFLAGS = -g -d ../bin

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

JAVA_SRC = ./pckg/*.java

# přeloží projekt
all: classes

# .class
classes: $(JAVA_SRC:.java=.class)

.PHONY: pack clean test doc run 

# zabalí projekt tak aby mohl být odevzdán
pack:
	rm -f ../*.zip
	zip ../xlogin01_xlogin02_xlogin03_xlogin04.zip ../*

# smaže všechny soubory co nemají být odevzdány
clean:
	$(RM) ../bin/*.class

# spustí testy matematické knihovny
test:
	cd ../tests/pckg/; java -cp .:/usr/share/java/junit.jar org.junit.runner.JUnitCore Calc_LibTest.java

# spustí generování dokumentace
doc:
	doxygen ./Doxyfile

# spustí program
run:
	cd ../bin/; java Calc_GUI
