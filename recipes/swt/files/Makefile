JAVA=swt-gtk-$(RELEASE).jar
LIBRARIES=libswt.so libswt-pi.so libswt-mozilla.so
CLEANFILES=*.files *.jar *.so* *-stamp

RELEASE=OE_SWT_RELEASE
SONAME_VERSION=OE_SWT_API_VERSION

GCJ=false
JAR=fastjar
JAVAC=javac -classpath .
LDCONFIG=/sbin/ldconfig
LN_S=ln -s
RM=rm -f

GCJFLAGS=-O2 -fPIC -fjni -shared

LINK=$(GCJ) $(GCJFLAGS) -o $@ -Wl,-soname=lib$*.so.$(SONAME_VERSION)

# Build without Jars
#all:
#	$(MAKE) -f make_linux.mak make_swt make_atk make_cairo

# Build with Jars 
all: $(JAVA) 
	$(MAKE) -f make_linux.mak make_swt make_atk make_cairo

# all: $(JAVA) $(LIBRARIES)
#	$(MAKE) -f make_linux.mak make_swt make_atk make_gnome make_mozilla

clean distclean:
	$(RM) $(CLEANFILES)
	$(RM) -r swt swt-pi swt-mozilla
	-$(MAKE) -f make_linux.mak clean

.PHONY: all clean distclean

swt.files:
	find org -name *.java \
		-not -path org/eclipse/swt/internal\* \
		-not -path org/eclipse/swt/browser\* | sort > $@

swt-mozilla.files:
	find org/eclipse/swt/browser org/eclipse/swt/internal/mozilla \
		-name *.java | sort > $@

swt-pi.files:
	find org/eclipse/swt/internal -name *.java \
		-not -path org/eclipse/swt/internal/mozilla\* | sort > $@

%-stamp: %.files
	mkdir -p $*
	for i in `cat $<`; do \
		if [ -e $*/$${i%java}class ]; then \
			echo SKIPPING $$i; \
		else \
			echo $(JAVAC) -d $* $$i; \
			$(JAVAC) -d $* $$i || exit $$?; \
		fi \
	done
	touch $@

%.jar: %-stamp
	$(JAR) -C $* -cf $@ .

lib%.so.$(RELEASE): %.jar
	$(LINK) $<
	$(LDCONFIG) -n .

%.so: %.so.$(RELEASE)
	$(LN_S) -f $< $@

swt-gtk-$(RELEASE).jar: swt.jar swt-pi.jar swt-mozilla.jar
	mkdir _jar
	cd _jar && for i in $^; do $(JAR) -xf ../$$i || exit $$?; done
	$(JAR) -C _jar -cf $@ org
	rm -rf _jar

.SECONDARY:
