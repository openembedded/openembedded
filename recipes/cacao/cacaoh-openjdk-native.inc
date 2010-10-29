DESCRIPTION = "Header generator for Cacao JVM - Needed for cross-compilation builds"
HOMEPAGE = "http://www.cacaojvm.org/"
LICENSE  = "GPL"

DEPENDS = "libtool-native zlib-native virtual/javac-native classpath-native icedtea6-native"

S = "${WORKDIR}/cacao-${PV}"

inherit java autotools native

EXTRA_OECONF = " \
                --with-java-runtime-library=openjdk \
                --with-java-runtime-library-classes=${STAGING_LIBDIR_JVM_NATIVE}/icedtea6-native/jre/lib/rt.jar \
                --with-jni_md_h=${STAGING_INCDIR}/classpath \
                --with-jni_h=${STAGING_INCDIR}/classpath \
                --with-hpi_md_h=${STAGING_LIBDIR_JVM_NATIVE}/icedtea6-native/include/hpi \
                --with-hpi_h=${STAGING_LIBDIR_JVM_NATIVE}/icedtea6-native/include/hpi \
  "

do_compile() {
  # Compile the header generator only (and what is needed for it).
  oe_runmake -C src/toolbox libtoolbox.la
  oe_runmake -C src/vmcore libvmcore.la
  oe_runmake -C src/cacaoh cacaoh
}

do_install() {
	${STAGING_BINDIR_NATIVE}/${HOST_SYS}-libtool --mode=install install -m 0755 src/cacaoh/cacaoh ${STAGING_BINDIR}/cacaoh-openjdk-${PV}
}
