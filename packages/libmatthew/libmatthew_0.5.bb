DESCRIPTION = "Unix socket, debug and hexdump libraries"
LICENSE = "LGPL"
SECTION = "libs"
HOMEPAGE = "http://jalimo.org"
AUTHOR = "Matthew Johnson <web@matthew.ath.cx>"

inherit java-library

DEPENDS = "classpath-native classpath"

SRC_URI = "http://www.matthew.ath.cx/projects/java/libmatthew-java-${PV}.tar.gz"

S = "${WORKDIR}/libmatthew-java-${PV}"

do_compile() {
  oe_runmake \
    JCFLAGS="-source 1.5" \
    JAVAC="javac" \
    JAR="fastjar" \
    JAVAH="gjavah" \
  	INCLUDES="-I${STAGING_INCDIR}/classpath" \
    LDFLAGS="-fpic -shared -lc ${LDFLAGS}" \
    LD="${CC}"
}

do_stage() { 
  oe_jarinstall -s cgi-0.5.jar cgi.jar
	oe_jarinstall -s debug-disable-1.1.jar debug-disable.jar
	oe_jarinstall -s debug-enable-1.1.jar debug-enable.jar
	oe_jarinstall -s hexdump-0.1.jar hexdump.jar
	oe_jarinstall -s io-0.1.jar io.jar
	oe_jarinstall -s unix-0.2.jar unix.jar
}

do_install() {
  oe_jarinstall cgi-0.5.jar cgi.jar
	oe_jarinstall debug-disable-1.1.jar debug-disable.jar
	oe_jarinstall debug-enable-1.1.jar debug-enable.jar
	oe_jarinstall hexdump-0.1.jar hexdump.jar
	oe_jarinstall io-0.1.jar io.jar
	oe_jarinstall unix-0.2.jar unix.jar

  oe_libinstall -so libcgi-java ${D}${libdir}/jni
  oe_libinstall -so libunix-java ${D}${libdir}/jni
}

PACKAGES += "${PN}-jni ${PN}-jni-dbg"

RDEPENDS_${JPN} = "${PN}-jni"

FILES_${PN}-jni = "${libdir}/jni/lib*.so"
FILES_${PN}-jni-dbg = "${libdir}/jni/.debug/lib*.so"

