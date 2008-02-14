DESCRIPTION = "A Java-based logical analyzer for home use."
LICENSE = "GPL"
HOMEPAGE = "http://sump.org/projects/analyzer/"

PR = "r2"

inherit java

DEPENDS = "rxtx"
RDEPENDS = "java2-runtime classpath-awt librxtx-java"

SRC_URI = "\
    http://sump.org/projects/analyzer/downloads/la-src-${PV}.tar.bz2 \
    file://cp-run-fix.patch;patch=1 \
    file://client-makefile.patch;patch=1 \
    file://scrolling-capture-dialog.patch;patch=1 \
    "

S = "${WORKDIR}/LogicAnalyzer"

do_compile() {

  oe_runmake -C client all jar \
    JAR=gjar \
    JAVAH="gjavah -classpath \$(CLASSPATH) -d \$(DEST) -jni" \
    JAVAINCLUDEDIR=${STAGING_INCDIR}/classpath \
    JAVAC="javac -d \$(TOP)/ -O -source 1.3 -target 1.3" \
    JAVAC_FLAGS="-sourcepath . -bootclasspath ${STAGING_DATADIR_NATIVE}/classpath/glibj.zip -classpath ${STAGING_DATADIR}/java/RXTXcomm.jar"
    
  oe_java_simple_wrapper org.sump.analyzer.Loader analyzer.jar RXTXcomm.jar
}

do_install() {
  oe_jarinstall client/analyzer.jar

  install -d ${D}${bindir}
  install -m 0555 ${PN} ${D}${bindir}
}

PACKAGES = "${PN}"

FILES_${PN} = "${datadir_java}/analyzer.jar ${bindir}/${PN}"

PACKAGE_ARCH = "all"
