# Project Makefile
# Authours:	Taylor Bertie (tcbe803),
#		Andrew Reimers (andrewr),
#		Esther Mosad (emos958)
# Date: 2010-09-20

TGZ = ass3.tgz
MASTER = MazeTester.java
JC = javac
JFLAGS = -j
DOCC = javadoc
TESTER = echo "There is no tester implemented"
PACKC = tar
PACKFLAGS = -zcf $(TGZ)
TOPACK = *.java *.pdf doc *.txt

BIN = $(MASTER:.java=.class)

# PHONYS
.PHONY: clean doc rmdoc clobber test package submit

default: $(BIN)

$(BIN): clean
	$(JC) $(JFLAGS) $(MASTER)

$(TGZ): doc $(BIN)
	$(PACKC) $(PACKFLAGS) $(TOPACK)

doc:
	$(DOCC) -d $(DOCDIR) *.java

clean:
	rm -f *.class

rmdoc:
	rm -fdr $(DOCDIR)

clobber: rmdoc clean
	rm -f ass1.tgz

submit: ass1.tgz
	yes yes | give cs2911 ass1 ass1.tgz

test:
	$(TESTER)
