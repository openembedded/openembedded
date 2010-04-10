DESCRIPTION = "RXTX provides serial and parallel communication for Java applications"
LICENSE = "LGPL"
SECTION = "libs"
HOMEPAGE = "http://rxtx.org"

PR = "r3"

DEPENDS = "classpath classpath-tools-native"

inherit autotools java-library

SRC_URI = "\
    http://rxtx.qbang.org/pub/rxtx/${PN}-${PV}.zip \
    file://rxtx-fixes-from-debian.patch;patch=1 \
    "

do_removebinaries_append() {
	rm acinclude.m4
}

do_compile() {
  # Whatever configure detected it is completely unusable. So we override heavily.
  oe_runmake \
    JAVAH="gjavah -classpath \$(CLASSPATH) -d \$(DEST) -jni" \
    JAR=gjar \
    JAVAC="javac -classpath \$(CLASSPATH) -d \$(TOP)/ -O -source 1.3 -target 1.3" \
    JAVAINCLUDEDIR=${STAGING_INCDIR}/classpath \
		GLIBTOOL="${TARGET_SYS}-libtool --tag=CC"
}

do_install() {
  install -d ${D}/${libdir_jni}
  install -d ${D}/${datadir_java}

  oe_runmake install \
    RXTX_PATH="${D}/${libdir_jni}" \
    JHOME="${D}/${datadir_java}" \
		GLIBTOOL="${TARGET_SYS}-libtool"
}

do_stage() {
  oe_jarinstall -s RXTXcomm.jar
}

PACKAGES = "${JPN} lib${PN}-jni lib${PN}-dev lib${PN}-jni-dbg"

FILES_lib${PN}-jni = "${libdir_jni}/lib*.so"
FILES_lib${PN}-dev = "${libdir_jni}/lib*.la ${libdir_jni}/lib*.a"
FILES_lib${PN}-jni-dbg = "${libdir_jni}/.debug/lib*.so"

SRC_URI[md5sum] = "9290b4832d46199f8d798a531209640b"
SRC_URI[sha256sum] = "31db3852a86105766758975519b27d262407c96cacad4f34ad0de5aae26addd9"
