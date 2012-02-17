DESCRIPTION = "A compact Java Virtual Machine which conforms to the JVM specification version 2."
HOMEPAGE = "http://jamvm.sourceforge.net/"
LICENSE = "GPL"

DEPENDS = "zlib classpath virtual/javac-native libffi"
DEPENDS_virtclass-native = "zlib-native classpath-native ecj-initial-native libffi-native"

RDEPENDS_${PN} = "classpath"
RDEPENDS_${PN}_virtclass-native = ""

PROVIDES_virtclass-native = "virtual/java-native"
RPROVIDES_${PN} = "java2-runtime"
RPROVIDES_${PN}_virtclass-native = ""

BBCLASSEXTEND = "native"

SRC_URI = "${SOURCEFORGE_MIRROR}/jamvm/jamvm-${PV}.tar.gz \
            file://jamvm-jni_h-noinst.patch \
            file://libffi.patch \
          "


inherit java autotools update-alternatives

# This uses 32 bit arm, so force the instruction set to arm, not thumb
ARM_INSTRUCTION_SET = "arm"


EXTRA_OECONF = "--with-classpath-install-dir=${prefix} --libdir=${libdir}/jamvm --enable-ffi"

# Enforce usage of ecj-initial.
EXTRA_OEMAKE = "JAVAC=${STAGING_BINDIR_NATIVE}/ecj-initial \
                GLIBJ_ZIP=${STAGING_DATADIR_NATIVE}/classpath/glibj.zip \
               "

do_install_append_virtclass-native() {
	install -d ${D}${bindir}
	ln -s ${bindir}/jamvm ${D}${bindir}/java
}

PRIVATE_LIBS = "libjvm.so"

FILES_${PN} += "${libdir}/jamvm/lib*.so"

ALTERNATIVE_NAME = "java"
ALTERNATIVE_PATH = "${bindir}/jamvm"
ALTERNATIVE_PRIORITY = "4"

