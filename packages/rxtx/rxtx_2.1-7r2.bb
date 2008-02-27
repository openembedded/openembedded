DESCRIPTION = "RXTX provides serial and parallel communication for Java applications"
LICENSE = "LGPL"
SECTION = "libs"
HOMEPAGE = "http://rxtx.org"

PR = "r1"

DEPENDS = "classpath classpath-native virtual/javac-native"

inherit autotools java-library

SRC_URI = "\
    http://rxtx.qbang.org/pub/rxtx/${PN}-${PV}.zip \
    file://rxtx-fixes-from-debian.patch;patch=1 \
    "

do_compile() {
  # Whatever configure detected it is completely unusable. So we override heavily.
  oe_runmake \
    JAVAH="gjavah -classpath \$(CLASSPATH) -d \$(DEST) -jni" \
    JAR=gjar \
    JAVAC="javac -classpath \$(CLASSPATH) -d \$(TOP)/ -O -source 1.3 -target 1.3" \
    JAVAINCLUDEDIR=${STAGING_INCDIR}/classpath
}

do_install() {
  install -d ${D}/${libdir_jni}
  install -d ${D}/${datadir_java}

  oe_runmake install \
    RXTX_PATH=${D}/${libdir_jni} \
    JHOME=${D}/${datadir_java}
}

do_stage() {
  oe_jarinstall -s RXTXcomm.jar
}

PACKAGES = "${JPN} lib${PN}-jni lib${PN}-dev lib${PN}-jni-dbg"

FILES_lib${PN}-jni = "${libdir_jni}/lib*.so"
FILES_lib${PN}-dev = "${libdir_jni}/lib*.la"
FILES_lib${PN}-jni-dbg = "${libdir_jni}/.debug/lib*.so"
