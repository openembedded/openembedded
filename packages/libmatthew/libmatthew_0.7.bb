DESCRIPTION = "Unix socket, debug and hexdump libraries"
AUTHOR = "Matthew Johnson <web@matthew.ath.cx>"
HOMEPAGE = "http://www.matthew.ath.cx/projects/java"
SECTION = "libs"
LICENSE = "LGPL"
DEPENDS = "classpath-native classpath fastjar-native virtual/javac-native"
RDEPENDS_${JPN} = "${PN}-jni"
PR = "r0"

SRC_URI = "http://www.matthew.ath.cx/projects/java/libmatthew-java-${PV}.tar.gz \
           file://Makefile-0.7.patch;patch=1"

S = "${WORKDIR}/libmatthew-java-${PV}"

inherit java-library

do_compile() {
    oe_runmake \
        JCFLAGS="-source 1.5" \
        JAVAC="javac" \
        JAR="fastjar" \
        JAVAH="gjavah" \
        INCLUDES="-I${STAGING_INCDIR}/classpath" \
        LDFLAGS="-fpic -shared -lc ${LDFLAGS}" \
        LD="${CC}" \
        CFLAGS="-fpic -Wall -Os -pedantic -std=c99 -Werror"
}
do_install() {
    oe_jarinstall cgi-0.5.jar cgi.jar
    oe_jarinstall debug-disable-1.1.jar debug-disable.jar
    oe_jarinstall debug-enable-1.1.jar debug-enable.jar
    oe_jarinstall hexdump-0.2.jar hexdump.jar
    oe_jarinstall io-0.1.jar io.jar
    oe_jarinstall unix-0.4.jar unix.jar
    oe_libinstall -so libcgi-java ${D}${libdir_jni}
    oe_libinstall -so libunix-java ${D}${libdir_jni}
}
do_stage() {
    oe_jarinstall -s cgi-0.5.jar cgi.jar
    oe_jarinstall -s debug-disable-1.1.jar debug-disable.jar
    oe_jarinstall -s debug-enable-1.1.jar debug-enable.jar
    oe_jarinstall -s hexdump-0.2.jar hexdump.jar
    oe_jarinstall -s io-0.1.jar io.jar
    oe_jarinstall -s unix-0.4.jar unix.jar
}

PACKAGES += "${PN}-jni ${PN}-jni-dbg"

FILES_${PN}-jni = "${libdir_jni}/lib*.so"
FILES_${PN}-jni-dbg = "${libdir_jni}/.debug/lib*.so"
