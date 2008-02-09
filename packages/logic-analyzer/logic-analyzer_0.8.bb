DESCRIPTION = "A Java-based logical analyzer for home use."
LICENSE = "GPL"
MAINTAINER = "Robert Schuster, tarent GmbH Bonn <robert.schuster@tarent.de>"
HOMEPAGE = "http://sump.org/projects/analyzer/"

inherit java

DEPENDS = "rxtx"
RDEPENDS = "librxtx-java"

SRC_URI = "\
    http://sump.org/projects/analyzer/downloads/la-src-${PV}.tar.bz2 \
    file://cp-run-fix.patch;patch=1 \
    file://client-makefile.patch;patch=1 \
    "

S = "${WORKDIR}/LogicAnalyzer"

do_compile() {

  oe_runmake -C client all jar \
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
