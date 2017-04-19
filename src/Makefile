# Makefile, IVS, Lorem Ipsum
# Je potřeba dodělat doxygen (aby generoval PDF do ./doc/dokumentace.pdf)
# Make run si aktuálně stěžuje, že chybí main.

JC = javac
JFLAGS = -g
RM = rm -rf

GROUP_NAME = xstodu08_xolsak00_xsvand06_xschne07

JAVA_SRC = Calc_Lib.java CalcActionListener.java Main_Window.java
JAVA_DIR = src
COBJ_DIR = bin
JAR_NAME = IVS_Calc

LIB_TEST = Calc_LibTest.java
JUNIT = java -cp .:/usr/share/java/junit.jar org.junit.runner.JUnitCore

# přeloží projekt
all: IVS_Calc

.PHONY: pack clean test doc run IVS_Calc

# .java => .class => .jar
IVS_Calc:
	rm -rf ../$(COBJ_DIR)
	mkdir ../$(COBJ_DIR)
	cd ../$(JAVA_DIR)/pckg; $(JC) $(JFLAGS) -d ../../$(COBJ_DIR) $(JAVA_SRC)
	cd ../$(COBJ_DIR)/pckg; jar cvf ../$(JAR_NAME).jar *.class

# zabalí projekt tak aby mohl být odevzdán
pack: ../dokumentace.pdf
	$(RM) ../$(GROUP_NAME).zip
	$(RM) ../zip
	cd ..; zip -r repo.zip .
	mkdir ../zip ../zip/repo
	cd ..; mv repo.zip zip/repo/repo.zip; cd zip/repo; unzip repo.zip; rm repo.zip
	#mkdir ../zip/doc ; mv ../dokumentace.pdf zip/doc/dokumentace.pdf
	cd ../zip; mkdir doc; echo "" > doc/empty
	cd ../zip; mkdir install; echo "" > install/empty
	cd ../zip ; zip -r ../$(GROUP_NAME).zip .
	$(RM) ../zip

# vytvoří dokumentaci
../dokumentace.pdf: doc
	echo "Making doc..."

# smaže všechny soubory co nemají být odevzdány
clean:
	$(RM) ../bin ../zip ../doc

# spustí testy matematické knihovny
test:
	cd ../$(JAVA_DIR)/pckg; $(JUNIT) $(LIB_TEST)

# spustí generování dokumentace
doc:
	$(RM) ../doc ../dokumentace.pdf
	cd ../$(JAVA_DIR); doxygen Doxyfile
	mv ../doc/refman.pdf ../dokumentace.pdf
	$(RM) ../doc

# spustí program
run:
	cd ../bin; java $(JAR_NAME).jar
